using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace BlackJackGUI
{
    public partial class BlackJackWindow : Form
    {
        public BlackJackWindow()
        {
            InitializeComponent();
        }

        public static Deck GameDeck = new Deck();
        public static List<Card> PlayerCards = new List<Card>();
        public static List<Card> DealerCards = new List<Card>();
        public static int playerScore;
        public static int playerScoreAce; // Needed because of Ace Duality

        //-----------------------------------------------
        // The player hits and the dealer responds
        // The dealer responds to a Hit:
        // Giving the player a card form the deck
        //-----------------------------------------------
        private void Hit_Click(object sender, EventArgs e)
        {
            PlayerCards.Add(myThrowCard());

            int tmp = 0;
            int tmpAce = 0;
            foreach (Card i in PlayerCards)
            {
                //Console.Out.WriteLine(i);
                tmp += i.CardValue;
                if (i.Face == Card.CardType.Ace)
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
        private static Card myThrowCard()
        {
            Card x = GameDeck.ThrowCard();
            if (x == null)
            {
                //Console.Out.WriteLine("Game Deck is empty, shuffling and clearing the game.\n New Game:\n");
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
