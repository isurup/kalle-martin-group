using System;
using System.Collections;
using System.Text;

namespace SorterLib
{
    [Serializable]
    public class SensitivyData
    {
        public WashingAlternativesData wad;
        public int fabric;
        public int temperature;
        public int weight;

        public SensitivyData(int fabric, int temperature, int weight)
        {
            this.fabric = fabric;
            this.temperature = temperature;
            this.weight = weight;
        }
        public SensitivyData()
        {
        }
    }    
}
