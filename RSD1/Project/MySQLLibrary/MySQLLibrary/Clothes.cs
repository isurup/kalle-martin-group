using System;
using System.Collections.Generic;
using System.Text;

namespace MySQLLibrary
{
    public class Clothes
    {   
        public int id;
        public eClotheType type;
        public eColor color;
        public eWachingTemperature wTemperature;
        public eDryRecipe dryRecipe;
        public eFabric fabric;        

        public Clothes() { }
        public Clothes(int id, eClotheType type, eColor color, eWachingTemperature wTemperature, eDryRecipe dryRecipe, eFabric fabric) 
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
