using System;
using System.Collections;
using System.Text;
using System.Windows.Forms;


namespace SorterLib
{
    public class Algorithm
    {
        Bins bins;
        ArrayList sd;//sensitiy Data
        ArrayList cvd;//ClothesValueData

        public Algorithm(ArrayList sd, ArrayList cvd)
        {
            bins = new Bins();            
            this.sd = sd;
            this.cvd = cvd;
        }
        public Algorithm()
        {
            bins = new Bins();            
        }



        //gets how many clothes(of particular type) fits on waching mashine
        private int getClotheValue(Clothes c)
        {
            if (c == null) { return 0; }
            if(cvd == null) { return 0; }

            for (int i = 0; i < cvd.Count; i++)//koefficients
                {
                    ClothesValueData k = (ClothesValueData)cvd[i];                
                    if (c.type == k.type) {
                        return k.numberOfClothes;
                    }
            }
            return 0;
        }


        private int getwMashineValue()
        {   
            return 100;//percent
        }

        //how need to wash particular type of clothes (colored,synthetic, 40degree)
        public double washCount(object clothes, Bin bin)
        {
            if (clothes == null) { return 0; }
            if (cvd == null) { return 0; }
            if (bin == null) { return 0; }

            int total_value = getTotalClothesValue(clothes, bin);
            int max_value = getwMashineValue();
            double count = (max_value - total_value);//fix here

            return count;
        }


        //gets total value of particular type of clothes (colored,synthetic, 40degree)
        private int getTotalClothesValue(object clothes,Bin bin)
        {
            if (clothes == null) { return 0; }
            if (cvd == null) { return 0; }
            if (bin == null) { return 0; }
            ArrayList data = (ArrayList)clothes;            
            double total_value = 0;

            for (int i = 0; i < data.Count; i++)//clothes
            {                
                Clothes c = (Clothes)data[i];
                if ( (int)c.color == bin.color && (int)c.wTemperature == bin.wTemp && (int)c.fabric == bin.fabric)
                {
                    int kx = getClotheValue(c);
                    if(kx!=0)
                    total_value += (double)100 / kx;
                }
            }
            return (int)total_value;
        }

        /// <summary>
        /// Returns numbers of bins required 
        /// </summary>
        /// <param name="clothes"></param>
        /// <returns></returns>
        /// 
        /*
        public int getBinNumber(object clothes)
        {
            ArrayList data = (ArrayList)clothes;

            Clothes c = (Clothes)clothes;
            int bin = 1;
            for (int i = 0; i < 100; i++)
            {
             //   if (c.color == eColor.Colored)
                    c.bin = bin; 

                    switch (c.fabric)
                    {
                        case eFabric.Cotton: { break; }
                        case eFabric.Synthetic: { break; }
                        case eFabric.Wool: { break; }
                    };



                    switch (c.wTemperature)
                    {
                        case eWachingTemperature.Degree30: { break; }
                        case eWachingTemperature.Degree40: { break; }
                        case eWachingTemperature.Degree60: { break; }
                        case eWachingTemperature.Degree95: { break; }
                        case eWachingTemperature.Handwash: { break; }
                    };               
            }
            return 0;
        }
   
               */

        public int getNumberOfClothes(Bins b)
        {
            if (b == null) { return -1; }
            int total=0;
            Bin[] bn = b.getBins();
            for (int i = 0; i < b.Count; i++)
            {
                total += bn[i].numberOfClothes;
            }
            return total;
        }

        public Bins createBinIDs(object clothes)
        {
            ArrayList data = (ArrayList)clothes;

            for (int i = 0; i < data.Count; i++)
            {
                Clothes c =  (Clothes)data[i];
                if (!isBin(c, bins))
                {
                    bins.AddBin(((int)c.color), ((int)c.wTemperature), ((int)c.fabric));                  
                }
            }
            return bins;
        }

        public Bins fillBins(object clothes, Bins b)
        {
            if (clothes == null) { return null; }
            if (b == null) { return null; }

            Bin[] bn = b.getBins();
            ArrayList data = (ArrayList)clothes;

            for (int i = 0; i < data.Count; i++)
            {
                Clothes c = (Clothes)data[i];

                for (int j = 0; j < b.Count; j++)
                {
                    if ((int)c.color == bn[j].color && (int)c.wTemperature == bn[j].wTemp && (int)c.fabric == bn[j].fabric)
                    {
                        bn[j].numberOfClothes++;
                    }
                }
            }
            return b;
        }

        private int compare(object o1, object o2)
        {
            ArrayList d1 = (ArrayList)o1;
            ArrayList d2 = (ArrayList)o2;
            int cnt = 0;
            for (int i = 0; i < d1.Count; i++)
            {
                Clothes c1 = (Clothes)d1[i];
                for (int j = 0; j < d2.Count; j++)
                {
                    Clothes c2 = (Clothes)d2[j];
                    //rules
                    if (c1.color == c2.color && c1.wTemperature == c2.wTemperature && c1.fabric == c2.fabric && c2.enable==true)
                    {                        
                        ((Clothes)d2[j]).enable = false;                        
                        cnt++;
                        break;
                    }
                }
            }
            return cnt;
        }
        private bool isBin(Clothes c, Bins b)
        {
            Bin[] bn = bins.getBins();
            for (int i = 0; i < bins.Count; i++)
            {
                if ((int)c.color == bn[i].color && (int)c.wTemperature == bn[i].wTemp && (int)c.fabric == bn[i].fabric)
                {
                    return true;
                }
            }
            return false;
        }


        public string tostr()
        {
            Bin[] bn = bins.getBins();
            String str = "Bin number: " + bins.Count + "\r\n";
            str += "--------------------------------------" + "\r\n";
            for (int i = 0; i <= bins.Count; i++)
            {
                str += "[" + 1 + "], " + (eColor)bn[i].color + ", " + (eWachingTemperature)bn[i].wTemp + ", " + (eFabric)bn[i].fabric + ", \tcount:" + bn[i].numberOfClothes + "\r\n";

            }
            return str;
        }


        public override string ToString()
        {
            Bin[] bn = bins.getBins();
            String str =  "Bin number: " + bins.Count + "\r\n";
            str += "--------------------------------------" + "\r\n";            
            for(int i =0;i<=bins.Count;i++)            
            {
                str += "["+1 + "], " + (eColor)bn[i].color + ", " + (eWachingTemperature)bn[i].wTemp + ", " + (eFabric)bn[i].fabric + ", \tcount:" + bn[i].numberOfClothes + "\r\n";

            }            
            return str ;
        }

    }
}

