//  OOP1 Semester Project 1
//  BlackJack console appliaction 
//  Kalle Grafstöm and Martin Moghadam 
//
//  This class contains the Deck of Cards
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack
{
    class Deck
    {
        static void random()
        {

            System.Random generator = new Random(DateTime.Now.Millisecond);
            int Num1;
            int Num2;
            Num1 = generator.Next(4);
            Num2 = generator.Next(13);
        }
    }
}
