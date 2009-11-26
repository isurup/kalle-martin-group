using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack
{
    class Kalle
    {
        static void KallesDeck()
        {
            System.Random generator = new Random(DateTime.Now.Millisecond);
            int Num1;
            int Num2;

            Num1 = generator.Next(4);
            Num2 = generator.Next(13);
        }
    }
}
