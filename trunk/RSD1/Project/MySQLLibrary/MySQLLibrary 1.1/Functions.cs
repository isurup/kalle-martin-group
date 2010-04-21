using System;
using System.Collections.Generic;
using System.Text;
using System.Drawing;

namespace MySQLLibrary
{
    public class Functions
    {
        MySQLConnection con;
        public Functions(MySQLConnection con)
        {
            this.con = con;
        }       

        public bool savePerson(String cprNumber, String name, Bitmap picture)
        {
            string str = null;
            if (cprNumber.Length<1){
                return false;
            }
            //Looking is already person exist in db
            str = con.SendMySqlCmd("SELECT CPRno FROM Name WHERE CPRno='" + cprNumber + "';");
            
            if (str.Length != 0){//update                
            }
            else{//new values
                str = con.SendMySqlCmd("INSERT INTO Person(CPR) Values("
                    + "'" + cprNumber + "'" + ");");

                str = con.SendMySqlCmd("INSERT INTO Name(name,CPRno) Values("
                + "'" + name + "'" + ","
                + "'" + cprNumber + "'" + ");");
            }
            return true;
        }
        public bool saveClothes(String cprNumber, int tagId, String type, String color, String washingTemp, String dryRecipe, String fabric)
        {
            string str = null;
            if (cprNumber.Length < 1){
                return false;
            }
            //Looking is already clothe exist in db
            //str = con.SendMySqlCmd("SELECT Id FROM Tag WHERE CPRno='" + cprNumber + "';");              
                str = con.SendMySqlCmd("INSERT INTO Clothes(id,type,color,washingTemperature,dryRecipe,fabric,CPRno) Values("
                    + "'" + tagId + "'" + ","
                    + "'" + type + "'" + ","
                    + "'" + color + "'" + ","
                    + "'" + washingTemp + "'" + ","
                    + "'" + dryRecipe + "'" + ","
                    + "'" + fabric + "'" + ","
                    + "'" + cprNumber + "'" + ");");
            
            return true;
        }
        public int[] getClothesIds(String cprNumber)
        {
            bool result = false;
            string[] str = con.SendMySqlCmd__("SELECT id FROM Clothes WHERE CPRno='" + cprNumber + "';");
            int[] clothesIds = new int[str.Length - 1];

            for (int i = 0; i < (str.Length - 1); i++)
            {
                result = int.TryParse(str[i], out clothesIds[i]);
                if (!result)
                    break;
            }
            return clothesIds;
        }

        public String[] getCprNumbers()
        {
            String[] cprNumbers = null;
            cprNumbers = con.SendMySqlCmd__("SELECT CPR FROM Person;");
            return cprNumbers;
        }

        public String getName(String cprNumber)
        {
            string name = null;
            //name = con.SendMySqlCmd("SELECT name,surname,middlename FROM Name,Address WHERE Address.CPRno=Name.CPRno AND Address.roomNo=" + roomNo + ";");
            //name = con.SendMySqlCmd("SELECT name,surname FROM Name,Address WHERE Address.CPRno=Name.CPRno AND Address.roomNo=" + roomNo + ";");
            name = con.SendMySqlCmd("SELECT name FROM Name WHERE CPRno='" + cprNumber + "';");
            return name;
        }

        public String getClothesType(int tagId)
        {
            String clothesType = null;
            clothesType = con.SendMySqlCmd("SELECT type FROM Clothes WHERE id =" + tagId + ";");
            return clothesType;
        }

        public String getClothesColor(int tagId)
        {
            String clothesColor = null;
            clothesColor = con.SendMySqlCmd("SELECT color FROM Clothes WHERE id =" + tagId + ";");
            return clothesColor;
        }
        public String getClothesWashingTemp(int tagId)
        {
            String clothesWashingTemp = null;
            clothesWashingTemp = con.SendMySqlCmd("SELECT washingTemperature FROM Clothes WHERE id =" + tagId + ";");
            return clothesWashingTemp;
        }
        public String getClothesDryRecipe(int tagId)
        {
            String clothesDryRecipe = null;
            clothesDryRecipe = con.SendMySqlCmd("SELECT dryRecipe FROM Clothes WHERE id =" + tagId + ";");
            return clothesDryRecipe;
        }
        public String getClothesFabric(int tagId)
        {
            String clothesFabric = null;
            clothesFabric = con.SendMySqlCmd("SELECT fabric FROM Clothes WHERE id =" + tagId + ";");
            return clothesFabric;
        }

        public String[] getRoomNumbers()
        {
            String[] roomNumbers = null;
            roomNumbers = con.SendMySqlCmd__("SELECT roomNo FROM Address;");
            return roomNumbers;
        }

///////////////////////////////////////////////////////////////
      ///// Bellow not implemented

        public string ShowTables()
        {
            return con.SendMySqlCmd("Show tables;");
        }                
        public String getPictureUrl(String roomNo)
        {
            String URL = null;            
            URL = con.SendMySqlCmd("SELECT pictureURL from Person,Address WHERE Address.CPRno=Person.CPR AND Address.roomNo='" + roomNo + "';");
            return URL;
        }

        
        
    }
}
