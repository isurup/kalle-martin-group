using System;
using System.Collections.Generic;
using System.Linq;
using System.Timers;
using System.Text;
using MySQLLibrary;
using SorterLib;

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

            setBinId(tag, 12);

            Console.Out.WriteLine(tagTemp(tag));
            Console.Out.WriteLine(tagColor(tag));
            Console.Out.WriteLine(tagType(tag));
            Console.Out.WriteLine(getBinId(tag));
            Console.In.ReadLine();
            time = new Timer();
            time.Elapsed += new ElapsedEventHandler(tagTimer);
            time.Interval = 3000;
            time.Enabled = true;
        }

        public  void Sort(List<string> sortList)
        {
            //List<String> tmpList = new List<String>();
            

            //sortList is list of tagIds

            Algorithm a = new Algorithm();


            Bins bins = a.createBinIDs(sortList);

            Bin[] currentBin = bins.getBins();

            for (int i = 0; i < bins.Count; i++)
            {

                setBinId("tagId", currentBin[i].binID);
               
            }
            

        }

        private void tagTimer(object sender, EventArgs e)
        {
                if (RFIDReader.TagList().Count() > tmp)
                {
                    tmpList = RFIDReader.TagList();
                    Sort(tmpList);
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

        private void setBinId(string tag, int BinNr)
        {
            f.setBinId(tag, BinNr);
        }

        private int getBinId(string tag)
        {
            return f.getBinId(tag);
        }
    }
}