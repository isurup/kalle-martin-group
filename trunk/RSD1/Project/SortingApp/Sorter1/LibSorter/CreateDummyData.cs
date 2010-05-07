using System;
using System.Collections;
using System.Text;

namespace SorterLib
{
    public class CreateDummyData
    {
        ArrayList data;
        public CreateDummyData()
        {
            data = new ArrayList();          
        }
        /*
        public object createData1()
        {
            //Colored               
            data.Add(new Clothes(0, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(1, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(2, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(3, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(4, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Cotton));
            
            data.Add(new Clothes(5, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(6, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(7, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(8, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(9, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Synthetic));

            data.Add(new Clothes(10, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(11, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(12, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(13, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(14, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Wool));
            
            
            //White
            data.Add(new Clothes(0, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(1, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(2, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(3, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(4, eClotheType.BedLinen, eColor.White, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Cotton));

            data.Add(new Clothes(5, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(6, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(7, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(8, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(9, eClotheType.BedLinen, eColor.White, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Synthetic));

            data.Add(new Clothes(10, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(11, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(12, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(13, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(14, eClotheType.BedLinen, eColor.White, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Wool));

            return data;
        }*/

        /*
        public object createData2()
        {
            //Colored               
            data.Add(new Clothes(0, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(1, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(2, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(3, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(4, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Cotton));

            //Colored               
            data.Add(new Clothes(0, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(1, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(2, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(3, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(4, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Cotton));


            data.Add(new Clothes(5, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(6, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(7, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(8, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(9, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Synthetic));

            data.Add(new Clothes(10, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(11, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(12, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(13, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(14, eClotheType.BedLinen, eColor.Colored, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Wool));


            //White
            data.Add(new Clothes(0, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(1, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(2, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(3, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Cotton));
            data.Add(new Clothes(4, eClotheType.BedLinen, eColor.White, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Cotton));

            data.Add(new Clothes(5, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(6, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(7, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(8, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(9, eClotheType.BedLinen, eColor.White, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Synthetic));

            data.Add(new Clothes(10, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(11, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(12, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(13, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Wool));
            data.Add(new Clothes(14, eClotheType.BedLinen, eColor.White, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Wool));

            //w
            data.Add(new Clothes(5, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree30, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(6, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree40, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(7, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree60, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(8, eClotheType.BedLinen, eColor.White, eWachingTemperature.Degree95, eDryRecipe.HangDry, eFabric.Synthetic));
            data.Add(new Clothes(9, eClotheType.BedLinen, eColor.White, eWachingTemperature.Handwash, eDryRecipe.HangDry, eFabric.Synthetic));


            return data;
        }
        */

        public object createData(int values)
        {
            int type;
            int color;
            int wTemperature;
            int fabric;
            int handDry;
            
            Random r = new Random();
            for (int i = 0; i < values; i++)
            {

                type = r.Next((int)eAllData.Sweater, (int)eAllData.BedLinen + 1);
                color = r.Next((int)eAllData.Colored, (int)eAllData.White + 1);
                wTemperature = r.Next((int)eAllData.Degree30, (int)eAllData.Handwash + 1);
                fabric = r.Next((int)eAllData.Cotton, (int)eAllData.Wool + 1);
                handDry = r.Next((int)eAllData.HangDry, (int)eAllData.Tumbling);
              
                 data.Add(   new Clothes(i, 
                        type,
                        color,
                        wTemperature,
                        handDry, 
                        fabric)
                        );
            }
            return data;
        }
    }
}
