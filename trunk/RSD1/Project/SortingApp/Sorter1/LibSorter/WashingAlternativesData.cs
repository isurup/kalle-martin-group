using System;
using System.Collections;
using System.Text;

namespace SorterLib
{
    [Serializable]
    public class WashingAlternativesData
    {
        public ArrayList rules;        
        public int parentFabric;
        public int parentwTemperature;
        public int parentWeight;

        public WashingAlternativesData(int fabric, int temperature, int weight)
        {
            rules = new ArrayList();   
            this.parentFabric = fabric;
            this.parentwTemperature = temperature;
            this.parentWeight = weight;
        }

        public  WashingAlternativesData(SensitivyData sd)
        {
            rules = new ArrayList();
            this.parentFabric = sd.fabric;
            this.parentwTemperature = sd.temperature;
            this.parentWeight = sd.weight;
        }
        public void addRule(SensitivyData sd)
        {
            rules.Add(sd);
        }
    }
}
