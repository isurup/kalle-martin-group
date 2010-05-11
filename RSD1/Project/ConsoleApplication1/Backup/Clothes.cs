using System;
using System.Collections.Generic;
using System.Text;

namespace SorterLib
{
    public class Clothes
    {   
        public int id;
        public int type;
        public int color;
        public int wTemperature;
        public int dryRecipe;
        public int fabric;  

        public bool enable = true;
      
        //Additional info
        public int bin;        

        public Clothes() { }
        public Clothes(int id, int type, int color, int wTemperature, int dryRecipe, int fabric) 
        {
            this.id = id;
            this.type = type;
            this.color = color;
            this.wTemperature = wTemperature;
            this.dryRecipe = dryRecipe;
            this.fabric = fabric;       
        }
    }
}
