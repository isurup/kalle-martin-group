using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using System.Configuration;
using Twitterizer;

namespace TrixiTweet_GUI
{
    public partial class TrixiTweet_GUI : Form
    {
        #region "Private member variables"
        private Point scroll = new Point();
        private string s_pin = "";
        private string s_token;
        private int m_pin = 0;
        private OAuthTokenResponse m_requestAccessTokens;
        private System.Configuration.Configuration m_appConfig;
        private OAuthTokens tokens = new OAuthTokens();
        //We need a list for each timeline
        private List<decimal> FriendListAddedTweets = new List<decimal>();
        #endregion

        private void LoadMe()
        {
            System.Configuration.ExeConfigurationFileMap fileMap = new System.Configuration.ExeConfigurationFileMap()
            {
                ExeConfigFilename = Path.Combine(Environment.CurrentDirectory, "TrixiTweet_GUI.exe.config")
            };
            m_appConfig = System.Configuration.ConfigurationManager.OpenMappedExeConfiguration(fileMap, System.Configuration.ConfigurationUserLevel.None);
            if (m_appConfig.AppSettings.Settings["TrixiTweet.UserID"] == null)
            {
                m_requestAccessTokens = OAuthUtility.GetRequestToken(
                    System.Configuration.ConfigurationManager.AppSettings["TrixiTweet.ConsumerKey"],
                    System.Configuration.ConfigurationManager.AppSettings["TrixiTweet.ConsumerSecret"]);
                string requestToken = m_requestAccessTokens.Token;
                System.Diagnostics.Process.Start(OAuthUtility.BuildAuthorizationUri(m_requestAccessTokens.Token).AbsoluteUri);
                m_accessCode.BringToFront();
                m_button.BringToFront();
            }
            else
            {
                FinishLoadMe();
            }
        }

        private void FinishLoadMe()
        {
            tokens.AccessToken = m_appConfig.AppSettings.Settings["TrixiTweet.AccessToken"].Value;
            tokens.AccessTokenSecret = m_appConfig.AppSettings.Settings["TrixiTweet.AccessTokenSecret"].Value;
            tokens.ConsumerKey = m_appConfig.AppSettings.Settings["TrixiTweet.ConsumerKey"].Value;
            tokens.ConsumerSecret = m_appConfig.AppSettings.Settings["TrixiTweet.ConsumerSecret"].Value;
            FriendTimeline(tokens);
            Replies(tokens);
            DirectMessages(tokens);
            DirectSent(tokens);
            Everyone(tokens);
        }

        public TrixiTweet_GUI()
        {
            InitializeComponent();
            this.Show();
            this.Refresh();
            LoadMe();
        }

        public void Refresh_Tick(object sender, EventArgs e)
        {
            //FriendsTimeline.Controls.Clear();
            //RepliesTimeline.Controls.Clear();
            //DirectMessagesTimeline.Controls.Clear();
            //DirectSentTimeline.Controls.Clear();
            if (!tabPage1.IsDisposed)
                FriendTimeline(tokens);
            if (!tabPage2.IsDisposed)
                Replies(tokens);
            if (!tabPage3.IsDisposed)
                DirectMessages(tokens);
            if (!tabPage4.IsDisposed)
                DirectSent(tokens);
        }

        private void Everyone(OAuthTokens tokens)
        {
            //Get Everyone Timeline
            TwitterStatusCollection col;
            TimelineOptions toptions = new TimelineOptions();
            toptions.IncludeRetweets = true;
            col = TwitterTimeline.PublicTimeline(tokens);
            foreach (TwitterStatus status in col)
            {
                TweetGUI g = new TweetGUI();
                if (status.InReplyToStatusId.HasValue)
                    g.ReplyToLink = status.InReplyToStatusId.ToString();
                g.UserName = status.User.Name;
                g.PictureURI = status.User.ProfileImageLocation;
                g.TweetTime = status.CreatedDate.ToShortTimeString();
                g.Nick = status.User.ScreenName;
                g.StatusID = status.Id;
                if (status.Source.Contains("http"))
                {
                    g.Source = status.Source.Substring(status.Source.IndexOf(">") + 1, (status.Source.Substring(status.Source.IndexOf(">") + 1).Length - 4));
                    g.SourceLink = status.Source;
                }
                else
                {
                    g.SourceNoLink = status.Source;
                }
                g.TweetTxt = status.Text;
                this.EveryoneTimeline.Controls.Add(g);
            }
        }

