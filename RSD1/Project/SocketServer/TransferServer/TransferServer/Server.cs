using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Text;

namespace TransferServer
{
    class Server
    {
        Socket m_socListener;
        byte[] m_DataBuffer = new byte[10];
        public AsyncCallback pfnCallBack;

        public Server()
        {
        }

        public void startListeningAsync(int port)
        {
            try
            {
                m_socListener = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                IPEndPoint ipLocal = new IPEndPoint(IPAddress.Any, port);
                m_socListener.Bind(ipLocal);
                m_socListener.Listen(4); //4 is maximum length of pending incomming connections                
                m_socListener.BeginAccept(new AsyncCallback(OnClientConnect), null);

            }
            catch (SocketException se)
            {

                Console.WriteLine(se.Message);
            }
        }

        public void OnClientConnect(IAsyncResult asyn)
        {         
            Socket m_socWorker;
            try
            {
                m_socWorker = m_socListener.EndAccept(asyn);//Accept connection and handover responsibility to worker socket                
                WaitForData(m_socWorker);
                m_socListener.BeginAccept(new AsyncCallback(OnClientConnect), null);//Listening thread returns to listening (now the incomming connection is handled by the Worker)
            }
            catch (ObjectDisposedException)
            {
                System.Diagnostics.Debugger.Log(0, "1", "\n OnClientConnection: Socket has been closed\n");
            }
            catch (SocketException se)
            {
                Console.WriteLine(se.Message);
            }
        }

        public void WaitForData(Socket socWorker)//Specifies what to do when data arrives
        {
            if (pfnCallBack == null)
            {
                pfnCallBack = new AsyncCallback(OnDataReceived);
            }
            SocketPacket socPacket = new SocketPacket(socWorker);   // now start to listen for any data...
            socWorker.BeginReceive(socPacket.DataBuffer, 0, socPacket.DataBuffer.Length, SocketFlags.None, pfnCallBack, socPacket);
        }

        //do this when data arrives
        public void OnDataReceived(IAsyncResult asyn)
        {
            SocketPacket socPacket = (SocketPacket)asyn.AsyncState;   //end receive...
            byte[] packet = null;

            ///m_socListener.BeginAccept(new AsyncCallback(SendData), null);//RJ

            try
            {
                int iRx = socPacket.MySocket.EndReceive(asyn);
                TransferProtocol session = new TransferProtocol();
                
                for (int i = 0; i < iRx; i++) //This will print the received message directly to the console in the HEX format:
                {                    
                    Console.Write("0x");
                    Console.Write(socPacket.DataBuffer[i].ToString("X"));
                    Console.Write(" ");
                    
                }
                
                    Socket toClient = socPacket.MySocket;
                    packet = session.parsePacket(socPacket.DataBuffer);
                    if (packet != null)
                    {
                        //Console.Out.WriteLine("");
                        printPacket(packet);
                        toClient.Send(packet);
                    }
                WaitForData(socPacket.MySocket);//Waiting for more incoming data...                
            }
            catch (SocketException se)
            {
                if (se.ErrorCode == 10054)    // Error code for Connection reset by peer
                {
                    Console.WriteLine("Connection closed by peer");
                    socPacket.MySocket = null;
                    socPacket = null;
                }
                else
                {
                    Console.WriteLine(se.Message);
                }
            }
        }
        private void printPacket(byte[] data)
        {
            int i =0;
            Console.Out.WriteLine();
            while(i < data.Length)
            {

                Console.Write("0x");
                Console.Write(data[i].ToString("X"));
                Console.Write(" ");              
                i++;
            }
            Console.Out.WriteLine();
        }

        /*
                /////////////////////////TEST///////////////////////////////
                Console.WriteLine("Client connected");
                Console.WriteLine("Sending 0x11 , 0x55 , 0x55 , 0x55, ...");
                byte[] byData = new byte[7];
                byData[0] = 0x11;
                byData[1] = 0x55;
                byData[2] = 0x95;
                byData[3] = 0x55;
                byData[4] = 0x77;
                byData[5] = 0x59;
                byData[6] = 0xE9;

                m_socWorker.Send(byData);
                /////////////////////////TEST///////////////////////////////

                //Let worker socket wait for incoming data
                */


    }
}
