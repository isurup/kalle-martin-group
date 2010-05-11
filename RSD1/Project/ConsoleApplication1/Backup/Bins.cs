using System;
using System.Collections;
using System.Text;

namespace SorterLib
{
    public class Bins
    {        
        Bin[] bins;        
        public int  binID=1;

        public Bins()
        {
            bins = new Bin[100];
        }
        public Bins(int numberOfBins)
        {
            bins = new Bin[numberOfBins];
        }
        /// <summary>
        /// Collection of bins. (Number of bins)        
        /// </summary>
        /// <returns></returns>
        public Bin[] getBins()
        {
            return bins;
        }
        public void AddBin(int color, int wTemp, int fabric)
        {            
            bins[binID++] = new Bin(color, wTemp, fabric);
        }
        public void AddBin(Bin bin)
        {
            bins[binID++] = new Bin(bin.color,bin.wTemp,bin.fabric);
        }
        public int Count
        {
            get { return binID; }
        }        
    }
}
