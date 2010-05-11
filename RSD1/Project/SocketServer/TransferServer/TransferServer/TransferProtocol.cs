using System;
using System.Text;
using System.IO;
using System.Drawing;
using MySQLLibrary;


namespace TransferServer
{    
    public class TransferProtocol
    {
        
        //Reserved commands        
        public  const byte NULL = 0x00;

        public  const byte  LF = 0x0A;    //line feed, same as:      '\n'
        public const  byte  CR = 0x0D;    //cariage return, same as: '\r'

        public const byte DB_PROTOCOL        = 0xFE;//protocol type       

        //General Commands        
        public const byte  GET_BIN_NUMBER    = 0x11;
        public const byte  GET_TAG_ID        = 0x12;
        
        //Transferring commands
        public const byte  TRANSFER_FILE      = 0x77;
        public const byte  CREATE_FILE        = 0x70;
        public const byte  FLUSH_FILE         = 0x71;        
        public const byte  REMOVE_FILE        = 0x72;

        //Status Commands
        public const byte OK                  = 0x80;
        public const byte ERROR               = 0x81;
        public const byte TIME_OUT            = 0x82;

        //sizes        
        public const int COMMAND_SIZE         = 1;
        public const int TAG_ID_SIZE          = 24;
        public const int BIN_NUMBER_SIZE      = 4;

        MySQLConnection con;
        Functions f;

        public TransferProtocol()
        {
            /*Admin*/          con = new MySQLConnection("tek-sweat-2.tek.c.sdu.dk", "rsd1", "rsd1_admin", "3306", "qAhuF_3Uw#");
                               f = new Functions(con);
        }
        //test
        string[] ids = { "0234567890A1234567891230", "1234567890A1234567891231", "2224567890J1234B678912C2", "3204567890A123456F891233" };

        //string[] ids = { "0234567890A1234567891230", "1234567890A1234567891231"};

        //string[] ids = { "3204567890A123456F891233" };

        

        public void Start()
        {            
        }
        public void End()
        {   
        }

        public byte[] parsePacket(byte[] packet)
        {
            bool ok = false;
            int i = 0;
            byte[] data;
            while (!ok && i<packet.Length && packet[i]!=NULL) { 
                ok = accept(packet[i++], DB_PROTOCOL);
            }            
            if (!isCommand(packet[i])) { return null; }            
            data = parseCommand(packet,i);
            return data;
        }
       

        public byte[] parseCommand(byte[] data, int index)
        {
            string str = "";
            byte[] packet = null, temp_data = null;
            switch (data[index++])
            {
                //General Commands
                case GET_BIN_NUMBER:
                    {
                        //get 24 byte Tag ID
                        //send 4 byte BinId number
                        str = byteToString(data, index);
                        if (str.Length != 24) { Console.WriteLine("Tag ID != 24 byte"); return packet; }
                        float binID = f.getBinId(str);                        
                        temp_data = BitConverter.GetBytes(binID);
                        packet = new byte[COMMAND_SIZE + COMMAND_SIZE + BIN_NUMBER_SIZE];
                        append(ref packet, DB_PROTOCOL);
                        append(ref packet, GET_BIN_NUMBER);
                        append(ref packet, temp_data);
                        return packet;
                    }
                case GET_TAG_ID:
                    {
                        //get 4 byte scanner number
                        //return tag IDs
                        str = byteToString(data, index);//scanner number

                       
                        //str = con.SendMySqlCmd("SELECT id ");//return all IDs
                        if (ids.Length == 0) { Console.WriteLine("No Ids"); return packet; }

                        float size = ids.Length;

                        temp_data = convertTo24ByteData(ids);

                        packet = new byte[COMMAND_SIZE + COMMAND_SIZE+ 4 + (int)size*TAG_ID_SIZE];
                        byte[] size1 = new byte[4];

                         size1 = BitConverter.GetBytes(size);                         

                        append(ref packet, DB_PROTOCOL);
                        append(ref packet, GET_TAG_ID);
                        append(ref packet, size1,2*COMMAND_SIZE,size1.Length);
                        append(ref packet, temp_data, 2 * COMMAND_SIZE + size1.Length, temp_data.Length);                        
                        return packet;
                    }

                case TRANSFER_FILE:
                    {
                        StreamWriter sw;

                        switch (data[index++])
                        {
                            case CREATE_FILE:
                                {
                                    index++;//reserver cmd
                                    
                                    //str = byteToString(data, index, 4); //size of data elements
                                    int lenght = BitConverter.ToInt32(data, index);//int.Parse(str);
                                    str = byteToString(data, index + 4, lenght);//path + file name
                                    sw = new StreamWriter(str);
                                    sw.Close();
                                    Console.Out.WriteLine("Create File");
                                    return null;
                                }
                            case FLUSH_FILE:
                                {
                                    index++;//reserver cmd
                                    Console.Out.WriteLine("Flush File");
                                    return null;
                                }
                            case REMOVE_FILE:
                                {
                                    index++;//reserver cmd
                                    Console.Out.WriteLine("Remove File");
                                    return null;
                                }
                        }

                        packet = new byte[data.Length];
                        copyBytes(ref packet, data, index);
                        //MemoryStream stream = new MemoryStream(packet);
                        Stream  stream = new MemoryStream(packet);                        
                        Bitmap image = new Bitmap(stream);
                        
                        image.Save("C:\\aaaa.bmp");
                        Console.WriteLine("Save Picture");
                        return null;
                    }

            }
            return null;
        }
        private bool isCommand(byte cmd)
        {
            switch (cmd)
            {
                //Reserved commands
                case DB_PROTOCOL:

                //General Commands
                case GET_BIN_NUMBER:
                case GET_TAG_ID:
                case TRANSFER_FILE: { return true; }
            }
            return false;
        }       


