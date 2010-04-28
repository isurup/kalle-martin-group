using System;
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
        //save methods
        public bool savePerson(String cprNumber, String name, String roomNumber, Bitmap picture)
        {
            if (!checkCpr(cprNumber)) { return false;}
            String str = con.SendMySqlCmd("SELECT CPR FROM PERSON WHERE CPR='" + cprNumber + "';");
            
            if(!update(str)){
                str = con.SendMySqlCmd("INSERT INTO Person(CPR) Values("
                    + "'" + cprNumber + "'" + ");");
                if (str == null) { return false; }

                str = con.SendMySqlCmd("INSERT INTO Name(name,CPRno) Values("
                + "'" + name + "'" + ","
                + "'" + cprNumber + "'" + ");");
                if (str == null) { return false; }

                str = con.SendMySqlCmd("INSERT INTO Address(roomNo,CPRno) Values("
                + "'" + roomNumber + "'" + ","
                + "'" + cprNumber + "'" + ");");
                if (str == null) { return false; }

            }
            else{//update
                str = con.SendMySqlCmd("UPDATE Name SET "
                        + "Name='" + name + "'" + " "                        
                        + "WHERE CPRno='" + cprNumber + "';");
                //if (str == null) { return false; }

                str = con.SendMySqlCmd("UPDATE Address SET "
                        + "roomNo='" + roomNumber + "'" + " "
                        + "WHERE CPRno='" + cprNumber + "';");
                //if (str == null) { return false; }
            }
            return true;
        }
        public bool saveClothes(String cprNumber, String tagId, String type, String color, String washingTemp, String dryRecipe, String fabric)
        {
            String str = null;
         
            if (!checkCpr(cprNumber)) { return false; }
            str = con.SendMySqlCmd("SELECT CPR FROM Person WHERE CPR='" + cprNumber + "';");
            if (!checkCpr(str)) { return false; }
            str = con.SendMySqlCmd("SELECT id FROM Clothes WHERE CPRno='" + cprNumber + "' AND id=" + tagId + ";");
                        
            if (!update(str))
            {
                //new clothe                
                str = con.SendMySqlCmd("INSERT INTO Clothes(id,type,color,washingTemperature,dryRecipe,fabric,CPRno) Values("
                    + "" + tagId + "" + ","
                    + "'" + type + "'" + ","
                    + "'" + color + "'" + ","
                    + "'" + washingTemp + "'" + ","
                    + "'" + dryRecipe + "'" + ","
                    + "'" + fabric + "'" + ","
                    + "'" + cprNumber + "'" + ");");
                if (str == null) { return false; }

                str = con.SendMySqlCmd("INSERT INTO Tags(id,YEAR,MONTH,Day,CPRno) Values("
                    + "" + tagId + "" + ","
                    + "" + DateTime.Now.Year + "" + ","
                    + "" + DateTime.Now.Month + "" + ","
                    + "" + DateTime.Now.Day + "" + ","
                    + "'" + cprNumber + "'" + ");");
                if (str == null) { return false; }

            }
            else
            {
                str = con.SendMySqlCmd("UPDATE Clothes SET "
                     //+ "id=" + tagId + "" + ","
                     + "type='" + type + "'" + ","
                     + "color='" + color + "'" + ","
                     + "washingTemperature='" + washingTemp + "'" + ","
                     + "dryRecipe='" + dryRecipe + "'" + ","
                     + "fabric='" + fabric + "'" + " "
                     + "WHERE CPRno='" + cprNumber + "'" + " AND id=" + tagId + ";");//+ "WHERE CPRno='" + cprNumber + "'" + ";");
                if(str == null) { return false; }

                str = con.SendMySqlCmd("UPDATE Tags SET "
                       //+ "id=" + tagId + "" + ","
                       + "Year=" + DateTime.Now.Year + "" + ","
                       + "Month=" + DateTime.Now.Month + "" + ","
                       + "Day=" + DateTime.Now.Day + "" + " "
                       + "WHERE CPRno='" + cprNumber + "'" + " AND id=" + tagId + ";");//+ "WHERE CPRno='" + cprNumber + "'" + ";");
                if (str == null) { return false; }
            }
            return true;
        }
        public bool saveAddress(String cprNumber, String streetName, String buildingNo, String roomNo, String city)
        {
            String str = null;
            if (!checkCpr(cprNumber)) { return false; }
            str = con.SendMySqlCmd("SELECT CPR from Person WHERE CPR='" + cprNumber + "';");
            if (!checkCpr(str)) { return false; }
            str = con.SendMySqlCmd("SELECT CPRno from Clothes WHERE CPRno='" + cprNumber + "';");
            
            if (!update(str))
            {
                str = con.SendMySqlCmd("UPDATE Address SET "
                         + "street='" + streetName + "'" + ","
                         + "buildingNo='" + buildingNo + "'" + ","
                         + "roomNo='" + roomNo + "'" + ","
                         + "city='" + city + "'" + " "
                         + "WHERE CPRno='" + cprNumber + "';");
            }
            else
            {
                str = con.SendMySqlCmd("INSERT INTO ADDRESS(street,buildingNo,roomNo,city,CPRno) Values("
                        + "'" + streetName + "'" + ","
                        + "'" + buildingNo + "'" + ","
                        + "'" + roomNo + "'" + ","
                        + "'" + city + "'" + ","
                        + "'" + cprNumber + "'" + ");");
            }
            return true;
        }
        //get methods
        public int[] getClothesIds(String cprNumber)
        {            
            if (!checkCpr(cprNumber)) { return new int[0];}

            bool result = false;
            string[] str = con.SendMySqlCmd__("SELECT id FROM Clothes WHERE CPRno='" + cprNumber + "';");
            if (str == null) { return null; }
            if (str.Length == 0) { return null; }
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
            String name = null;
            //name = con.SendMySqlCmd("SELECT name,surname,middlename FROM Name,Address WHERE Address.CPRno=Name.CPRno AND Address.roomNo=" + roomNo + ";");
            //name = con.SendMySqlCmd("SELECT name,surname FROM Name,Address WHERE Address.CPRno=Name.CPRno AND Address.roomNo=" + roomNo + ";");
            name = con.SendMySqlCmd("SELECT name FROM Name WHERE CPRno='" + cprNumber + "';");
            return name;
        }
        public String getAddress(String cprNumber)
        {
            String address = null;

            address = con.SendMySqlCmd("SELECT * from Address WHERE CPRno='" + cprNumber + "';");
            return address;
        }
        public String getClothesType(String tagId)
        {
            String clothesType = null;
            clothesType = con.SendMySqlCmd("SELECT type FROM Clothes WHERE id =" + tagId + ";");
            return clothesType;
        }
        public String getClothesColor(String tagId)
        {
            String clothesColor = null;
            clothesColor = con.SendMySqlCmd("SELECT color FROM Clothes WHERE id =" + tagId + ";");
            return clothesColor;
        }
        public String getClothesWashingTemp(String tagId)
        {
            String clothesWashingTemp = null;
            clothesWashingTemp = con.SendMySqlCmd("SELECT washingTemperature FROM Clothes WHERE id =" + tagId + ";");
            return clothesWashingTemp;
        }
        public String getClothesDryRecipe(String tagId)
        {
            String clothesDryRecipe = null;
            clothesDryRecipe = con.SendMySqlCmd("SELECT dryRecipe FROM Clothes WHERE id =" + tagId + ";");
            return clothesDryRecipe;
        }
        public String getClothesFabric(String tagId)
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
        private String getPictureUrl(String roomNo)//Not Implemented
        {
            String URL = null;
            URL = con.SendMySqlCmd("SELECT pictureURL from Person,Address WHERE Address.CPRno=Person.CPR AND Address.roomNo='" + roomNo + "';");
            return URL;
        }
        //delete methods       
        public bool deletePerson(String cprNumber)
        {
            if (!checkCpr(cprNumber)) { return false; }

            String str = con.SendMySqlCmd("SELECT CPR from PERSON WHERE CPR='" + cprNumber + "';");
            str = str.Replace("\n", "");

            if (str.CompareTo(cprNumber)==0)
            {
                str = con.SendMySqlCmd("DELETE FROM Tags WHERE CPRno='" + cprNumber + "';");
                str = con.SendMySqlCmd("DELETE FROM Clothes WHERE CPRno='" + cprNumber + "';");
                str = con.SendMySqlCmd("DELETE FROM Name WHERE CPRno='" + cprNumber + "';");
                str = con.SendMySqlCmd("DELETE FROM Address WHERE CPRno='" + cprNumber + "';");
                str = con.SendMySqlCmd("DELETE FROM PERSON WHERE CPR='" + cprNumber + "';");
            }
            else
            {
                return false;
            }
            return true;
        }        
        public bool deleteClothes(String tagId)
        {
            String str = null;
            
            str = con.SendMySqlCmd("SELECT id FROM Clothes WHERE id=" + tagId + ";");
            if (str == null) { return false; }
            if (str.Length == 0) { return false; }

            str = con.SendMySqlCmd("DELETE FROM Tags WHERE id=" + tagId + ";");
            str = con.SendMySqlCmd("DELETE FROM Clothes WHERE id=" + tagId + ";");
            return true;
        }
        //support methods

        private bool updatePicture(Bitmap image)
        {
            return true;
        }        
        private bool checkCpr(String cprNumber)
        {
            if (cprNumber == null) { return false; }
            if (cprNumber.Length <= 5) { return false; }
            return true;
        }
        private bool update(String str)
        {
            if (str == null) { return false; }
            else if (str.Length == 0) { return false; }
            return true; 
        }
    }
}
