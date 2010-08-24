using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.IO;
using System.Windows.Forms;

using Twitterizer;
using System.Configuration;
using System.Runtime.InteropServices;


namespace SSE3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            System.Configuration.ExeConfigurationFileMap fileMap = new System.Configuration.ExeConfigurationFileMap()
            {
                ExeConfigFilename = Path.Combine(Environment.CurrentDirectory, "SSE3.exe.config")
            };

            System.Configuration.Configuration appConfig = System.Configuration.ConfigurationManager.OpenMappedExeConfiguration(fileMap, System.Configuration.ConfigurationUserLevel.None);
            while(appConfig.AppSettings.Settings["Tweet.UserId"] == null)
            {

            }
            tokens.AccessToken = appConfig.AppSettings.Settings["Tweet.AccessToken"].Value;
            tokens.AccessTokenSecret = appConfig.AppSettings.Settings["Tweet.AccessTokenSecret"].Value;
            tokens.ConsumerKey = appConfig.AppSettings.Settings["Tweet.ConsumerKey"].Value;
            tokens.ConsumerSecret = appConfig.AppSettings.Settings["Tweet.ConsumerSecret"].Value;
        }

        public OAuthTokens tokens = new OAuthTokens();

        private void Retrive_Click(object sender, EventArgs e)
        {
            string[] command = new string[1];
            CommandHandler.CommandForm(command, tokens);

            incomingTweets.SelectedText += "Hello World - ";

        }

        private void Crawl_Click(object sender, EventArgs e)
        {
            incomingTweets.SelectedText += "Hello World - ";
            feedback.SelectedText += "Hello World - ";

            sortTweets.SelectionFont = new Font("Arial", (float)7.0, FontStyle.Bold);
            sortTweets.SelectionColor = Color.Blue;
            sortTweets.SelectedText += "Hello World - ";
        }

        private void Sort_Click(object sender, EventArgs e)
        {

        }

        private void timer1_Tick(object sender, EventArgs e)
        {

        }

        private void ClearTweet_Click(object sender, EventArgs e)
        {
            incomingTweets.Clear();
        }

        private void ClearSort_Click(object sender, EventArgs e)
        {
            sortTweets.Clear();
        }
    }
}
