using System;
using System.Text;

namespace SorterLib
{
    /// <summary>
    /// Structutre of the bin, which stores information about the clothe type and how many clothes in particular bin is stored.
    /// For instance: Bin 10, which stores only Colored, 40degree and Wool clothes.
    /// </summary>
    public class Bin
    {
        public int color;
        public int wTemp;
        public int fabric;
        public int numberOfClothes;

        public Bin(int color, int wTemp, int fabric)
        {
            this.color = color;
            this.wTemp = wTemp;
            this.fabric = fabric;
        }
        public Bin()
        {
        }
    }
}
