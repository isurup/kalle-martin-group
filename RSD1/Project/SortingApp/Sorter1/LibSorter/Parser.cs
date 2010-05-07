using System;
using System.Collections;
using System.Text;

namespace SorterLib
{
    public class Parser
    {
        public Parser()
        {            
        }
        private eAllData stringToEnum(String str)
        {
            for (eAllData e = eAllData.eFirst; e < eAllData.eLast; e++)
            {
                if (e.ToString().CompareTo(str) == 0)
                {
                    return e;
                }
            }            
            return eAllData.eFirst;
        }
        private String[] parseString(String str)
        {
            if (str == null) { return null; }
            char separator = ':';
            String[] result = null;
            result = str.Split(separator);            
            return result;
        }

        public object stringToData__(String str)
        {
            if (str == null) { return null; }
            String[] values = parseString(str);
            if (values == null) { return null; }

            if (values.Length == 3)
            {
                return new ClothesValueData( (int)stringToEnum(values[0]),int.Parse(values[1]),int.Parse(values[2]));
            }
            return null;
        }


        public object stringToData(String str)
        {
            if (str == null) { return null; }
            String[] values = parseString(str);
            if (values == null) { return null; }

            if(values.Length==3)
            {
                return new SensitivyData((int)stringToEnum(values[0]),
                                         (int)stringToEnum(values[1]),
                                         int.Parse(values[2])
                                         );
            }
            return null;
        }

        public static String dataToStringID(object data)
        {            
            if (data != null)
            {
                SensitivyData rule = (SensitivyData)data;
                return rule.fabric.ToString() + ":" + rule.temperature.ToString() + ":" + rule.weight.ToString();
            }         
            return null;
        }

        public static String dataToStringValues(object data)
        {
            if (data != null)
            {
                SensitivyData rule =      (SensitivyData)data;
                eAllData fabric         = (eAllData)rule.fabric;
                eAllData wTemperature   = (eAllData)rule.temperature;
                int value               = rule.weight;

                return fabric + ":" + wTemperature + ":" + value;
            }
            return null;
        }

        public static String dataToStringValues__(object data)
        {
            if (data != null)
            {
                ClothesValueData rule = (ClothesValueData)data;
                eAllData type       = (eAllData)rule.type;
                int numberOfClothes = rule.numberOfClothes;
                return type + ":" + numberOfClothes;
            }
            return null;
        }
    }
}
