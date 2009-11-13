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
            List<Card> cards = new List<Card>();

            for (int i = 0; i < 13; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    Card.Add(new Card(i,j));
                }
            }

        }
        static Card ThrowCard()
        {

            System.Random generator = new Random(DateTime.Now.Millisecond);
            int Num1;
            int Num2;
            Num1 = generator.Next(4);
            Num2 = generator.Next(13);

            SpadeAce.PlayCard();

            SpadeAce.ReturnCard();
        }
    }
}