        private void DirectSent(OAuthTokens tokens)
        {
            //Get Direct Messages I sent.
            TwitterDirectMessageCollection dmcol;
            dmcol = TwitterDirectMessage.DirectMessagesSent(tokens);
            foreach (TwitterDirectMessage status in dmcol)
            {
                TweetGUI g = new TweetGUI();
                g.UserName = status.Recipient.Name;
                g.PictureURI = status.Recipient.ProfileImageLocation;
                g.TweetTime = status.CreatedDate.ToShortTimeString();
                g.Nick = status.Recipient.ScreenName;
                g.StatusID = status.Id;
                g.SourceNoLink = "None";
                g.TweetTxt = status.Text;
                this.DirectSentTimeline.Controls.Add(g);
            }
        }

        private void DirectMessages(OAuthTokens tokens)
        {
            //Get DirectMessages
            TwitterDirectMessageCollection dmcol;
            dmcol = TwitterDirectMessage.DirectMessages(tokens);
            foreach (TwitterDirectMessage status in dmcol)
            {
                TweetGUI g = new TweetGUI();
                g.UserName = status.Recipient.Name;
                g.PictureURI = status.Recipient.ProfileImageLocation;
                g.TweetTime = status.CreatedDate.ToShortTimeString();
                g.Nick = status.Recipient.ScreenName;
                g.StatusID = status.Id;
                g.SourceNoLink = "None";
                g.TweetTxt = status.Text;
                this.DirectMessagesTimeline.Controls.Add(g);
            }
        }

        private void Replies(OAuthTokens tokens)
        {
            //Get Replies Timeline
            TwitterStatusCollection col;
            TimelineOptions toptions = new TimelineOptions();
            col = TwitterTimeline.Mentions(tokens);
            foreach (TwitterStatus status in col)
            {
                TweetGUI g = new TweetGUI();
                g.UserName = status.User.Name;
                g.PictureURI = status.User.ProfileImageLocation;
                g.TweetTime = status.CreatedDate.ToShortTimeString();
                g.Nick = status.User.ScreenName;
                g.StatusID = status.Id;
                if (status.Source.Contains("http"))
                {
                    g.Source = status.Source.Substring(status.Source.IndexOf(">") + 1, (status.Source.Substring(status.Source.IndexOf(">") + 1).Length - 4));
                    g.SourceLink = status.Source;
                }
                else
                {
                    g.SourceNoLink = status.Source;
                }
                g.TweetTxt = status.Text;
                this.RepliesTimeline.Controls.Add(g);
            }
        }

        private void FriendTimeline(OAuthTokens tokens)
        {
            //Get User's timeline
            TwitterStatusCollection col;
            TimelineOptions toptions = new TimelineOptions();
            toptions.IncludeRetweets = true;
            col = TwitterTimeline.FriendTimeline(tokens, toptions);
            bool containerChanged = false;
            foreach (TwitterStatus status in col)
            {
                TweetGUI g = new TweetGUI();
                if (status.InReplyToStatusId.HasValue)
                    g.ReplyToLink = status.InReplyToStatusId.ToString();
                g.UserName = status.User.Name;
                g.PictureURI = status.User.ProfileImageLocation;
                g.TweetTime = status.CreatedDate.ToShortTimeString();
                g.Nick = status.User.ScreenName;
                g.StatusID = status.Id;
                if (status.Source.Contains("http"))
                {
                    g.Source = status.Source.Substring(status.Source.IndexOf(">") + 1, (status.Source.Substring(status.Source.IndexOf(">") + 1).Length - 4));
                    g.SourceLink = status.Source;
                }
                else if (status.Source.Contains("href") && status.Source.Contains("txt"))
                {
                    g.SourceNoLink = "txt";
                }
                else
                {
                    g.SourceNoLink = status.Source;
                }
                g.TweetTxt = status.Text;
                if (!FriendListAddedTweets.Contains(status.Id))
                {
                    FriendsTimeline.Controls.Add(g);
                    FriendListAddedTweets.Add(status.Id);
                    containerChanged = true;
                }
            }
            if (containerChanged)
            {
                FriendsTimeline.Update();
                FriendsTimeline.Refresh();
            }
        }

