using System;
using System.Collections.Generic;
using System.Linq;
using System.Timers;
using System.Text;

namespace Scanner
{
    class preSortingAlgorithm
    {
        Timer time;
        List<String> tmpList = new List<String>();
        int tmp = RFIDReader.TagList().Count();
        public preSortingAlgorithm()
        {
            Sort();
        }
        
        public void startSort()
        {
            time = new Timer();
            time.Elapsed += new ElapsedEventHandler(tagTimer);
            time.Interval = 200;
            time.Enabled = true;
        }

        private void Sort()
        {

        }

        private void tagTimer(object sender, EventArgs e)
        {

            while (true)
            {
                if (RFIDReader.TagList().Count() > tmp)
                {
                    tmpList = RFIDReader.TagList();
                }
            }        
        }


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
