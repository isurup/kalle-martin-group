﻿//  OOP1 Semester Project 1
//  BlackJack console appliaction 
//  Kalle Grafstöm and Martin Moghadam 
//
//  This class contains the Cards
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BlackJack
{
    class Card
    {
        private CardType cardType;
        private Suits cardSuit;
        private int value;
        private int trueValue;

        public enum CardType
        {
            Ace = 0,
            Two = 1,
            Three = 2,
            Four = 3,
            Five = 4,
            Six = 5,
            Seven = 6,
            Eight = 7,
            Nine = 8,
            Ten = 9,
            Jack = 10,
            Queen = 11,
            King = 12
        }

        public enum Suits
        {
            Clubs = 0,
            Diamonds = 1,
            Hearts = 2,
            Spades = 3
        }

        public Card(CardType type, Suits suit)
        {
            cardSuit = suit;
            cardType = type;
            value = ((int)suit * 13) + (int)cardType + 1;
            trueValue = (int)cardType + 1;
            if (trueValue >= 10)
                trueValue = 10;
        }

        public int Value
        {
            get { return value; }
        }

        public int TrueValue
        {
            get { return trueValue; }
        }

        public CardType FaceValue
        {
            get { return cardType; }
        }

        public Suits Suit
        {
            get { return cardSuit; }
        }	

    }
}
