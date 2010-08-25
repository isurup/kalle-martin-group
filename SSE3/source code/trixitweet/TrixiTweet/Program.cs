/*
 * Authors: Benjamin Payne (trixtur), Josh Payne (kr0w), Stephen Shaw (decriptor)
 * Contact: trixtur@gmail.com
 * Name: TrixiTweet (named after trixtur)
 * Description: Interface with Twitter API from the command line.
 * License: GNU General Public License v2
 * URL: http://tinyurl.com/trixitweet
 */

using System;
using System.Collections.Generic;
using System.Text;
using Twitterizer;
using System.IO;
using System.Configuration;

namespace TrixiTweet
{

    class Program
    {
        static void Main(string[] args)
        {
            System.Configuration.ExeConfigurationFileMap fileMap = new System.Configuration.ExeConfigurationFileMap()
            {
                ExeConfigFilename = Path.Combine(Environment.CurrentDirectory, "TrixiTweet.exe.config")
            };
            System.Configuration.Configuration appConfig = System.Configuration.ConfigurationManager.OpenMappedExeConfiguration(fileMap, System.Configuration.ConfigurationUserLevel.None);
            if (appConfig.AppSettings.Settings["TrixiTweet.UserId"] == null)
            {
                OAuthTokenResponse requestAccessTokens = OAuthUtility.GetRequestToken(
                    System.Configuration.ConfigurationManager.AppSettings["TrixiTweet.ConsumerKey"],
                    System.Configuration.ConfigurationManager.AppSettings["TrixiTweet.ConsumerSecret"]);

                string requestToken = requestAccessTokens.Token;
                //Console.WriteLine("Please go to \n {0}", OAuthUtility.BuildAuthorizationUri(requestAccessTokens.Token).AbsoluteUri);
                System.Diagnostics.Process.Start(OAuthUtility.BuildAuthorizationUri(requestAccessTokens.Token).AbsoluteUri);

                Console.Write("Please enter the pin that was given to you: ");
                string s_pin = Console.ReadLine();
                int pin;
                try
                {
                    pin = int.Parse(s_pin);
                }
                catch (Exception)
                {
                    Console.Write("Incorrect pin.\n\nPress any key to quit.");
                    Console.ReadKey();
                    System.Windows.Forms.Application.Exit();
                    return;
                }
                string s_token = requestAccessTokens.Token;
                OAuthTokenResponse accessTokens = OAuthUtility.GetAccessToken(
                    System.Configuration.ConfigurationManager.AppSettings["TrixiTweet.ConsumerKey"],
                    System.Configuration.ConfigurationManager.AppSettings["TrixiTweet.ConsumerSecret"],
                    s_token,
                    s_pin);
                appConfig.AppSettings.Settings.Add("TrixiTweet.AccessToken", accessTokens.Token);
                appConfig.AppSettings.Settings.Add("TrixiTweet.AccessTokenSecret", accessTokens.TokenSecret);
                appConfig.AppSettings.Settings.Add("TrixiTweet.UserId", accessTokens.UserId.ToString(System.Globalization.CultureInfo.CurrentCulture));
                appConfig.AppSettings.Settings.Add("TrixiTweet.ScreenName", accessTokens.ScreenName);
                appConfig.Save();
                System.Configuration.ConfigurationManager.RefreshSection("appSettings");
            }
            OAuthTokens tokens = new OAuthTokens();
            tokens.AccessToken = appConfig.AppSettings.Settings["TrixiTweet.AccessToken"].Value;
            tokens.AccessTokenSecret = appConfig.AppSettings.Settings["TrixiTweet.AccessTokenSecret"].Value;
            tokens.ConsumerKey = appConfig.AppSettings.Settings["TrixiTweet.ConsumerKey"].Value;
            tokens.ConsumerSecret = appConfig.AppSettings.Settings["TrixiTweet.ConsumerSecret"].Value;
            string[] command = new string[1];
            while (command[0] == null || command[0].ToLower() != "exit")
            {
                Console.Write("Twitter Command: ");
                string getCmd = Console.ReadLine();
                command = getCmd.Split(' ');
                try
                {
                    CommandHandler.HandleCommand(command, tokens);
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
        }
    }
}