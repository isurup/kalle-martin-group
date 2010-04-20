using System;
using System.Collections.Generic;
using System.Text;



namespace MySQLLibrary
{
    public class Functions
    {
        MySQLConnection con;
        public Functions(MySQLConnection con)
        {
            this.con = con;
        }

        public string ShowTables()
        {
            return con.SendMySqlCmd("Show tables;");            
        }
        public eType RegisterPerson(Person p)
        {
            String str = null;
            if (p == null){
                return eType.eTypeNullReference;
            }
            if (con == null){
                return eType.eTypeNoConnectionToDB;
            }
            str = con.SendMySqlCmd("SELECT CPRno FROM Name WHERE CPRno='" + p.CPR + "';");
            if (str.Length != 0)
            {
                return eType.eTypeDuplicates;
            }

            str = con.SendMySqlCmd("INSERT INTO Person(CPR) Values(" 
                + "'" + p.CPR + "'"+ ");");

            str = con.SendMySqlCmd("INSERT INTO Name(name,surname,CPRno) Values("
                + "'" + p.name.name   + "'" + ","
                + "'" + p.name.surname + "'" +"," 
                + "'" + p.CPR +"'"+ ");");

            str = con.SendMySqlCmd("INSERT INTO Address(street,buildingNo,roomNo,city,postCode,country,CPRno) Values("
                + "'" + p.address.streetName    + "'" + ","
                + "'" + p.address.buildingNo    + "'" + ","
                + "'" + p.address.roomNo        + "'" + ","
                + "'" + p.address.city          + "'" + ","
                + "'" + p.address.postCode      + "'" + ","
                + "'" + p.address.country       + "'" + ","
                + "'" + p.CPR                   + "'" + ");");

            return eType.eTypeSuccesuful;
        }
        public eType RegisterClothe(Clothes c, String CPR)
        {
            String str = null;
            if (c == null||CPR == null){
                return eType.eTypeNullReference;
            }
            if (con == null)
            {
                return eType.eTypeNoConnectionToDB;
            }
            str = con.SendMySqlCmd("SELECT CPR FROM Person WHERE CPR='" + CPR + "';");
            if (str == null)
            {
                return eType.eTypeNoEntityInDataBase;
            }            
            str = con.SendMySqlCmd("INSERT INTO Clothes(id,type,color,washingTemperature,dryRecipe,fabric,CPRno) Values("
                    + "'" + c.id            + "'" + ","
                    + "'" + c.type          + "'" + ","
                    + "'" + c.color         + "'" + ","
                    + "'" + c.wTemperature  + "'" + ","
                    + "'" + c.dryRecipe     + "'" + ","
                    + "'" + c.fabric        + "'" + ","
                    + "'" + CPR             + "'" + ");");
            return eType.eTypeSuccesuful;
        }
        public String[] getRoomNumbers()
        {
            String[] roomNumbers = null;            
            roomNumbers =  con.SendMySqlCmd__("SELECT roomNo FROM Address;");            
            return roomNumbers;
        }
        public String getName(String roomNo)
        {
            string name = null;            
            //name = con.SendMySqlCmd("SELECT name,surname,middlename FROM Name,Address WHERE Address.CPRno=Name.CPRno AND Address.roomNo=" + roomNo + ";");
            name = con.SendMySqlCmd("SELECT name,surname FROM Name,Address WHERE Address.CPRno=Name.CPRno AND Address.roomNo=" + roomNo + ";");
            return name;
        }
        public String getPictureUrl(String roomNo)
        {
            String URL = null;            
            URL = con.SendMySqlCmd("SELECT pictureURL from Person,Address WHERE Address.CPRno=Person.CPR AND Address.roomNo='" + roomNo + "';");
            return URL;
        }
        public int[] getClothesIds(String roomNo)
        {                 
            bool result = false;
            string[] str = con.SendMySqlCmd__("SELECT id FROM Clothes,Address,Person WHERE Address.CPRno=Person.CPR AND Clothes.CPRno=Person.CPR AND Address.roomNo='"+roomNo+"';");
            int[] clothesIds = new int[str.Length-1];       

            for (int i = 0; i < (str.Length-1); i++)
            {
                result = int.TryParse(str[i],out clothesIds[i]);
                if (!result)
                    break;
            }
            return clothesIds;
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
    }
}
