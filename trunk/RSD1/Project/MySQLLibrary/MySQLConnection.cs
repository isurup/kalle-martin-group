using System;
using System.Collections;
using MySql.Data;
using MySql.Data.MySqlClient;

namespace MySQLLibrary
{
    
    /// <summary>
    /// Data Base configuration sentence connect to MySQL DB.
    /// </summary>
    public class MySQLConnection
    {        
        MySqlConnection mySqlCon;
        MySqlCommand    mySqlCmd;
        MySqlDataReader mySqlReader;

        //defaul configuration
        public String ipAddress = "192.168.1.109";/*localhost, 127.0.0.1, 192.168.1.2, ...*/
        public String dataBaseName = "laundry";/**/
        public String uId = "root";/*user Id*/
        public String port = "3306";/**/
        String password = "1234";/**/

        /*Aditional Info*/
        public String webAppFolder = "Laundry_DB_WEB";
        public String webConRoot;

        String configStr;/*configuration string, connect to DB*/


        public MySQLConnection()
        {
            configStr = "Server=" + this.ipAddress + ";" +
                        "Database=" + this.dataBaseName + ";" +
                        "uid=" + this.uId + ";" +
                        "port=" + this.port + ";" +
                        "pwd=" + this.password + ";";
            
            webConRoot = "http:\\" + this.ipAddress + "\\" + this.webAppFolder + "\\";

        }

        public MySQLConnection(String ipAddress,String dataBaseName,String uId,String port,String password)
        {
            this.ipAddress = ipAddress;
            this.dataBaseName = dataBaseName;
            this.uId = uId;
            this.port = port;
            this.password = password;

            configStr = "Server=" + this.ipAddress + ";" +
                        "Database=" + this.dataBaseName + ";" +
                        "uid=" + this.uId + ";" +
                        "port=" + this.port + ";" +
                        "pwd=" + this.password + ";";

            webConRoot = "http:\\" + this.ipAddress + "\\" + this.webAppFolder + "\\";
        }
        
        //Note: After each send query cmd connection should be closed
        public void Open()
        {
            mySqlCon = new MySqlConnection(configStr);
            try
            {
                mySqlCon.Open();
            }
            catch
            {                               
            }
            
        }

        public void Close()
        {
            try
            {
                mySqlCon.Close();
            }
            catch
            {               
            }            
        }

        public string SendMySqlCmd(string cmd)
        {            
            string str = "";
            this.Open();            
            mySqlCmd = mySqlCon.CreateCommand();
            mySqlCmd.CommandText = cmd;
            try
            {
                mySqlReader = mySqlCmd.ExecuteReader();
            }
            catch 
            {
                this.Close();
                return null;//"Error, SendMySQLCmd";
            }
            
            while (mySqlReader.Read())
            {
                for (int i = 0; i < mySqlReader.FieldCount; i++)
                    str += mySqlReader.GetValue(i).ToString() + "\n";                
            }
            this.Close();
            return str;
        }

        public string[] SendMySqlCmd__(string cmd)
        {
            string[] str = null;
            string str1 = null;
            char[] delimiter = "\n".ToCharArray();

            this.Open();            
            mySqlCmd = mySqlCon.CreateCommand();
            mySqlCmd.CommandText = cmd;
            try
            {
                mySqlReader = mySqlCmd.ExecuteReader();
            }
            catch
            {
                this.Close();
                return null;
            }                        
            while (mySqlReader.Read())
            {
                
                for (int i = 0; i < mySqlReader.FieldCount; i++)
                    str1 += mySqlReader.GetValue(i).ToString() + "\n";                    
            }
            
            
            this.Close();
            if (str1 != null)
            {
                str = str1.Split(delimiter);
                //insert null instead ""
                //if (str.Length >= 2)
                //{
                //    str[str.Length - 1] = null;
                //}
            }
            return str;
        }

        public override string ToString()
        {
            return this.configStr.ToString();
        }

    }
}
