using System;

namespace SorterLib
{
    /// <summary>
    /// All enum structures have eFirst and eLast valus, these range are allocated for particular
    /// data and valus can not be exeed them.
    /// </summary>
    
    public enum eAllData
    {
        eFirst      =  0,

        //Clothes types
        eType           = 30,
        Sweater         = 31,
        Shirt           = 32,
        Pants           = 33, 
        Underwear       = 34, 
        WashingBag      = 35, 
        Dress           = 36, 
        Shorts          = 37, 
        Towel           = 38, 
        BedLinen        = 39,

        //Clothes colors
        eColor          = 100,
        Colored         = 102,
        White           = 103,

        //Clothes temperatures
        ewTemperature   = 150,
        Degree30        = 151,
        Degree40        = 152, 
        Degree60        = 153, 
        Degree95        = 154, 
        Handwash        = 155,

        //Clothes dry recpes
        eDryRecipe      = 180,          
        HangDry         = 181,
        Tumbling        = 182,

        //Clothes fabrics
        eFabric         = 200,    
        Cotton          = 201,
        Synthetic       = 202,
        Wool            = 203,
        
        eLast           = 220,
    };

    /// <summary>
    /// Values to sorting algorithm
    /// </summary>
    public enum eClotheType
    {
        Sweater, Shirt, Pants, Underwear, WashingBag, Dress, Shorts, Towel, BedLinen
    }
    public enum eColor
    {
        Colored, White
    }
    public enum eWachingTemperature
    {
        Degree30, Degree40, Degree60, Degree95, Handwash
    }
    public enum eDryRecipe
    {
        HangDry, Tumbling
    }
    public enum eFabric
    {
        Cotton, Synthetic, Wool
    }
}
