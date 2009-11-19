﻿//  OOP1 Semester Project 1
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
        public static Deck GameDeck = new Deck();
        public static List<Card> PlayerCards = new List<Card>();
        public static List<Card> DealerCards = new List<Card>();
        public static int playerScore;
        public static int playerScoreAce; // Needed because of Ace Duality


        public BlackJack()
        {

        }

        //-----------------------------------------------
        // The Main Method
        //-----------------------------------------------
        static void Main(string[] args)
        {
            // Test--------------------
            //Console.Out.WriteLine("♠Ace ♣King ♥Queen ♦Jack");
            //Console.Out.WriteLine("Random Throw Card: " + GameDeck.ThrowCard() + "\n");
            //Console.Out.WriteLine("Output of the current DeckOfCards: \n");
            //foreach (Card i in GameDeck.DeckOfCards)
            //{
            //    Console.Out.WriteLine(i.ToString());
            //}
            //Console.Out.WriteLine("Notice that the random card is no longer part of the deck\n");
            //Console.Out.WriteLine(GameDeck.DeckOfCards[12] + " Card Value: " + GameDeck.DeckOfCards[12].CardValue + "\n");
            //Console.Out.WriteLine(GameDeck.DeckOfCards[13] + " Card Value: " + GameDeck.DeckOfCards[13].CardValue + "\n");
            //Console.Out.WriteLine("Notice that the card values are correct");
            //Console.Clear();
            ////////////////////////////////////////////////////////////

            int readIn;

            Console.Out.WriteLine("♠ ♣ ♥ ♦ BlackJack:\n");

            //-----------------------------------------------
            // The while ture loop creates the console output,
            // reads input from the user and calls the methods
            // Hit() and Stand()
            //-----------------------------------------------
            while (true)
            {
                Console.Out.Write("\n1:Hit\n2:Stand\nInput: ");

                try
                {
                    readIn = int.Parse(Console.In.ReadLine());
                }
                catch (Exception) // the Parse has; null,format and overflow expections
                {
                    readIn = 0; // switchs to the default case, and writes "Incorrect input try again"
                }

                switch (readIn)
                {
                    case 1:
                        Console.Out.WriteLine("Cards Dealt: ");
                        Hit();
                        break;
                    case 2:
                        Console.Out.WriteLine("Dealer plays: ");
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
            PlayerCards.Add(myThrowCard());

            int tmp = 0;
            foreach (Card i in PlayerCards)
            {
                Console.Out.WriteLine(i);
                tmp += i.CardValue;
                if (i.Face == Card.CardType.Ace)
                    AceDuality();
            }
            if (tmp > 21)
            {
                Console.Out.WriteLine("Bust! Dealer Wins!");
                PlayerCards.Clear();
            }
            else if (tmp == 21)
            {
                Console.Out.WriteLine("BlackJack! Player Wins!");
                PlayerCards.Clear();
            }
            else
            {
                playerScore = tmp;
            }

        }

        //-----------------------------------------------
        // The dealer responds to a stand;
        // by trying to get 17 or above
        //-----------------------------------------------
        private static void Stand()
        {
            int tmpDealer = 0;
            DealerCards.Clear();

            do
            {
                Card newCard = myThrowCard();
                DealerCards.Add(newCard);
                tmpDealer += newCard.CardValue;
                if (newCard.Face == Card.CardType.Ace)
                {
                    if (tmpDealer + 10 == 21)
                    {
                        Console.Out.WriteLine("Dealer gets BlackJack! Dealer Wins!");
                        PlayerCards.Clear();
                        DealerCards.Clear();
                    }
                }
                Console.Out.WriteLine(newCard + " + ");
            } while (tmpDealer < 16); // stops at 17 or above

            if (tmpDealer > 21)
            {
                Console.Out.WriteLine("Dealer Busts! Player Wins!");
                PlayerCards.Clear();
                DealerCards.Clear();
            }
            else if (tmpDealer == 21)
            {
                Console.Out.WriteLine("Dealer gets BlackJack! Dealer Wins!");
                PlayerCards.Clear();
                DealerCards.Clear();
            }
            else if (tmpDealer > playerScore && tmpDealer > playerScoreAce)
            {
                Console.Out.WriteLine("Dealer gets Highest! Dealer Wins!");
                PlayerCards.Clear();
                DealerCards.Clear();
            }
            else
            {
                Console.Out.WriteLine("Dealer stands on: " + tmpDealer);
                if (tmpDealer < playerScore || tmpDealer < playerScoreAce)
                {
                    Console.Out.WriteLine("Player has highst, Player Wins! ");
                    PlayerCards.Clear();
                    DealerCards.Clear();
                }
                else
                {
                    Console.Out.WriteLine("Dealer wins!");
                    PlayerCards.Clear();
                    DealerCards.Clear();
                }

            }
        }

        //-----------------------------------------------
        // Ace count as two values 1 and 11;
        // The method check the cards dealt if ace counts as 11
        //-----------------------------------------------
        private static void AceDuality()
        {
            int tmpAce = 0;
            foreach (Card i in PlayerCards)
            {
                Console.Out.Write(i);
                tmpAce += i.CardValue;
            }
            if (tmpAce + 10 == 21)
            {
                Console.Out.WriteLine("BlackJack! Player Wins!");
                PlayerCards.Clear();
            }
            else
            {
                if (tmpAce < 21)
                {
                    playerScoreAce = tmpAce;
                }
                else
                {
                    playerScoreAce = 0;
                }
            }
        }

        //-----------------------------------------------
        // Check if the deck has cards and returns a card,
        // if the deck is empty the cards are shuffled.
        // -The Deck Class has a ThrowCard method that returns null
        // if the deck no longer has any cards, and a suffle class
        // that reinitilizes the deck. 
        //-----------------------------------------------
        private static Card myThrowCard()
        {
            Card x = GameDeck.ThrowCard();
            if (x == null)
            {
                Console.Out.WriteLine("Game Deck is empty, shuffling and clearing the game.\n New Game:\n");
                PlayerCards.Clear();
                DealerCards.Clear();
                GameDeck.ShuffleDeck();
                return GameDeck.ThrowCard();
            }
            else
            {
                return x;
            }
        }
    }
}