        private byte[] copyBytes(ref byte[] to, byte[] from, int start_index)
        {
            if (to == null) { return null; }
            if (from == null) { return null; }

            if (to.Length < from.Length) { return null; }

            int i = 0;
            while ((i + start_index) < to.Length)
            {
                to[i] = from[start_index+ i];
                i++;
            }
            return to;         
        }
        private byte[] convertTo24ByteData(string[] data)
        {
            if (data == null) { return null; }
            if (data.Length == 0) { return null; }
                        
            char[] values = new char[TAG_ID_SIZE];
            byte[] data_temp = new byte[TAG_ID_SIZE * data.Length];

            for(int i = 0; i < data.Length; i++){                
                char[] temp=  data[i].ToCharArray();



                for (int x = 0; x < temp.Length; x++)
                {
                    values[x] = temp[x];
                }
                
                if (values == null) { return null; }

                for(int j = 0; j < TAG_ID_SIZE; j++){
                    data_temp[i * TAG_ID_SIZE + j] = (byte)values[j];
                }
            }            
            return data_temp;
        }
        private bool accept(byte cmd, byte expected_cmd)
        {            
            if ( isCommand(cmd) && (cmd==expected_cmd) ) {return true;}
            return false;
        }

        private byte[] append(ref byte[] where, byte[] from, int start, int size)
        {
            if (where == null) { return null; }
            if (from == null) { return where; }

            if (where.Length <= from.Length) { return where; }

            int index = start, i = 0;


            while (size > i)// || where != null || from != null
            {
                where[index + i] = from[i];
                i++;
            }
            return where;
        }

        private byte[] append(ref byte[] where, byte from)
        {
            if (where == null) { return null; }
            if (from == 0) { return where; }
            if (where.Length <= 0) { return where; }

            int index = 0;
            while (where[index] != NULL) {
                index++;
            }
            where[index] = from;
            return where;
        }
        private byte[] append(ref byte[] where, byte[] from)
        {
            if (where == null) { return null; }
            if (from == null) { return where; }

            if (where.Length <= from.Length) { return where; }

            int index =0, i = 0;
            while (where[index] != NULL)// || where != null
            {
                index++;
            }

            while( i< from.Length )// || where != null || from != null
            {
                where[index + i] = from[i];
                i++;
            }
            return where;
        }
        private byte[] stringToByte(string str)
        {
            if (str == null) {  return null;  } 
            if (str.Length == 0) { return null; }

            int i = 0;
            byte[] data = new byte[str.Length];            
            
            while (str != null && i < str.Length)
            {
                data[i] = (byte)str[i];
                i++;
            }
            return data;
        }
        private string byteToString(byte[] data, int from, int lenght)
        {
            if (data == null) { return null; }
            if (data.Length == 0) { return null; }
            if (from > data.Length) { return null; }
            if (from + lenght > data.Length) { return null; }

            string str = "";

            int i = 0;
            while (i < lenght)
            {
                str += (char)data[from + i];
                i++;
            }
            return str;
        }
        private string byteToString(byte[] data, int index)
        {
            if (data == null) { return null; }
            if (data.Length == 0) { return null; }
            if (index > data.Length) { return null; }

            string str = "";

            int i = 0;
            while (data[index+i] != NULL)
            {
                str += (char)data[index+i];
                i++;
            }
            return str;
        }
        private string byteToString(byte[] data) {
            if (data == null) { return null; }
            if (data.Length == 0) { return null; }

            string str = "";
            
            int i =0;
            while (data[i] != NULL)
            {
                str+= (char)data[i];
                i++;
            }
            return str;
        }        

        

    }
}

