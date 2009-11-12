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
        public Deck()
        {
            Card SpadeAce = new Card(SpadeAce, 11, true, true);
            Card SpadeTwo = new Card(SpadeTwo, 2, true, false);
            Card SpadeThree = new Card(SpadeAce, 3, true, false);
        }
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