        private void m_button_Click(object sender, EventArgs e)
        {
            s_pin = m_accessCode.Text;

            m_accessCode.SendToBack();
            m_button.SendToBack();
            if (!int.TryParse(s_pin, out m_pin))
            {
                MessageBox.Show("Application will exit", "Incorrect Pin");
                Application.Exit();
            }
            s_token = m_requestAccessTokens.Token;
            OAuthTokenResponse accessTokens = OAuthUtility.GetAccessToken(
                System.Configuration.ConfigurationManager.AppSettings["TrixiTweet.ConsumerKey"],
                System.Configuration.ConfigurationManager.AppSettings["TrixiTweet.ConsumerSecret"],
                s_token,
                s_pin);
            m_appConfig.AppSettings.Settings.Add("TrixiTweet.AccessToken", accessTokens.Token);
            m_appConfig.AppSettings.Settings.Add("TrixiTweet.AccessTokenSecret", accessTokens.TokenSecret);
            m_appConfig.AppSettings.Settings.Add("TrixiTweet.UserId", accessTokens.UserId.ToString(System.Globalization.CultureInfo.CurrentCulture));
            m_appConfig.AppSettings.Settings.Add("TrixiTweet.ScreenName", accessTokens.ScreenName);
            m_appConfig.Save();
            System.Configuration.ConfigurationManager.RefreshSection("appSettings");
            FinishLoadMe();
        }
        public void close_Click(object sender, EventArgs e)
        {
            if (tabControl1.TabCount > 0)
            {
                tabControl1.SelectedTab.Dispose();
            }
            else
            {
                MessageBox.Show("No tab to close.");
            }
        }
        public void flowLayoutPanel1_MouseWheel(object sender, MouseEventArgs e)
        {
            switch (tabControl1.SelectedTab.Name)
            {
                case "tabPage1":
                    scroll.Y = FriendsTimeline.AutoScrollPosition.Y * -1; 
                    scroll.Y += SystemInformation.MouseWheelScrollLines * e.Delta * -1;
                    FriendsTimeline.AutoScrollPosition = scroll;
                    break;
                case "tabPage2":
                    scroll.Y = RepliesTimeline.AutoScrollPosition.Y * -1;
                    scroll.Y += SystemInformation.MouseWheelScrollLines * e.Delta * -1;
                    RepliesTimeline.AutoScrollPosition = scroll;
                    break;
                case "tabPage3":
                    scroll.Y = DirectMessagesTimeline.AutoScrollPosition.Y * -1;
                    scroll.Y += SystemInformation.MouseWheelScrollLines * e.Delta * -1;
                    DirectMessagesTimeline.AutoScrollPosition = scroll;
                    break;
                case "tabPage4":
                    scroll.Y = DirectSentTimeline.AutoScrollPosition.Y * -1;
                    scroll.Y += SystemInformation.MouseWheelScrollLines * e.Delta * -1;
                    DirectSentTimeline.AutoScrollPosition = scroll;
                    break;
                case "tabPage5":
                    scroll.Y = EveryoneTimeline.AutoScrollPosition.Y * -1;
                    scroll.Y += SystemInformation.MouseWheelScrollLines * e.Delta * -1;
                    EveryoneTimeline.AutoScrollPosition = scroll;
                    break;
            }
        }
    }
}
