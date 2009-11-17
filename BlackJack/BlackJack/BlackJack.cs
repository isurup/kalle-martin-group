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
        public static List<Card> CardUp = new List<Card>();


        public BlackJack()
        {
            
        }

        //-----------------------------------------------
        // The Main Method
        //-----------------------------------------------
        static void Main(string[] args)
        {
            // Test--------------------
            Console.Out.WriteLine("♠Ace ♣King ♥Queen ♦Jack");
            Console.Out.WriteLine("Random Throw Card: " + player.ThrowCard() + "\n");
            Console.Out.WriteLine("Output of the current DeckOfCards: \n");
            foreach (Card i in player.DeckOfCards)
            {
                Console.Out.WriteLine(i.ToString());
            }
            Console.Out.WriteLine("Notice that the random card is no longer part of the deck\n");
            Console.Out.WriteLine(player.DeckOfCards[12] + " Card Value: " + player.DeckOfCards[12].CardValue + "\n");
            Console.Out.WriteLine(player.DeckOfCards[13] + " Card Value: " + player.DeckOfCards[13].CardValue + "\n");
            Console.Out.WriteLine("Notice that the card values are correct");
            ////////////////////////////////////////////////////////////

            int readIn;

            Console.Out.WriteLine("♠ ♣ ♥ ♦ BlackJack:\n");
            //Console.Clear();
            while (true)
            {
                
                Console.Out.Write("\n1:Hit\n2:Stand\nInput: ");
                readIn = int.Parse(Console.In.ReadLine());

                switch (readIn)
                {
                    case 1:
                        Console.Out.WriteLine("Cards Dealt: ");
                        Hit();
                        break;
                    case 2:
                        Console.Out.WriteLine("Standing!");
                        Stand();
                        break;
                    default:
                        Console.Out.WriteLine("Incorrect input try again");
                        break;
                }
            }
        }

        //-----------------------------------------------
        // The dealer responds to a Hit:
        // Give the player a card form the deck
        //-----------------------------------------------
        private static void Hit()
        {
            CardUp.Add(player.ThrowCard());
            int tmp = 0;
            foreach (Card i in CardUp)
            {
                Console.Out.WriteLine(i);
                tmp += i.CardValue;
                if (i.Face == Card.CardType.Ace)
                    AceDuality();
            }
            if (tmp > 21)
            {
                Console.Out.WriteLine("Bust! Dealer Wins!");
                CardUp.Clear();
            }
            if (tmp == 21)
            {
                Console.Out.WriteLine("BlackJack! Player Wins!");
                CardUp.Clear();
            }
        }

        //-----------------------------------------------
        // The dealer responds to a stand;
        // by trying to get 17 of above
        //-----------------------------------------------
        private static void Stand()
        {

        }

        //-----------------------------------------------
        // Ace count as two values 1 and 11;
        // The method check the cards dealt if ace counts as 11
        //-----------------------------------------------
        private static void AceDuality()
        {
            int tmpAce = 0;
            foreach (Card i in CardUp)
            {
                Console.Out.WriteLine(i);
                tmpAce += i.CardValue;
            }
            if (tmpAce+10 > 21)
            {
                Console.Out.WriteLine("Bust! Dealer Wins!");
                CardUp.Clear();
            }
            if (tmpAce+10 == 21)
            {
                Console.Out.WriteLine("BlackJack! Player Wins!");
                CardUp.Clear();
            }
        }
    }
}
