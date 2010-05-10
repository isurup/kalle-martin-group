using System;
using System.Collections.Generic;
using System.Text;
using System.Timers;
using RfidApiLib;


namespace Scanner
{
	class RFIDReader
	{
		
        private Timer isoReadTimer;
        private Timer epcReadTimer;
        private static List<String> tagIDlist;
        private RfidApi rfidAPI = new RfidApi();
        private String isoCard = "ISO";
        private String epcCard = "EPC";
        private int TagCounter { get; set; }
        private int Buadrate { get; set; }
        private String Commport { get; set; }
        private int TimerInterval { get; set; }
        private int Port { get; set; }
        private String Ip_addr { get; set; }
        private byte IsoRead { get; set; }
        private byte EpcRead { get; set; }

		public RFIDReader()
		{
			IsoRead =0;
		    TagCounter =0;
            EpcRead = 0;
			tagIDlist = new List<String>();
            isoReadTimer = new Timer();
            epcReadTimer = new Timer();

		}
       	
		/**********************Communication*************************************/
         /// <summary>
        ///  This method sets up the communcation for using a commport.
        /// </summary>
        /// <param name="buadrate">Sets the baudrate</param>
        /// <param name="commport">The commport used to connect to the Scanner</param>
        /// <param name="timerInterval">Timer interval for when the scanner shall read tags</param>
        /// <param name="cardType">Sets the card type, either EPC or ISO</param>
        public void CommPortSetUp(int buadrate, String commport, int timerInterval, String cardType)
			{
                if (cardType.Equals(isoCard))
                {
                    IsoRead = 1;
                    EpcRead = 0;
                }
                else if (cardType.Equals(epcCard))
                {
                    EpcRead = 1;
                    IsoRead = 0;
                }

               Buadrate = buadrate;
               Commport = commport;
               TimerInterval = timerInterval;
			}

       /// <summary>
        /// This method sets up the communcation for using the TCP connection
       /// </summary>
        /// <param name="timerInterval">Timer interval for when the scanner shall read tags</param>
        /// <param name="ip">The IP-addr used to connect to the Scanner</param>
        /// <param name="port">Sets the port of the ip connection</param>
        /// <param name="cardType">Sets the card type, either EPC or ISO</param>
        public void TCPSetUp(int timerInterval, String ip, int port, String cardType)
        {

            if (cardType.Equals(isoCard))
            {
                IsoRead = 1;
                EpcRead = 0;
            }
            else if (cardType.Equals(epcCard))
            {
                EpcRead = 1;
                IsoRead = 0;
            }

            TimerInterval = timerInterval;
            Ip_addr = ip;
            Port = port;
        }

        ///<summary>
        ///This method is used to open a connection to the RFID scanner.
        /// Buadrate and compport should be set before openning the connection, <see cref="CommPortSetUp"/>.
        /// </summary>
        /// <returns>The method will return true iff the connection is established</returns>
        
		public Boolean OpenCompConnection()
		{
			int status = 0;
			byte v1 =0;
			byte v2 =0;
            tagIDlist.Clear();
			status = rfidAPI.OpenCommPort(Commport);
			if (status != 0)
			{
				return false;
			}
			 status = rfidAPI.GetFirmwareVersion(ref v1, ref v2);
			if (status != 0)
			{
				rfidAPI.CloseCommPort();
                return false;
			}
			
			return true;
		}
		
		 ///<summary>
		/// This method closes the connection to the commport
        ///</summary>
		public void CloseConnection()
		{
			rfidAPI.CloseCommPort();
  
		}
		
		
		 ///<summary>
		/// This method is used to open a connection to the RFID scanner, with the use of an TCP/IP connection.
		///IP and port should be set before trying to open a connection.
        ///<returns>The method will return true iff a connection is established</returns>
        ///</summary>

		public bool OpenTCPConnection()
		{
			int status =0;
			byte v1 = 0;
			byte v2 = 0;
			status = rfidAPI.TcpConnectReader(Ip_addr, Port);
			if (status != 0)
			{
				return false;
			}
			status = rfidAPI.GetFirmwareVersion(ref v1, ref v2);
            if (status != 0)
            {
                rfidAPI.TcpCloseConnect();
                return false;
            }
			return true;
		}
		
		///<summary>
		/// This method closes the TCP/IP connection to the RFIDScanner.
        /// </summary>
		
		public void CloseTCPConnection()
		{
			rfidAPI.TcpCloseConnect();
		}
		
		/**********************Communication end*************************************/
		
		/**********************Read operations**************************************/
		
