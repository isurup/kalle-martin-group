using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace BlackJackGUI
{
    public partial class BlackJackWindow : Form
    {
        public BlackJackWindow()
        {
            InitializeComponent();
            textBoxGame.AppendText("♠ ♣ ♥ ♦ BlackJack:\n");   
        }
     
        Deck GameDeck = new Deck();
        List<Card> PlayerCards = new List<Card>();
        List<Card> DealerCards = new List<Card>();

        public static int bet = 0;
        public static int winnings = 0;
        public static int playerScore;
        public static int playerScoreAce; // Needed because of Ace Duality

        //-----------------------------------------------
        // The player hits and the dealer responds
        // The dealer responds to a Hit:
        // Giving the player a card form the deck
        //-----------------------------------------------
        private void Hit_Click(object sender, EventArgs e)
        {
            StreamWriter outFile = File.CreateText(@"../../BlackJack.tmp");
            outFile.WriteLine(textBoxGame.Text);
            outFile.WriteLine("\n");

            if (PlayerCards.Count == 0)
                hidePlayerPictureBoxes();
            if (DealerCards.Count == 0)
                hideDealerPictureBoxes();

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
                        textBoxGame.AppendText("BlackJack! Player Wins!\n");
                        PlayerCards.Clear();
                        winnings = winnings + bet;//wins bet
                        bet = 0; // resest bet
                        textBoxBet.Text = "" + bet;
                        textBoxBetInfo.Text = "Current Winnings: " + winnings;
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
                textBoxGame.AppendText("Bust! Dealer Wins!\n");
                PlayerCards.Clear();
                winnings = winnings - bet; // losses bet
                bet = 0; // resest bet
                textBoxBet.Text = "" + bet;
                textBoxBetInfo.Text = "Current Winnings: " + winnings;
            }
            else if (tmp == 21)
            {
                //Console.Out.WriteLine("BlackJack! Player Wins!");
                textBoxGame.AppendText("BlackJack! Player Wins!\n");
                PlayerCards.Clear();
                winnings = winnings + bet; //wins bet
                bet = 0; // resest bet
                textBoxBet.Text = "" + bet;
                textBoxBetInfo.Text = "Current Winnings: " + winnings;
            }
            else
            {
                playerScore = tmp;
            }
            outFile.Close();
        }

        private void Stand_Click(object sender, EventArgs e)
        {
            if (DealerCards.Count == 0)
                hideDealerPictureBoxes();

            int tmpDealer = 0;
            DealerCards.Clear();

            if (PlayerCards.Count <= 1)
                return;

            do
            {
                Card newCard = myThrowCard();
                DealerCards.Add(newCard);
                tmpDealer += newCard.CardValue;

                switch (DealerCards.Count)
                {
                    case 1:
                        pictureBox11.Image = newCard.CardImage;
                        pictureBox11.BringToFront();
                        pictureBox11.Visible = true;
                        break;
                    case 2:
                        pictureBox12.Image = newCard.CardImage;
                        pictureBox12.BringToFront();
                        pictureBox12.Visible = true;
                        break;
                    case 3:
                        pictureBox13.Image = newCard.CardImage;
                        pictureBox13.BringToFront();
                        pictureBox13.Visible = true;
                        break;
                    case 4:
                        pictureBox14.Image = newCard.CardImage;
                        pictureBox14.BringToFront();
                        pictureBox14.Visible = true;
                        break;
                    case 5:
                        pictureBox15.Image = newCard.CardImage;
                        pictureBox15.BringToFront();
                        pictureBox15.Visible = true;
                        break;
                    case 6:
                        pictureBox16.Image = newCard.CardImage;
                        pictureBox16.BringToFront();
                        pictureBox16.Visible = true;
                        break;
                    case 7:
                        pictureBox17.Image = newCard.CardImage;
                        pictureBox17.BringToFront();
                        pictureBox17.Visible = true;
                        break;
                    case 8:
                        pictureBox18.Image = newCard.CardImage;
                        pictureBox18.BringToFront();
                        pictureBox18.Visible = true;
                        break;
                    case 9:
                        pictureBox19.Image = newCard.CardImage;
                        pictureBox19.BringToFront();
                        pictureBox19.Visible = true;
                        break;
                    case 10:
                        pictureBox20.Image = newCard.CardImage;
                        pictureBox20.BringToFront();
                        pictureBox20.Visible = true;
                        break;
                    default:
                        break;
                }

                if (newCard.CardFace == Card.CardType.Ace)
                {
                    if (tmpDealer + 10 == 21)
                    {
                        //Console.Out.WriteLine("Dealer gets BlackJack! Dealer Wins!");
                        textBoxGame.AppendText("Dealer gets BlackJack! Dealer Wins!\n");
                        PlayerCards.Clear();
                        DealerCards.Clear();
                        winnings = winnings - bet; // losses bet
                        bet = 0; // resest bet
                        textBoxBet.Text = "" + bet;
                        textBoxBetInfo.Text = "Current Winnings: " + winnings;
                    }
                }
                //Console.Out.WriteLine(newCard + " + ");
            } while (tmpDealer < 16); // stops at 17 or above

            if (tmpDealer > 21)
            {
                //Console.Out.WriteLine("Dealer Busts! Player Wins!");
                textBoxGame.AppendText("Dealer Busts! Player Wins!\n");
                PlayerCards.Clear();
                DealerCards.Clear();
                winnings = winnings + bet; // wins bet
                bet = 0; // resest bet
                textBoxBet.Text = "" + bet;
                textBoxBetInfo.Text = "Current Winnings: " + winnings;
            }
            else if (tmpDealer == 21)
            {
                //Console.Out.WriteLine("Dealer gets BlackJack! Dealer Wins!");
                textBoxGame.AppendText("Dealer gets BlackJack! Dealer Wins!\n");
                PlayerCards.Clear();
                DealerCards.Clear();
                winnings = winnings - bet; // losses bet
                bet = 0; // resest bet
                textBoxBet.Text = "" + bet;
                textBoxBetInfo.Text = "Current Winnings: " + winnings;
            }
            else if (tmpDealer > playerScore && tmpDealer > playerScoreAce)
            {
                //Console.Out.WriteLine("Dealer gets Highest! Dealer Wins!");
                PlayerCards.Clear();
                DealerCards.Clear();
                winnings = winnings - bet; // losses bet
                bet = 0; // resest bet
                textBoxBet.Text = "" + bet;
                textBoxBetInfo.Text = "Current Winnings: " + winnings;
            }
            else
            {
                //Console.Out.WriteLine("Dealer stands on: " + tmpDealer);
                if (tmpDealer < playerScore || tmpDealer < playerScoreAce)
                {
                    //Console.Out.WriteLine("Player has highst, Player Wins! ");
                    textBoxGame.AppendText("Player has highst, Player Wins!\n");
                    PlayerCards.Clear();
                    DealerCards.Clear();
                    winnings = winnings + bet;//wins bet
                    bet = 0; // resest bet
                    textBoxBet.Text = "" + bet;
                    textBoxBetInfo.Text = "Current Winnings: " + winnings;
                }
                else
                {
                    //Console.Out.WriteLine("Dealer wins!");
                    textBoxGame.AppendText("Dealer wins!\n");
                    PlayerCards.Clear();
                    DealerCards.Clear();
                    winnings = winnings - bet; // losses bet
                    bet = 0; // resest bet
                    textBoxBet.Text = "" + bet;
                    textBoxBetInfo.Text = "Current Winnings: " + winnings;
                }
            }
        }

        private void SaveLog_Click(object sender, EventArgs e)
        {
            File.Copy(@"../../BlackJack.tmp", @"../../BlackJackLog.txt",true);
        }

        private void Bet_Click(object sender, EventArgs e)
        {
            bet = bet + 5;
            textBoxBet.Text = ""+ bet;
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
                textBoxGame.AppendText("Game Deck is empty, shuffling and clearing the game.\n New Game:\n");
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

        //-----------------------------------------------
        // Hides the picture boxes 
        //-----------------------------------------------
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

        //-----------------------------------------------
        // Our application isn't multithreaded, we use timers to wait
        // so the app is still responsive without using threads
        // !!!!does not work, not used!!!
        //-----------------------------------------------

        private void myWait(int millisecounds)
        {
            Timer aTimer = new Timer();
            aTimer.Interval = millisecounds;
            aTimer.Enabled = true;
            aTimer.Start();
            while (aTimer.Enabled)
            {
                aTimer.Tick += delegate
                {
                    aTimer.Stop();
                };
            }
        }

    }
}
