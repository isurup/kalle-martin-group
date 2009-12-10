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
                Console.Out.WriteLine(i);
                tmp += i.CardValue;
                if (i.Face == Card.CardType.Ace)
                {
                    if (tmpAce + 10 == 21)
                    {
                        Console.Out.WriteLine("BlackJack! Player Wins!");
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

        private void Stand_Click(object sender, EventArgs e)
        {

        }

        private void SaveLog_Click(object sender, EventArgs e)
        {

        }

        private void Bet_Click(object sender, EventArgs e)
        {

        }
    }
}
