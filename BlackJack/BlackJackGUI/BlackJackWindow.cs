﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Timers;

namespace BlackJackGUI
{
    public partial class BlackJackWindow : Form
    {
        public BlackJackWindow()
        {
            InitializeComponent();
        }

        Deck GameDeck = new Deck();
        List<Card> PlayerCards = new List<Card>();
        List<Card> DealerCards = new List<Card>();
        public static int playerScore;
        public static int playerScoreAce; // Needed because of Ace Duality

        //-----------------------------------------------
        // The player hits and the dealer responds
        // The dealer responds to a Hit:
        // Giving the player a card form the deck
        //-----------------------------------------------
        private void Hit_Click(object sender, EventArgs e)
        {
            if (PlayerCards.Count == 0)
                hidePlayerPictureBoxes();

            Card tmpCard = myThrowCard();
            PlayerCards.Add(tmpCard);

            switch (PlayerCards.Count)
            {
                case 1:
                    pictureBox1.Image = tmpCard.CardImage;
                    pictureBox1.BringToFront();
                    pictureBox1.Visible = true;
                    break;
                case 2:
                    pictureBox2.Image = tmpCard.CardImage;
                    pictureBox2.BringToFront();
                    pictureBox2.Visible = true;
                    break;
                case 3:
                    pictureBox3.Image = tmpCard.CardImage;
                    pictureBox3.BringToFront();
                    pictureBox3.Visible = true;
                    break;
                case 4:
                    pictureBox4.Image = tmpCard.CardImage;
                    pictureBox4.BringToFront();
                    pictureBox4.Visible = true;
                    break;
                case 5:
                    pictureBox5.Image = tmpCard.CardImage;
                    pictureBox5.BringToFront();
                    pictureBox5.Visible = true;
                    break;
                case 6:
                    pictureBox6.Image = tmpCard.CardImage;
                    pictureBox6.BringToFront();
                    pictureBox6.Visible = true;
                    break;
                case 7:
                    pictureBox7.Image = tmpCard.CardImage;
                    pictureBox7.BringToFront();
                    pictureBox7.Visible = true;
                    break;
                case 8:
                    pictureBox8.Image = tmpCard.CardImage;
                    pictureBox8.BringToFront();
                    pictureBox8.Visible = true;
                    break;
                case 9:
                    pictureBox9.Image = tmpCard.CardImage;
                    pictureBox9.BringToFront();
                    pictureBox9.Visible = true;
                    break;
                case 10:
                    pictureBox10.Image = tmpCard.CardImage;
                    pictureBox10.BringToFront();
                    pictureBox10.Visible = true;
                    break;
                default:
                    break;
            }

            int tmp = 0;
            int tmpAce = 0;
            foreach (Card i in PlayerCards)
            {
                //Console.Out.WriteLine(i);
                tmp += i.CardValue;
                if (i.CardFace == Card.CardType.Ace)
                {
                    if (tmpAce + 10 == 21)
                    {
                        //Console.Out.WriteLine("BlackJack! Player Wins!");
                        PlayerCards.Clear();
                        tmpAce += i.CardValue;
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
            }
            if (tmp > 21)
            {
                //Console.Out.WriteLine("Bust! Dealer Wins!");
                PlayerCards.Clear();
            }
            else if (tmp == 21)
            {
                //Console.Out.WriteLine("BlackJack! Player Wins!");
                PlayerCards.Clear();
            }
            else
            {
                playerScore = tmp;
            }
        }

        private void Stand_Click(object sender, EventArgs e)
        {

        }

        private void SaveLog_Click(object sender, EventArgs e)
        {

        }

        private void Bet_Click(object sender, EventArgs e)
        {

        }

        //-----------------------------------------------
        // Check if the deck has cards and returns a card,
        // if the deck is empty the cards are shuffled.
        // -The Deck Class has a ThrowCard method that returns null
        // if the deck no longer has any cards, and a suffle class
        // that reinitilizes the deck. 
        //-----------------------------------------------
        private Card myThrowCard()
        {
            Card x = GameDeck.ThrowCard();
            if (x == null)
            {
                //Console.Out.WriteLine("Game Deck is empty, shuffling and clearing the game.\n New Game:\n");
                PlayerCards.Clear();
                DealerCards.Clear();
                hidePlayerPictureBoxes();
                hideDealerPictureBoxes();
                GameDeck.ShuffleDeck();
                return GameDeck.ThrowCard();
            }
            else
            {
                return x;
            }
        }
        private void hidePlayerPictureBoxes()
        {
            pictureBox1.Visible = false;
            pictureBox2.Visible = false;
            pictureBox3.Visible = false;
            pictureBox4.Visible = false;
            pictureBox5.Visible = false;
            pictureBox6.Visible = false;
            pictureBox7.Visible = false;
            pictureBox8.Visible = false;
            pictureBox9.Visible = false;
            pictureBox10.Visible = false;
        }
        private void hideDealerPictureBoxes()
        {
            pictureBox11.Visible = false;
            pictureBox12.Visible = false;
            pictureBox13.Visible = false;
            pictureBox14.Visible = false;
            pictureBox15.Visible = false;
            pictureBox16.Visible = false;
            pictureBox17.Visible = false;
            pictureBox18.Visible = false;
            pictureBox19.Visible = false;
            pictureBox20.Visible = false;
        }
    }
}