		/// <summary>
        /// This method reads mutliple tags according to what time interval and and card type set in, <see cref="commPortSetUp"/> or <see cref="TCPSetUp"/>.
		/// </summary>
		public void MultiTagRead()
		{
			if (IsoRead ==1)
			{
				rfidAPI.ClearIdBuf();
				tagIDlist.Clear();
				TagCounter=0;
                isoReadTimer.Elapsed += new ElapsedEventHandler(IsoTimerRead_tick);
				isoReadTimer.Interval =TimerInterval;
				isoReadTimer.Enabled = true;
				IsoRead = 0;
			}
            else if (EpcRead == 1)
            {
                rfidAPI.ClearIdBuf();
                tagIDlist.Clear();
                TagCounter = 0;
                epcReadTimer.Elapsed += new ElapsedEventHandler(EpcTimerRead_tick);
                epcReadTimer.Interval =TimerInterval;
                epcReadTimer.Enabled = true;
                EpcRead = 0;
            }
            else
            {
                epcReadTimer.Enabled = false;
                isoReadTimer.Enabled = false;
                IsoRead = 0;
                EpcRead = 0;
            }
		}
		
		///<summary>
		///This method returns a string list of tagID
		///</summary>
        ///<returns>Returns a list of strings</returns>
		public static List<String> TagList()
		{
            try
            {
                return tagIDlist;
            }
            catch (System.NullReferenceException e)
            {
                System.Console.WriteLine(e.Message);
                return null;
            }
		}
      
      
        /// <summary>
        /// Get the number of how many tags just read
        /// </summary>
        /// <returns>Number of tags</returns>
		public int GetNumberOfTagID()
		{
				try
				{
					return tagIDlist.Count;
				}
                catch (System.NullReferenceException e)
				{
					System.Console.WriteLine(e.Message);
					return 0;
				}
		} 
		
		private void IsoTimerRead_tick(object sender, EventArgs e)
		{
			int status;
			byte[,] IsoBuf = new byte[100,14];
			byte tag_cnt = 0;
			String s= "";
            String s1 = "";
			rfidAPI.ClearIdBuf();
			status = rfidAPI.IsoMultiTagIdentify(ref IsoBuf, ref tag_cnt);
			if (status != 0)
			{
				return;
			}
			
			if (tag_cnt >0)
			{
				for (int i=0;i<tag_cnt;i++)
				{
					for (int j = 0; j < 8; j++)
                    {
                        s = string.Format("{0:X2} ", IsoBuf[i, j]);
                        s1 += s;
                    }
					StoreTags(s1);
				}
			}	
		}



        private void EpcTimerRead_tick(object sender, EventArgs e)
        {
            int status;
            byte[,] epcBuf = new byte[100, 24];
            byte tag_cnt = 0;
            byte tag_flag = 0;
            String s = "";
            String s1 = "";
            rfidAPI.ClearIdBuf();
            status = rfidAPI.EpcMultiTagIdentify(ref epcBuf, ref tag_cnt, ref tag_flag);
            if (status != 0)
            {
                return;
            }

            if (tag_cnt > 0)
            {
                for (int i = 0; i < tag_cnt; i++)
                {
                    for (int j = 0; j < 24; j++)
                    {
                        s = string.Format("{0:X2} ", epcBuf[i, j]);
                        s1 += s;
                    }
                    Console.WriteLine(s1);
                    StoreTags(s1);
                }
            }
        }
		
		/// <summary>
        /// This method stores only new tags
		/// </summary>
		/// <param name="s"></param>
		private void StoreTags(String s)
		{
			if (!tagIDlist.Contains(s))
			{
                tagIDlist.Add(s);
			}
		}
	
		
		
		
		/**********************RFID Operations***************************************/


         /// <summary>
        /// This method sets what antenna the scanner shall read from
        /// </summary>
        /// <param name="antenna">The antenna the Scanner shall read from</param>
        /// <returns>The method will return true iff the antenna is set</returns>
		public bool ReadFromSingleAntenna(int antenna)
		{
			byte ant_sel = 0;
            int status;
			switch (antenna)
			{
				case 1:
				 ant_sel |= 0x01;
				break;
				case 2:
				 ant_sel |= 0x02;
				break;
				case 3:
				 ant_sel |= 0x04;
				break;
				case 4:
				ant_sel |= 0x08;
				break;
				default:
				break;
			}
			
			 status = rfidAPI.SetAnt(ant_sel);
			if (status != 0)
			{
				return false;
			}
			return true;
		}

        
        /// <summary>
        /// Method is used if it is wanted to read from all the antennas connected to the Scanner.
        /// </summary>
        /// <returns>The method will return true iff the antenna is set</returns>
    	  public bool ActivateAllAntennas()
	        {
	            int status = 0;
	            byte ant_sel = 0;

	            ant_sel |= 0x01;
	            ant_sel |= 0x02;
	            ant_sel |= 0x04;
	            ant_sel |= 0x08;

	            status = rfidAPI.SetAnt(ant_sel);

	            if (status != 0)
	            {
					return false;
	            }
				return true;
	        }
		
		/**********************RFID Operations end***************************************/
}
}