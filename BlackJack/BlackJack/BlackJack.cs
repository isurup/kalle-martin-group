//  OOP1 Semester Project 1
//  BlackJack console appliaction 
//  Kalle Grafstöm and Martin Moghadam 
//
//      Description: A simple BlackJack console application, with the computer
//      being the dealer and the user being the player.
//      The game consist of only one deck.
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
        public static Deck player = new Deck();

        public BlackJack()
        {
            
        }

        //-----------------------------------------------
        // The Main Method
        //-----------------------------------------------
        static void Main(string[] args)
        {
            
            Console.Out.WriteLine("♠Ace ♣King ♥Queen ♦Jack");
            Console.Out.WriteLine("Random Throw Card: " + player.ThrowCard());
            Console.Out.WriteLine("Output of the current DeckOfCards: ");
            foreach (Card i in player.DeckOfCards)
            {
                Console.Out.WriteLine(i.ToString());
            }
            Console.Out.WriteLine("Notice that the random card is no longer part of the deck");
            Console.Out.WriteLine();
            Console.Out.WriteLine(player.DeckOfCards[10].ToString() + " Card Value: " + player.DeckOfCards[10].CardValue);
            Console.Out.WriteLine();
            Console.Out.WriteLine(player.DeckOfCards[12].ToString() + " Card Value: " + player.DeckOfCards[12].CardValue);
            Console.Out.WriteLine();
            Console.Out.WriteLine("Notice that the card values are correct");
            while (true)
            {

            }
        }
    }
}
