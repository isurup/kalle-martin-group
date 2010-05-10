using System;
using System.Collections.Generic;
using System.Linq;
using System.Timers;
using System.Text;
using MySQLLibrary;

namespace Scanner
{
    class preSortingAlgorithm
    {
        MySQLConnection con;
        Functions f;
        string tag;
        Timer time;
        List<String> tmpList = new List<String>();
        //int tmp = RFIDReader.TagList().Count();
        public preSortingAlgorithm()
        {
            /*Admin*/
            con = new MySQLConnection("tek-sweat-2.tek.c.sdu.dk", "rsd1", "rsd1_admin", "3306", "qAhuF_3Uw#");
            f = new Functions(con);
            Sort();
        }

        public void startSort()
        {
            tag = "0234567890A1234567891230";
            String WashTemp = f.getClothesWashingTemp(tag);
            Console.Out.WriteLine(WashTemp);
            Console.In.ReadLine();
            /*time = new Timer();
            time.Elapsed += new ElapsedEventHandler(tagTimer);
            time.Interval = 200;
            time.Enabled = true;*/
        }

        private void Sort()
        {
            

        }

        /*private void tagTimer(object sender, EventArgs e)
        {

            while (true)
            {
                if (RFIDReader.TagList().Count() > tmp)
                {
                    tmpList = RFIDReader.TagList();
                }
            }        
        }*/


        private string tagColor(string Color)
        {

            
            return Color;
        }

        private string tagTemp(string Temp)
        {

            return Temp;
        }

        private string tagType(string Type)
        {

            return Type;
        }
    }
}
