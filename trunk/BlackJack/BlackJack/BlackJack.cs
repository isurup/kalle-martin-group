//  OOP1 Semester Project 1
//  BlackJack console appliaction 
//  Kalle Grafstöm and Martin Moghadam 
//
//      Description: A simple BlackJack console application, with the computer being the dealer and the user being the player
//
//  This class contains the main method
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack
{
    class BlackJack
    {
        //-----------------------------------------------
        // The Main Method
        //-----------------------------------------------
        static void Main(string[] args)
        {
            System.Random generator = new Random(DateTime.Now.Millisecond);
            int Num1;
            int Num2;
            Num1 = generator.Next(4);
            Num2 = generator.Next(13);
        }
    }
}
