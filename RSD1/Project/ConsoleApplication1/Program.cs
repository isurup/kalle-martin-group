    using System;
    using System.Collections.Generic;
    using System.Text;
    using System.Timers;
    using RfidApiLib;
    using Scanner;
    using Reader;

    namespace RFIDConsoleAPP
    {
    class Program
    {
   
        static void Main(string[] args)
        {
            //preSortingAlgorithm sort = new preSortingAlgorithm();
            //sort.startSort();
            runReader rr = new runReader();
            
            rr.startReading();
            
     
           System.Console.ReadLine();
        }
        

    }
    }


