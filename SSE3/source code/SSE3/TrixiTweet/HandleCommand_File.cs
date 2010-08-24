using System;
using System.Collections.Generic;
using System.Text;
using Twitterizer.Framework;

namespace Global
{
    public class Vars
    {

        public const string APPSOURCE = "trixitweet";
    }
}

namespace TrixiTweet
{
    class CommandHandler
    {
        private static void printList(TwitterStatusCollection col, string[] args)
        {
            if (args.Length > 1)
            {
                if (args[1] == "latest")
                {
                    TwitterStatus status = col[0];
                    // print out user status messages
                    Console.WriteLine("{0} /{1}/ [{2}]:\t\n{3}", status.TwitterUser.ScreenName,
                        status.TwitterUser,status.Created.ToLongTimeString(), status.Text);

                    Console.WriteLine();
                }
                else if (args[1] == "oldest")
                {
                    TwitterStatus status = col[col.Count -1];
                    // print out user status messages
                    Console.WriteLine("{0} /{1}/ [{2}]:\t\n{3}", status.TwitterUser.ScreenName,
                        status.TwitterUser, status.Created.ToLongTimeString(), status.Text);

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
                for(int i = col.Count-1; i >= 0; i--)
                {
                    TwitterStatus status = col[i];
                    // print out user status messages
                    Console.WriteLine("{0} /{1}/ [{2}]:\t\n{3}", status.TwitterUser.ScreenName,
                        status.TwitterUser, status.Created.ToLongTimeString(), status.Text);

                    Console.WriteLine();
                }
            }
        }

        public static void HandleCommand(string[] args, Twitterizer.Framework.Twitter core, string username, string password)
        {
            Twitterizer.Framework.TwitterParameters Parameters = new Twitterizer.Framework.TwitterParameters();
            Parameters.Add(TwitterParameterNames.Since, DateTime.Today.AddDays(-1));
            TwitterStatusCollection col;
            //Users users = null; // the users and status messages
            switch (args[0].ToLower())
            {
                case "status":
                    string user = null;
                    int i = 1;
                    StringBuilder s = new StringBuilder();
                    if( args[i][0] == '@')
                    {
                        user = args[1].Substring(1);
                    }
                    for(; i < args.Length; i++)
                    {
                        s.Append(args[i]);
                        if (i != args.Length - 1)
                        {
                            s.Append(" ");
                        }
                    }
                    try
                    {
                        core.Status.Update(s.ToString());
                        if (user != null)
                        {
                            s = s.Remove(0, args[1].Length + 1);
                            Console.WriteLine("Replied to {0} with: {1}", user, s.ToString());
                        }
                        else
                        {
                            Console.WriteLine("Updated with: {0}", s.ToString());
                        }
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                        Console.ReadLine();
                        throw new Exception("Failed");
                    }
                    break;
                case "friends":
                    // request friends timeline from twitter
                    Console.WriteLine("Downloading timeline from Twitter...");
                    try
                    {
                        col = core.Status.FriendsTimeline(Parameters);
                    }
                    catch (System.Net.WebException e)
                    {
                        Console.WriteLine(e.Message);
                        Console.ReadLine();
                        throw new Exception("Failed");
                    }
                    printList(col, args);
                    break;
                case "show":
                    if (args.Length != 2)
                    {
                        Console.WriteLine("Incorrect number of parameters for \"show\".");
                        Console.WriteLine("Usage: show <username>");
                        break;
                    }
                    TwitterUser userThis = core.Status.Show(args[1]);
                    Console.WriteLine("{0}\t\t{1}", userThis.UserName, userThis.ScreenName);
                    Console.WriteLine("Status: {0}", userThis.Status.Text);
                    Console.WriteLine("Location {0}", userThis.Location);
                    Console.WriteLine("{0}", userThis.ProfileUri);
                    if(userThis.IsProtected)
                        Console.WriteLine("ID = {0}, Protected Updates: {1}", userThis.ID, "Yes");
                    else
                        Console.WriteLine("ID = {0}, Protected Updates: {1}", userThis.ID, "No");
                    Console.WriteLine("Friends = {0}, Followers = {1}", userThis.Friends_count, userThis.NumberOfFollowers);
                    Console.WriteLine("Desc: {0}", userThis.Description);
                    Console.WriteLine();

                    break;
                case "replies":
                    try
                    {
                        col = core.Status.Replies();
                    }
                    catch (System.Net.WebException e)
                    {
                        Console.WriteLine(e.Message);
                        Console.ReadLine();
                        throw new Exception("Failed");
                    }

                    printList(col, args);
                    break;
                case "user":
                    // request users's timeline from twitter
                    
                    Console.WriteLine("Downloading user timeline from Twitter...");
                    try
                    {
                        col = core.Status.UserTimeline();
                    }
                    catch (System.Net.WebException e)
                    {
                        Console.WriteLine(e.Message);
                        Console.ReadLine();
                        throw new Exception("Failed");
                    }

                    printList(col, args);
                    break;
                case "everyone":
                    // request everyone's timeline from twitter
                    Console.WriteLine("Downloading timeline from Twitter...");
                    try
                    {
                        col = core.Status.PublicTimeline();
                    }
                    catch (System.Net.WebException e)
                    {
                        Console.WriteLine(e.Message);
                        Console.ReadLine();
                        throw new Exception("Failed");
                    }

                    printList(col, args);
                    break;
                case "direct":
                    try
                    {
                        col = core.DirectMessages.DirectMessages();
                    }
                    catch (System.Net.WebException e)
                    {
                        Console.WriteLine(e.Message);
                        Console.ReadLine();
                        throw new Exception("Failed");
                    }

                    printList(col, args);
                    break;
                case "directsent":
                    try
                    {
                        col = core.DirectMessages.DirectMessagesSent();
                    }
                    catch (System.Net.WebException e)
                    {
                        Console.WriteLine(e.Message);
                        Console.ReadLine();
                        throw new Exception("Failed");
                    }

                    printList(col, args);
                    break;
                case "cls":
                    Console.Clear();
                    break;
                case "days":
                    if (args.Length != 2)
                    {
                        Console.WriteLine("Incorrect number of parameters for \"days\".");
                        Console.WriteLine("Usage: days <number of days>");
                        break;
                    }
                    Parameters.Remove(TwitterParameterNames.Since);
                    int days = Int16.Parse(args[1]) * -1;
                    Parameters.Add(TwitterParameterNames.Since, DateTime.Today.AddDays(days));
                    if (days < 0)
                        Console.WriteLine("Updating from {0} days ago.", days*-1);
                    else
                        Console.WriteLine("Updating from only today.");
                    break;
                case "help":
                    Console.WriteLine("List of commands:");
                    Console.WriteLine("\tCOMMAND\t\t\t\tDESCRIPTION");
                    Console.WriteLine();
                    Console.WriteLine("\tstatus <message>\t\tUpdate status.");
                    Console.WriteLine("\tuser [latest/oldest]\t\tGet Your Updates");
                    Console.WriteLine("\tfriends [latest/oldest]\t\tGet Friends updates");
                    Console.WriteLine("\teveryone [latest/oldest]\tGet Everyone's updates");
                    Console.WriteLine("\treplies [latest/oldest]\t\tGet replies to you.");
                    Console.WriteLine("\tdirect [latest/oldest]\t\tGet direct messages to you.");
                    Console.WriteLine("\tdirectsent [latest/oldest]\tGet direct messages from you.");
                    Console.WriteLine("\tshow <username>\t\t\tShow information about <username>");
                    Console.WriteLine("\texit\t\t\t\tQuits the application");
                    Console.WriteLine("\tcls\t\t\t\tClears the screen");
                    Console.WriteLine();
                    Console.WriteLine("\tdays <number>\t\t\tThe number of days to count");
                    Console.WriteLine("\t\t\t\t\tback from (0 for today) in the messages.");
                    
                    Console.WriteLine();
                    Console.WriteLine("[<command>] means the <command> inside the brackets is optional");
                    Console.WriteLine("<info> is the information provided by the user.");
                    Console.WriteLine();
                    break;
                case "exit":
                    break;
                default:
                    Console.WriteLine("That command is invalid.");
                    break;
            }
        }
    }
}
