using System;
using System.Collections.Generic;
using System.Text;
using System.Timers;
using Scanner;

namespace Reader
{
    class runReader
    {

        Timer time;
        RFIDReader rr = new RFIDReader();
        public void startReading()
        {
            time = new Timer();
            /** Opens a connection with COM5, this of course depends on how the scanner is connected to the computer
             * * The cloths will probably have tags of the EPC GEN 2, therfore the method must be called with EPC
             * */
            rr.CommPortSetUp(9600, "COM5", 10, "EPC"); 
            rr.ReadFromSingleAntenna(1);              
            if (rr.OpenCompConnection())
            {
              
                rr.MultiTagRead();
                time.Elapsed += new ElapsedEventHandler(timer_tick);
                time.Interval = 200;
                time.Enabled = true;
            }
            else
            {
                Console.WriteLine("No connection established");
            }
     
        }

        //Timer that will retreive the tag list every 200ms
        public void timer_tick(object sender, EventArgs e)
        {
            List<String> tagID = new List<String>();

            tagID = rr.TagList();
            if (tagID != null)
            {
                Console.WriteLine("No of Tags read " + rr.GetNumberOfTagID());
                for (int i = 0; i < tagID.Count; i++)
                {
                    Console.WriteLine(tagID[i]);
                }
            }
            else
            {

                Console.WriteLine("No data stored");
            }


        }
    }
}
