using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Twitterizer;

namespace TrixiTweet_GUI
{
    public partial class TweetGUI : UserControl
    {
        public string command = null;
        public decimal id = 0;
        private OAuthTokens tokens = new OAuthTokens();
        private System.Configuration.Configuration m_appConfig;
        public TweetGUI()
        {
            InitializeComponent();
            System.Configuration.ExeConfigurationFileMap fileMap = new System.Configuration.ExeConfigurationFileMap()
            {
                ExeConfigFilename = System.IO.Path.Combine(Environment.CurrentDirectory, "TrixiTweet_GUI.exe.config")
            };
            m_appConfig = System.Configuration.ConfigurationManager.OpenMappedExeConfiguration(fileMap, System.Configuration.ConfigurationUserLevel.None);
            tokens.AccessToken = m_appConfig.AppSettings.Settings["TrixiTweet.AccessToken"].Value;
            tokens.AccessTokenSecret = m_appConfig.AppSettings.Settings["TrixiTweet.AccessTokenSecret"].Value;
            tokens.ConsumerKey = m_appConfig.AppSettings.Settings["TrixiTweet.ConsumerKey"].Value;
            tokens.ConsumerSecret = m_appConfig.AppSettings.Settings["TrixiTweet.ConsumerSecret"].Value;
        }

        private string m_username;
        public string UserName
        {
            get { return m_username; }
            set { m_username = value; m_UserName.Text = m_username; this.Refresh(); }
        }

        private string m_pictureURI;
        public string PictureURI
        {
            get { return m_pictureURI; }
            set { m_pictureURI = value; pictureBox1.ImageLocation = value; this.Refresh(); }
        }

        private string m_time;
        public string TweetTime
        {
            get { return m_time; }
            set { m_time = value; timeLabel.Text = value; this.Refresh(); }
        }

        private string m_source;
        public string Source
        {
            get { return m_source; }
            set { m_source = value; SourceLabelNoLink.Visible = false; SourceLabel.Text = "via " + value; this.Refresh(); }
        }

        private string m_sourceLink;
        public string SourceLink
        {
            get { return m_sourceLink; }
            set { m_sourceLink = value.Substring(value.IndexOf("ht"), value.IndexOf(" ", 3) - 10); this.Refresh(); }
        }

        private string m_source_nolink;
        public string SourceNoLink
        {
            get { return m_source_nolink; }
            set { m_source_nolink = value; SourceLabel.Visible = false; SourceLabelNoLink.Visible = true; SourceLabelNoLink.Text = value; this.Refresh(); }
        }

        private string m_replyto;
        private string m_replytonick;
        public string ReplyToLink
        {
            get { return m_replyto; }
            set { m_replyto = value; m_replytonick = TwitterStatus.Show(Decimal.Parse(value)).User.ScreenName; InreplyLink.Visible = true; InreplyLink.Text = "In reply to " + TwitterStatus.Show(Decimal.Parse(value)).User.ScreenName; this.Refresh(); }
        }

        private string m_tweetText;
        public string TweetTxt
        {
            get{ return m_tweetText; }
            set{ m_tweetText = value; tweetText.Text = value; this.Refresh();}
        }

        private string m_nickName;
        public string Nick
        {
            get { return m_nickName; }
            set { m_nickName = value; NickLabel.Text = value; this.Refresh(); }
        }
        private decimal m_statusID;
        public decimal StatusID
        {
            get { return m_statusID; }
            set { m_statusID = value; }
        }

        private void SourceLabel_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            System.Diagnostics.Process.Start(m_sourceLink);
        }

        private void InreplyLink_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (m_appConfig.AppSettings.Settings["Twitterizer2.EnableSSL"].Value.ToLower() == "true")
            {
                System.Diagnostics.Process.Start("https://twitter.com/" + m_replytonick + "/statuses/"+ m_replyto);
            }
            else
            {
                System.Diagnostics.Process.Start("http://twitter.com/" + m_replytonick + "/statuses/" + m_replyto);
            }
        }

        private void tweetText_LinkClicked(object sender, LinkClickedEventArgs e)
        {
            System.Diagnostics.Process.Start(e.LinkText);
        }

        private void timeLabel_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            if (m_appConfig.AppSettings.Settings["Twitterizer2.EnableSSL"].Value.ToLower() == "true")
            {
                System.Diagnostics.Process.Start("https://twitter.com/" + m_nickName + "/statuses/" + m_statusID.ToString());
            }
            else
            {
                System.Diagnostics.Process.Start("http://twitter.com/" + m_nickName + "/statuses/" + m_statusID.ToString());
            }
        }

        private void TweetGUI_MouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                contextMenuStrip1.Show(MousePosition);
            }
        }

        private void ReplyToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            textBox1.Visible = true;
            SendButton.Visible = true;
            command = "reply";
            id = m_statusID;
        }

        private void retweetToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TwitterStatus.Retweet(tokens, m_statusID);
        }

        private void deleteToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TwitterStatus.Delete(tokens, m_statusID);
            Form.ActiveForm.Update();
            this.Dispose();
        }

        private void directMessageToolStripMenuItem_Click(object sender, EventArgs e)
        {
            textBox1.Visible = true;
            SendButton.Visible = true;
            command = "directmessage";
            id = m_statusID;
        }

        private void SendButton_Click(object sender, EventArgs e)
        {
            switch (command)
            {
                case "reply":
                    StatusUpdateOptions suoptions = new StatusUpdateOptions();
                    suoptions.InReplyToStatusId = id;
                    TwitterStatus newstatus = TwitterStatus.Update(tokens, "@" + m_nickName + " " + textBox1.Text, suoptions);
                    SendButton.Visible = false;
                    textBox1.Text = "";
                    textBox1.Visible = false;
                    TrixiTweet_GUI gui = new TrixiTweet_GUI();
                    gui.Refresh_Tick("TweetGUI", EventArgs.Empty);
                    break;
                case "directmessage":
                    TwitterDirectMessage dm = TwitterDirectMessage.Send(tokens, id, textBox1.Text);
                    textBox1.Text = "";
                    textBox1.Visible = false;
                    SendButton.Visible = false;
                    break;
            }
        }

        private void UnfollowToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TwitterUser unfollowuser = TwitterUser.Search(tokens, m_nickName)[0];
            TwitterFriendship.Delete(tokens, unfollowuser.Id);
            TrixiTweet_GUI.ActiveForm.Refresh();
        }

        private void usersStatusesToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

    }
}
