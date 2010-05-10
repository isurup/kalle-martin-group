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

            runReader rr = new runReader();
            rr.startReading();
     
           System.Console.ReadLine();
        }
        

    }
    }


