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
        public preSortingAlgorithm()
        {
            Sort();
        }
        
        public void startSort()
        {
            int tmp = RFIDReader.TagList().Count();

            List<String> tmpList = new List<String>();
            time = new Timer();
            time.Elapsed += new ElapsedEventHandler(tagTimer);
            time.Interval = 200;
            time.Enabled = true;

            while(true)
            {
                if (RFIDReader.TagList().Count() > tmp)
                {
                    tmpList = RFIDReader.TagList();
                }
            }
        }

        private void Sort()
        {
        }

        private void tagTimer(object sender, EventArgs e)
        {
        
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
