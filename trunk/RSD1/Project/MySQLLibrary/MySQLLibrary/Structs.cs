using System;
using System.Collections.Generic;
using System.Text;

namespace MySQLLibrary
{
    public enum eType
    {
        eTypeSuccesuful = 0,
        eTypeBadFormat = 1,
        eTypeCanNotConnectToDB = 2,
        eTypeNoConnectionToDB = 3,
        eTypeDuplicates = 4,
        eTypeError     =5,
        eTypeNullReference = 6,
        eTypeNotExistRoomNo = 7,
        eTypeCanNotSaveImage = 8,
        eTypeNoEntityInDataBase = 9
    }

    public enum eClotheType
    {
        Sweater,Shirt,Pants,Underwear,WashingBag,Dress,Shorts,Towel,BedLinen
    }   
    public enum eColor
    {
        Colored,White
    }
    public enum eWachingTemperature
    {
        Degree30,Degree40,Degree60,Degree95,Handwash
    }
    public enum eDryRecipe
    {
        HangDry,Tumbling
    }
    public enum eFabric
    {
        Cotton,Synthetic,Wool
    }

    public class Structs
    {        
    }
}
