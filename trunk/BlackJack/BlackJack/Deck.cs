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
        public List<Card> DeckOfCards = new List<Card>();

        //-----------------------------------------------
        // Constructor; creates a deck of card;
        // using the card class
        //-----------------------------------------------
        public Deck()
        {
            for (int j = 0; j < 4; j++)
            {
                for (int i = 0; i < 13; i++)
                {
                    DeckOfCards.Add(new Card((Card.CardType)i, (Card.Suits)j));
                }
            }
        }

        //-----------------------------------------------
        // Throws a random Card; using a random generator
        // if there are no more cards in the deck the method returns null
        //-----------------------------------------------
        public Card ThrowCard()
        {
            //checks if deck is empty and returns null
            if (DeckOfCards.Count() == 0)
            {
                return null;
            }
            //
            System.Random generator = new Random(DateTime.Now.Millisecond);
            int deckCountTmp = DeckOfCards.Count + 1;

            do
            {
                int Num;
                Num = generator.Next(deckCountTmp);

                foreach (Card i in DeckOfCards)
                {
                    if (i.CardID == Num)
                    {
                        Card temp = i;
                        DeckOfCards.Remove(i);
                        return temp;
                    }
                }
            } while (true);
        }

        //-----------------------------------------------
        // Shuffles the deck, clears the DeckOfCards list and reinitilzes the list
        //-----------------------------------------------
        public void ShuffleDeck()
        {
            DeckOfCards.Clear();

            for (int j = 0; j < 4; j++)
            {
                for (int i = 0; i < 13; i++)
                {
                    DeckOfCards.Add(new Card((Card.CardType)i, (Card.Suits)j));
                }
            }
        }
    }
}
