using System;
using System.Collections.Generic;
using System.Text;

namespace SorterLib
{
    [Serializable]
    public class ClothesValueData
    {
        public int type;
        public int numberOfClothes;
        public int mashine_total_value;

        public ClothesValueData(int type, int numberOfClothes,int total_value)
        {
            this.type = type;
            this.numberOfClothes = numberOfClothes;
            this.mashine_total_value = total_value;
        }
    }
}

