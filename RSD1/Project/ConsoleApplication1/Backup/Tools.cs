using System;
using System.Collections;
using System.Text;
using SorterLib;

namespace SorterLib
{
    public class Tools
    {        
        public static bool existDuplicates(object data1, int type, int numberOfClothes)
        {
            ArrayList data = (ArrayList)data1;          
            if (data == null){
                return false;
            }
            for (int i = 0; i < data.Count; i++)
            {
                ClothesValueData cur = (ClothesValueData)data[i];
                if (cur.type == type && cur.numberOfClothes == numberOfClothes)
                {
                    return true;
                }
            }
            return false;
        }
        public static bool existDuplicates(object data1,int fabric,int wTemperature,int weight)
        {
            ArrayList data = (ArrayList)data1;          
            if (data == null){
                return false;
            }   
                  for (int i = 0; i < data.Count; i++)
                    {
                        SensitivyData cur = (SensitivyData)data[i];                
                        if (cur.fabric == fabric && cur.temperature == wTemperature)
                        {
                            return true;
                        }
                    }            
                    return false;
        }


        public static object saveData(ArrayList data,ClothesValueData cvd)
        {
            if (data == null)    {          return null;           }
            if (cvd == null) { return null; }

            return data.Add(new ClothesValueData(cvd.type,cvd.numberOfClothes,cvd.mashine_total_value));
        }
        public static object saveData(ArrayList data,int fabric,int wTemperature,int weight)
        {
            if(data==null){               return null;           }               
            return data.Add(new SensitivyData(fabric, wTemperature, weight));
        }

        //ClothesValueData
        public static bool updateData(ArrayList data, ClothesValueData cvd)
        {
            if (data == null) { return false; }
            if(cvd == null){return false;}

            for (int i = 0; i < data.Count; i++)
            {
                ClothesValueData curr = ((ClothesValueData)data[i]);
                if (curr.type == cvd.type)
                {
                    curr.type = cvd.type;
                    curr.numberOfClothes = cvd.numberOfClothes;
                    curr.mashine_total_value = cvd.mashine_total_value;
                    return true;
                }
            }
            return false;
        }
        //SensitivyData
        public static bool updateData(ArrayList data, int fabric, int wTemperature, int weight)
        {
            if (data == null){   return false;  }

            for (int i = 0; i < data.Count; i++)
            {
                SensitivyData curr = ((SensitivyData)data[i]);
                if (curr.fabric == fabric && curr.temperature == wTemperature)
                {
                    curr.fabric         = fabric;
                    curr.temperature    = wTemperature;
                    curr.weight         = weight;
                    return true;
                }
            }
            return false;
        }
    

        public static void removeData(ArrayList data, SensitivyData sd)
        {
            if (data == null) { return; }
            if (sd == null) { return; }
            int indx = getIndex(data,sd);
            if (data.Count > 0 && indx >=0)
            {
                data.RemoveAt(indx);
            }
        }
        public static int getIndex(ArrayList data,SensitivyData sd)
        {
            if (data == null) { return -1; }
            if (sd == null) { return -1; }

            for (int i = 0; i < data.Count; i++)
            {
                if (((SensitivyData)data[i]).fabric == sd.fabric &&
                    ((SensitivyData)data[i]).temperature == sd.temperature &&
                    ((SensitivyData)data[i]).weight == sd.weight) {
                        return i;
                }                    
            }
            return -1;
        }

        private int totalCoeffWeight(ArrayList data)
        {
            int totalWeight = 0;
            if (data == null) { return totalWeight; }

            for (int i = 0; i < data.Count; i++)
            {
                SensitivyData curr = ((SensitivyData)data[i]);
                totalWeight += curr.weight;                
            }
            return totalWeight;
        }

        private double getCoefficient(ArrayList data)
        {
            if (data == null) { return 0; }
            int totalWeight = totalCoeffWeight(data);
            int maxWeight = 100;
            if (totalWeight == 0) { return 0; }
            return (((double)maxWeight) / ((double)totalWeight));
        }

        public void recalculateCoeffiecients(ArrayList data)
        {
            if (data == null) { return; }            
            double coefficient = getCoefficient(data);

            for (int i = 0; i < data.Count; i++)
            {
                SensitivyData curr = ((SensitivyData)data[i]);
                double weight = (double)curr.weight;
                weight = weight * coefficient;
                curr.weight = (int)weight;
            }                  
        }

        //SensitivyData
        public void sortDataValues_byWeight(ArrayList data)
        {
            if (data == null) { return; }
            ArrayList backup = new ArrayList();
            backup = data;

            for (int i = 0; i < data.Count; i++)
            {
                SensitivyData curr1 = ((SensitivyData)data[i]);

                for (int j = 0; j < data.Count; j++)
                {
                    SensitivyData curr0 = ((SensitivyData)backup[j]);
                    int temp = 0;
                    if (curr0.weight < curr1.weight)
                    {
                        temp = curr0.weight;
                        curr0.weight = curr1.weight;
                        curr1.weight = temp;
                    }
                }
            }            
        }
        //ClothesValueData
        public void sortDataValues_byWeight__(ArrayList data)
        {
            if (data == null) { return; }
            ArrayList backup = new ArrayList();
            backup = data;

            for (int i = 0; i < data.Count; i++)
            {
                ClothesValueData curr1 = ((ClothesValueData)data[i]);

                for (int j = 0; j < data.Count; j++)
                {
                    ClothesValueData curr0 = ((ClothesValueData)backup[j]);
                    int temp = 0;
                    if (curr0.numberOfClothes < curr1.numberOfClothes)
                    {
                        temp = curr0.numberOfClothes;
                        curr0.numberOfClothes = curr1.numberOfClothes;
                        curr1.numberOfClothes = temp;
                    }
                }
            }
        }
    }
}
