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
            //CommandForm(command, tokens);

        }

        private void Crawl_Click(object sender, EventArgs e)
        {
            incomingTweets.Text += "Hello World \n";
            feedback.Text += "Hello World \n";
            sortTweets.Text += "Hello World \n";
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

        private static void printList(TwitterStatusCollection col, string[] args, bool containsUser)
        {
            int lengthToCheck = 1;
            string source = string.Empty;
            if (containsUser)
                lengthToCheck++;
            if (args.Length > lengthToCheck)
            {
                if (args[lengthToCheck] == "latest")
                {
                    TwitterStatus status = col[0];

                    if (status.Source != string.Empty && status.Source.LastIndexOf('<') - status.Source.IndexOf('>') - 1 >= 0)
                        source = status.Source.Substring(status.Source.IndexOf('>') + 1, status.Source.LastIndexOf('<') - status.Source.IndexOf('>') - 1);
                    // print out user status messages
                    if (source != string.Empty)
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4} \nfrom {5}", status.User.ScreenName,
                            status.User.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text, source);
                    }
                    else
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4}", status.User.ScreenName,
                            status.User.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text);
                    }

                    Console.WriteLine();
                }
                else if (args[lengthToCheck] == "oldest")
                {
                    TwitterStatus status = col[col.Count - 1];
                    if (status.Source != string.Empty && status.Source.LastIndexOf('<') - status.Source.IndexOf('>') - 1 >= 0)
                        source = status.Source.Substring(status.Source.IndexOf('>') + 1, status.Source.LastIndexOf('<') - status.Source.IndexOf('>') - 1);
                    // print out user status messages
                    if (source != string.Empty)
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4} \nfrom {5}", status.User.ScreenName,
                            status.User.Name, status.Id, status.CreatedDate.ToLongTimeString(), status.Text, source);
                    }
                    else
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4}", status.User.ScreenName,
                            status.User.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text);
                    }

                    Console.WriteLine();
                }
                else
                {
                    Console.WriteLine("That command is invalid.");
                }
            }
            else
            {
                //foreach (TwitterStatus status in col)
                for (int i = col.Count - 1; i >= 0; i--)
                {
                    TwitterStatus status = col[i];
                    if (status.Source != string.Empty && status.Source.LastIndexOf('<') - status.Source.IndexOf('>') - 1 >= 0)
                        source = status.Source.Substring(status.Source.IndexOf('>') + 1, status.Source.LastIndexOf('<') - status.Source.IndexOf('>') - 1);
                    else if (status.Source == "web")
                        source = "web";
                    // print out user status messages
                    if (source != string.Empty)
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4} \nfrom {5}", status.User.ScreenName,
                            status.User.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text, source);
                    }
                    else
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4}", status.User.ScreenName,
                            status.User.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text);
                    }

                    Console.WriteLine();
                }
            }
        }

        public void CommandForm(string[] args, OAuthTokens tokens)
        {
            System.Configuration.ExeConfigurationFileMap fileMap = new System.Configuration.ExeConfigurationFileMap()
            {
                ExeConfigFilename = System.IO.Path.Combine(Environment.CurrentDirectory, "SSE3.config")
            };
            System.Configuration.Configuration appconfig = System.Configuration.ConfigurationManager.OpenMappedExeConfiguration(fileMap, System.Configuration.ConfigurationUserLevel.None);
            TwitterStatusCollection col = null;
            TwitterDirectMessageCollection dmcol = null;
            TwitterUser user = new TwitterUser();

            int i = 2;
            StringBuilder s = new StringBuilder();
            TwitterStatus repname = TwitterStatus.Show(tokens, decimal.Parse(args[1]));

            switch (args[0].ToLower())
            {
                case "show": //show <username> Show information about <username>
                    if (args.Length != 2)
                    {
                        feedback.Text += "Incorrect number of parameters for \"show\"." + "\n";
                        break;
                    }
                    TwitterUser userThis = TwitterUser.Search(tokens, args[1])[0];
                    incomingTweets.Text += userThis.Name + " " + userThis.ScreenName + "\n";

                    if (userThis.Status != null)
                        incomingTweets.Text += "Status: " + userThis.Status.Text + "\n";

                    incomingTweets.Text += "Location: " + userThis.Location + "\n";

                    incomingTweets.Text += "Status: " + userThis.Website + "\n";

                    if (userThis.IsProtected)
                        incomingTweets.Text += "ID = " + userThis.Status.Id + "Protected Updates: Yes" + "\n";
                    else
                        incomingTweets.Text += "ID = " + userThis.Status.Id + "Protected Updates: No" + "\n";

                    incomingTweets.Text += "Friends = " + userThis.NumberOfFriends + "Followers = " + userThis.NumberOfFollowers + "\n";
                    incomingTweets.Text += "Desc: " + userThis.Description + "\n";
                    
                    incomingTweets.Text += "\n";

                    break;
                case "replies": //replies [latest/oldest] Get replies to you
                    try
                    {
                        col = TwitterTimeline.Mentions(tokens);
                    }
                    catch
                    {
                        incomingTweets.Text += "Cannot get Timeline: " + RequestStatus.LastRequestStatus.ErrorDetails.ErrorMessage + "\n";
                    }

                    printList(col, args, false);
                    break;
                case "user": //user <user> [latest/oldest] Get Your or <user's> Updates
                    // request users's timeline from twitter
                    user = new TwitterUser();
                    bool hasUser = false;
                    UserTimelineOptions utloptions = new UserTimelineOptions();
                    utloptions.IncludeRetweets = true;
                    if (args.Length > 1)
                    {
                        user.ScreenName = args[1];
                    }
                    Console.WriteLine("Downloading user timeline from Twitter...");
                    try
                    {
                        if (user.ScreenName != null)
                        {
                            hasUser = true;
                            utloptions.ScreenName = user.ScreenName;
                            col = TwitterTimeline.UserTimeline(tokens, utloptions);
                        }
                        else
                        {
                            TwitterUser usr = TwitterUser.Search(tokens, appconfig.AppSettings.Settings["TrixiTweet.ScreenName"].Value)[0];
                            utloptions.ScreenName = usr.ScreenName;
                            try
                            {
                                col = TwitterTimeline.UserTimeline(tokens, utloptions);
                            }
                            catch
                            {
                                Console.WriteLine("Cannot get Timeline: {0}", RequestStatus.LastRequestStatus.ErrorDetails.ErrorMessage);
                            }
                        }
                    }
                    catch (System.Net.WebException e)
                    {
                        Console.WriteLine(e.Message);
                        Console.ReadLine();
                        throw new Exception("Failed");
                    }
                    printList(col, args, hasUser);
                    break;
                case "everyone": // everyone [latest/oldest] Get Everyone's updates
                    // request everyone's timeline from twitter
                    Console.WriteLine("Downloading timeline from Twitter...");
                    try
                    {
                        col = TwitterTimeline.PublicTimeline(tokens);
                    }
                    catch
                    {
                        Console.WriteLine("Cannot get Timeline: {0}", RequestStatus.LastRequestStatus.ErrorDetails.ErrorMessage);
                    }

                    printList(col, args, false);
                    break;
                case "searchusers": // searchusers <name> Search twitter users for a name
                    s = new StringBuilder();
                    i = 1;
                    for (; i < args.Length; i++)
                    {
                        s.Append(args[i]);
                        if (i != args.Length - 1)
                        {
                            s.Append(" ");
                        }
                    }
                    if (args.Length > 1)
                    {
                        Console.WriteLine("Searching for {0}", s.ToString());
                        TwitterUserCollection tuc = TwitterUser.Search(tokens, s.ToString());
                        foreach (TwitterUser tu in tuc)
                        {
                            Console.WriteLine("Would you like to start following:\n{0} /{1}/ Created: {2} Followers: {3} Following: {4}(Y=yes, N=no, Quit Search=Q)?", tu.ScreenName, tu.Name, tu.CreatedDate, tu.NumberOfFollowers, tu.NumberOfFriends);
                            string ans = Console.ReadLine();
                            ans = ans.ToLower();
                            if (ans.Contains("y"))
                            {
                                if (tu.IsFollowing.Value)
                                {
                                    Console.WriteLine("You are already following that person.");
                                }
                                else
                                {
                                    TwitterFriendship.Create(tokens, tu.Id);
                                    Console.WriteLine("{0} has been added.", tu.ScreenName);
                                }
                            }
                            else if (ans.Contains("q"))
                            {
                                Console.WriteLine("Quitting Search...");
                                break;
                            }
                        }
                    }
                    else
                    {
                        Console.WriteLine("You must supply the name of the person.");
                        break;
                    }
                    break;
                default:
                    feedback.Text += "That command is invalid.";
                    break;
            }
        }

    }
 }
