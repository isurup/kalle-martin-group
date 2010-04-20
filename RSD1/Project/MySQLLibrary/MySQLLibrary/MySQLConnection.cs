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
        public String uId = "root";/**/
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
        
        //Note: After each send cmd connection should be closed
        public eType Open()
        {
            mySqlCon = new MySqlConnection(configStr);
            try
            {
                mySqlCon.Open();
            }
            catch
            {                
                return eType.eTypeCanNotConnectToDB;
            }
            return eType.eTypeSuccesuful;
        }

        public eType Close()
        {
            try
            {
                mySqlCon.Close();
            }
            catch
            {
                return eType.eTypeError;
            }
            return eType.eTypeSuccesuful;
        }

        public string SendMySqlCmd(string cmd)
        {            
            string str = "";
            eType type = this.Open();
            if (type != eType.eTypeSuccesuful)
            {
                return type.ToString();
            }
            mySqlCmd = mySqlCon.CreateCommand();
            mySqlCmd.CommandText = cmd;
            try
            {
                mySqlReader = mySqlCmd.ExecuteReader();
            }
            catch 
            {
                this.Close();
                return "Error, SendMySQLCmd";
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

            eType type = this.Open();
            if (type != eType.eTypeSuccesuful)
            {
                str[0] = type.ToString();
                return str;
            }
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
            str = str1.Split(delimiter);
            return str;
        }

        public override string ToString()
        {
            return this.configStr.ToString();
        }

    }
}
