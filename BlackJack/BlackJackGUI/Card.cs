﻿//  OOP1 Semester Project 2
//  BlackJack GUI Application
//  Kalle Grafstöm and Martin Moghadam
//
//  This class contains the Card
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;

namespace BlackJackGUI
{
    class Card
    {
        private CardType cardType;
        private Suits cardSuit;
        private int Id;
        private int Value;
        private Bitmap myCardImage;

        //-----------------------------------------------
        // Card from Ace to King
        //-----------------------------------------------
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

        //-----------------------------------------------
        // The different suits
        //-----------------------------------------------
        public enum Suits
        {
            Clubs = 0,
            Diamonds = 1,
            Hearts = 2,
            Spades = 3
        }

        //-----------------------------------------------
        // Constructor sets the card value and id
        //-----------------------------------------------
        public Card(CardType type, Suits suit)
        {
            cardSuit = suit;
            cardType = type;
            Id = ((int)suit * 13) + (int)cardType + 1;
            Value = (int)cardType + 1;
            if (Value > 10)
                Value = 10;
            myCardImage = new Bitmap("Image\\card" + Id + ".png");
        }

        //-----------------------------------------------
        // Get properties
        //-----------------------------------------------
        public int CardID
        {
            get { return Id; }
        }

        public int CardValue
        {
            get { return Value; }
        }

        public CardType CardFace
        {
            get { return cardType; }
        }

        public Suits CardSuit
        {
            get { return cardSuit; }
        }

        public Bitmap CardImage
        {
            get { return myCardImage; }
        }

        //-----------------------------------------------
        // ToString override used to write the card name
        //      eg. "♠ Ace" 
        //-----------------------------------------------
        public override string ToString()
        {
            string tmp;
            if (cardSuit == Suits.Clubs)
            {
                tmp = "Clubs ";
            }
            else if (cardSuit == Suits.Diamonds)
            {
                tmp = "Diamonds ";
            }
            else if (cardSuit == Suits.Hearts)
            {
                tmp = "Hearts ";
            }
            else if (cardSuit == Suits.Spades)
            {
                tmp = "Spades ";
            }
            else
            {
                tmp = "suit not recognized";
            }
            return (tmp + cardType.ToString());
        }

    }
}
