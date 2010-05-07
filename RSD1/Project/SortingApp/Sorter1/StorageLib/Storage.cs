using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization.Formatters.Soap;//
using System.Runtime.Serialization.Formatters.Binary;//
using System.Runtime.Serialization;//
using System.IO;//
using System.Windows.Forms;


namespace StorageLib
{
    /// <summary>
    /// Strorage library allow to serelize and deserialize to configuration files data.
    /// </summary>
    [Serializable]
    public class Storage
    {
        static public void Delete(String fname)
        {
            string path = Application.StartupPath;
            
            File.Delete(path+"\\"+fname);
        }

        static public void Save(object data,String fname)
        {
            FileStream file = new FileStream(fname, FileMode.Create);//XML        
            SoapFormatter formatter = new SoapFormatter();

            formatter.Serialize(file, data);
            file.Close();            
        }

        static public object Load(String fname)
        {
            if (fname == null) { return null; }
            FileStream file = new FileStream(fname, FileMode.OpenOrCreate);
            object data = null;
            if (file.Length != 0)
            {
                SoapFormatter formatter = new SoapFormatter();
                data = formatter.Deserialize(file);                
            }
            file.Close();
            return data;
        }
    }
}
