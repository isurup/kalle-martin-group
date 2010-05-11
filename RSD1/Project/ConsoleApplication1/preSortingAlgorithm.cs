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
        int BinSize = 100;
        int BinNumber = 0;
        MySQLConnection con;
        Functions f;

        Timer time;
        List<String> tmpList = new List<String>();
        int tmp;
        public preSortingAlgorithm()
        {
            /*Admin*/
            con = new MySQLConnection("tek-sweat-2.tek.c.sdu.dk", "rsd1", "rsd1_admin", "3306", "qAhuF_3Uw#");
            f = new Functions(con);
            tmp = RFIDReader.TagList().Count();
        }

        public void startSort()
        {
            string tag = "0234567890A1234567891230";
            f.setBinId(tag, 12);

            int ClothesBin = f.getBinId(tag);
            
            Console.Out.WriteLine(tagTemp(tag));
            Console.Out.WriteLine(tagColor(tag));
            Console.Out.WriteLine(tagType(tag));
            Console.Out.WriteLine(ClothesBin);
            Console.In.ReadLine();
            time = new Timer();
            time.Elapsed += new ElapsedEventHandler(tagTimer);
            time.Interval = 3000;
            time.Enabled = true;
        }

        public static void Sort(List<string> sortList)
        {
            

        }

        private void tagTimer(object sender, EventArgs e)
        {
                if (RFIDReader.TagList().Count() > tmp)
                {
                    tmpList = RFIDReader.TagList();
                }      
        }

        private string tagColor(string tag)
        {
            string ClothesColor = f.getClothesColor(tag);
            return ClothesColor;
        }

        private string tagTemp(string tag)
        {
            string WashTemp = f.getClothesWashingTemp(tag);
            return WashTemp;
        }

        private string tagType(string tag)
        {
            string ClothesType = f.getClothesType(tag);
            return ClothesType;
        }
    }
}