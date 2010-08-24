using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Twitterizer;

namespace SSE3
{
    class CommandHandler
    {
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
        private static void dmsprintList(TwitterDirectMessageCollection col, string[] args)
        {
            int lengthToCheck = 1;
            string source = string.Empty;
            if (args.Length > lengthToCheck)
            {
                if (args[lengthToCheck] == "latest")
                {
                    TwitterDirectMessage status = col[0];

                    if (status.Sender.Name != string.Empty && status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1 >= 0)
                        source = status.Sender.ToString().Substring(status.Sender.ToString().IndexOf('>') + 1, status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1);
                    // print out user status messages
                    if (source != string.Empty)
                    {
                        Console.WriteLine("{0} /{1}/\n to {2} /{3}/ [{4}] ID# {5}:\t\n{6} \nfrom {7}", status.SenderScreenName,
                            status.Sender.Name, status.RecipientScreenName, status.Recipient.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text, source);
                    }
                    else
                    {
                        Console.WriteLine("{0} /{1}/\n to {2} /{3}/ [{4}] ID# {5}:\t\n{6}", status.SenderScreenName,
                            status.Sender.Name, status.RecipientScreenName, status.Recipient.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text);
                    }

                    Console.WriteLine();
                }
                else if (args[lengthToCheck] == "oldest")
                {
                    TwitterDirectMessage status = col[col.Count - 1];
                    if (status.Sender.Name != string.Empty && status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1 >= 0)
                        source = status.Sender.ToString().Substring(status.Sender.ToString().IndexOf('>') + 1, status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1);
                    // print out user status messages
                    if (source != string.Empty)
                    {
                        Console.WriteLine("{0} /{1}/\n to {2} /{3}/ [{4}] ID# {5}:\t\n{6} \nfrom {7}", status.SenderScreenName,
                            status.Sender.Name, status.RecipientScreenName, status.Recipient.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text, source);
                    }
                    else
                    {
                        Console.WriteLine("{0} /{1}/\n to {2} /{3}/ [{4}] ID# {5}:\t\n{6}", status.SenderScreenName,
                            status.Sender.Name, status.RecipientScreenName, status.Recipient.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text);
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
                    TwitterDirectMessage status = col[i];
                    if (status.Sender.Name != string.Empty && status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1 >= 0)
                        source = status.Sender.ToString().Substring(status.Sender.ToString().IndexOf('>') + 1, status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1);
                    // print out user status messages
                    if (source != string.Empty)
                        source = "web";
                    // print out user status messages
                    if (source != string.Empty)
                    {
                        Console.WriteLine("{0} /{1}/\n to {2} /{3}/ [{4}] ID# {5}:\t\n{6} \nfrom {7}", status.SenderScreenName,
                            status.Sender.Name, status.RecipientScreenName, status.Recipient.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text, source);
                    }
                    else
                    {
                        Console.WriteLine("{0} /{1}/\n to {2} /{3}/ [{4}] ID# {5}:\t\n{6}", status.SenderScreenName,
                            status.Sender.Name, status.RecipientScreenName, status.Recipient.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text);
                    }

                    Console.WriteLine();
                }
            }
        }
        private static void dmprintList(TwitterDirectMessageCollection col, string[] args)
        {
            int lengthToCheck = 1;
            string source = string.Empty;
            if (args.Length > lengthToCheck)
            {
                if (args[lengthToCheck] == "latest")
                {
                    TwitterDirectMessage status = col[0];

                    if (status.Sender.Name != string.Empty && status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1 >= 0)
                        source = status.Sender.ToString().Substring(status.Sender.ToString().IndexOf('>') + 1, status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1);
                    // print out user status messages
                    if (source != string.Empty)
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4} \nfrom {5}", status.SenderScreenName,
                            status.Sender.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text, source);
                    }
                    else
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4}", status.SenderScreenName,
                            status.Sender.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text);
                    }

                    Console.WriteLine();
                }
                else if (args[lengthToCheck] == "oldest")
                {
                    TwitterDirectMessage status = col[col.Count - 1];
                    if (status.Sender.Name != string.Empty && status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1 >= 0)
                        source = status.Sender.ToString().Substring(status.Sender.ToString().IndexOf('>') + 1, status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1);
                    // print out user status messages
                    if (source != string.Empty)
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4} \nfrom {5}", status.SenderScreenName,
                            status.Sender.Name, status.Id, status.CreatedDate.ToLongTimeString(), status.Text, source);
                    }
                    else
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4}", status.SenderScreenName,
                            status.Sender.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text);
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
                    TwitterDirectMessage status = col[i];
                    if (status.Sender.Name != string.Empty && status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1 >= 0)
                        source = status.Sender.ToString().Substring(status.Sender.ToString().IndexOf('>') + 1, status.Sender.ToString().LastIndexOf('<') - status.Sender.ToString().IndexOf('>') - 1);
                    // print out user status messages
                    if (source != string.Empty)
                        source = "web";
                    // print out user status messages
                    if (source != string.Empty)
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4} \nfrom {5}", status.SenderScreenName,
                            status.Sender.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text, source);
                    }
                    else
                    {
                        Console.WriteLine("{0} /{1}/ [{2}] ID# {3}:\t\n{4}", status.SenderScreenName,
                            status.Sender.Name, status.CreatedDate.ToLongTimeString(), status.Id, status.Text);
                    }

                    Console.WriteLine();
                }
            }
        }
        public static void HandleCommand(string[] args, OAuthTokens tokens)
        {
            System.Configuration.ExeConfigurationFileMap fileMap = new System.Configuration.ExeConfigurationFileMap()
            {
                ExeConfigFilename = System.IO.Path.Combine(Environment.CurrentDirectory, "TrixiTweet.exe.config")
            };
            System.Configuration.Configuration appconfig = System.Configuration.ConfigurationManager.OpenMappedExeConfiguration(fileMap, System.Configuration.ConfigurationUserLevel.None);
            TwitterStatusCollection col = null;
            TwitterDirectMessageCollection dmcol = null;
            TwitterUser user = new TwitterUser();
            switch (args[0].ToLower())
            {
                case "reply":
                    int i = 2;
                    StringBuilder s = new StringBuilder();
                    TwitterStatus repname = TwitterStatus.Show(tokens, decimal.Parse(args[1]));
                    for (; i < args.Length; i++)
                    {
                        s.Append(args[i]);
                        if (i != args.Length - 1)
                        {
                            s.Append(" ");
                        }
                    }
                    try
                    {
                        int formattingBuffer = 6; //This is used to make the string look nicer in twitter.
                        int MAXLENGTH = 140;//Maximum length of twitter string is 140
                        if (s.Length > MAXLENGTH)
                        {
                            int multiplier = 0;
                            int to_check;
                            string to_continue;
                            Console.WriteLine("The message is too long and will be truncated on Twitter.");
                            Console.Write("Continue? (y, n)");
                            to_continue = Console.ReadLine();
                            if (char.ToLower(to_continue[0]) == 'n')
                                break;
                            string currentString;
                            do
                            {
                                to_check = MAXLENGTH - formattingBuffer - multiplier.ToString().Length;
                                currentString = s.ToString().Substring(multiplier * to_check, to_check);
                                multiplier += 1;
                                StringBuilder chunkStatus = new StringBuilder();
                                chunkStatus.Append("{");
                                chunkStatus.Append(multiplier.ToString());
                                chunkStatus.Append("} ");
                                chunkStatus.Append(currentString);
                                chunkStatus.Append("...");
                                StatusUpdateOptions suoptions = new StatusUpdateOptions();
                                suoptions.InReplyToStatusId = decimal.Parse(args[1]);
                                TwitterStatus newstatus = TwitterStatus.Update(tokens, chunkStatus.ToString(), suoptions);
                                Console.WriteLine("Reply sent with status {0}", newstatus.RequestStatus.Status);
                            } while (s.ToString().Substring(multiplier * to_check).Length > to_check);
                            if (s.ToString().Substring(multiplier * to_check).Length > 0)
                            {
                                currentString = s.ToString().Substring(multiplier * to_check);
                                multiplier += 1;
                                StringBuilder chunkStatus = new StringBuilder();
                                chunkStatus.Append("{");
                                chunkStatus.Append(multiplier.ToString());
                                chunkStatus.Append("} ");
                                chunkStatus.Append(currentString);
                                TwitterStatus newstatus = TwitterStatus.Update(tokens, chunkStatus.ToString());
                                Console.WriteLine("Reply sent with status {0}", newstatus.RequestStatus.Status);
                            }

                            Console.WriteLine("Updated with multiple tweets: {0}", s.ToString());

                            break;
                        }

                        if (user != null)
                        {
                            StatusUpdateOptions reply = new StatusUpdateOptions();
                            reply.InReplyToStatusId = decimal.Parse(args[1]);
                            TwitterStatus newstatus = TwitterStatus.Update(tokens, "@" + repname.User.ScreenName + " " + s.ToString(), reply);
                            Console.WriteLine("Replied to {0} with: {1}", repname.User.ScreenName, s.ToString());
                        }
                        else
                        {
                            Console.Write("\nError: reply had incorrect format.\n");
                        }
                    }
                    catch (TwitterizerException e)
                    {
                        if (!e.Message.Contains("404"))
                        {
                            Console.WriteLine(e.Message);
                            Console.ReadLine();
                            throw new Exception("Failed");
                        }
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                        Console.ReadLine();
                        throw new Exception("Failed");
                    }
                    break;
                case "status":
                    user = null;
                    i = 1;
                    s = new StringBuilder();
                    if (args[i][0] == '@')
                    {
                        user.Name = args[1].Substring(1);
                    }
                    for (; i < args.Length; i++)
                    {
                        s.Append(args[i]);
                        if (i != args.Length - 1)
                        {
                            s.Append(" ");
                        }
                    }
                    try
                    {
                        int formattingBuffer = 6; //This is used to make the string look nicer in twitter.
                        int MAXLENGTH = 140;//Maximum length of twitter string is 140
                        if (s.Length > MAXLENGTH)
                        {
                            int multiplier = 0;
                            int to_check;
                            string to_continue;
                            Console.WriteLine("The message is too long and will be truncated on Twitter.");
                            Console.Write("Continue? (y, n)");
                            to_continue = Console.ReadLine();
                            if (char.ToLower(to_continue[0]) == 'n')
                                break;
                            string currentString;
                            do
                            {
                                to_check = MAXLENGTH - formattingBuffer - multiplier.ToString().Length;
                                currentString = s.ToString().Substring(multiplier * to_check, to_check);
                                multiplier += 1;
                                StringBuilder chunkStatus = new StringBuilder();
                                chunkStatus.Append("{");
                                chunkStatus.Append(multiplier.ToString());
                                chunkStatus.Append("} ");
                                chunkStatus.Append(currentString);
                                chunkStatus.Append("...");
                                TwitterStatus newstatus = TwitterStatus.Update(tokens, chunkStatus.ToString());
                            } while (s.ToString().Substring(multiplier * to_check).Length > to_check);
                            if (s.ToString().Substring(multiplier * to_check).Length > 0)
                            {
                                currentString = s.ToString().Substring(multiplier * to_check);
                                multiplier += 1;
                                StringBuilder chunkStatus = new StringBuilder();
                                chunkStatus.Append("{");
                                chunkStatus.Append(multiplier.ToString());
                                chunkStatus.Append("} ");
                                chunkStatus.Append(currentString);
                                TwitterStatus newstatus = TwitterStatus.Update(tokens, chunkStatus.ToString());
                            }

                            Console.WriteLine("Updated with multiple tweets: {0}", s.ToString());

                            break;
                        }

                        if (user != null)
                        {
                            Twitterizer.StatusUpdateOptions reply = new StatusUpdateOptions();
                            reply.InReplyToStatusId = user.Id;
                            TwitterUser reply_to = TwitterUser.Show(user.Status.Id);
                            string response = string.Empty;
                            if (reply_to.Status != null)
                            {
                                Console.Write("Is this in reply to: {0} ? (y, n)", reply_to.Status.Text);
                                response = Console.ReadLine();
                            }
                            else
                                response = "n";

                            if (char.ToLower(response[0]) == 'y')
                            {
                                TwitterStatus newstatus = TwitterStatus.Update(tokens, s.ToString(), reply);
                            }
                            else
                            {
                                TwitterStatus newstatus = TwitterStatus.Update(tokens, s.ToString());
                            }
                            s = s.Remove(0, args[1].Length + 1);
                            Console.WriteLine("Replied to {0} with: {1}", user, s.ToString());
                        }
                        else
                        {
                            TwitterStatus newstatus = TwitterStatus.Update(tokens, s.ToString());
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
                        TimelineOptions toptions = new TimelineOptions();
                        toptions.IncludeRetweets = true;
                        col = TwitterTimeline.FriendTimeline(tokens, toptions);
                    }
                    catch
                    {
                        Console.WriteLine("Cannot get Timeline: {0}", RequestStatus.LastRequestStatus.ErrorDetails.ErrorMessage);
                    }
                    printList(col, args, false);
                    break;
                case "show":
                    if (args.Length != 2)
                    {
                        Console.WriteLine("Incorrect number of parameters for \"show\".");
                        Console.WriteLine("Usage: show <username>");
                        break;
                    }
                    TwitterUser userThis = TwitterUser.Search(tokens, args[1])[0];
                    Console.WriteLine("{0}\t\t{1}", userThis.Name, userThis.ScreenName);
                    if (userThis.Status != null)
                        Console.WriteLine("Status: {0}", userThis.Status.Text);
                    Console.WriteLine("Location {0}", userThis.Location);
                    Console.WriteLine("{0}", userThis.Website);
                    if (userThis.IsProtected)
                        Console.WriteLine("ID = {0}, Protected Updates: {1}", userThis.Status.Id, "Yes");
                    else
                        Console.WriteLine("ID = {0}, Protected Updates: {1}", userThis.Status.Id, "No");

                    Console.WriteLine("Friends = {0}, Followers = {1}", userThis.NumberOfFriends, userThis.NumberOfFollowers);
                    Console.WriteLine("Desc: {0}", userThis.Description);
                    Console.WriteLine();

                    break;
                case "replies":
                    try
                    {
                        col = TwitterTimeline.Mentions(tokens);
                    }
                    catch
                    {
                        Console.WriteLine("Cannot get Timeline: {0}", RequestStatus.LastRequestStatus.ErrorDetails.ErrorMessage);
                    }

                    printList(col, args, false);
                    break;
                case "user":
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
                case "delete":
                    TwitterStatus status = TwitterStatus.Show(decimal.Parse(args[1]));
                    try
                    {
                        TwitterStatus.Delete(tokens, decimal.Parse(args[1]));
                        Console.WriteLine("Deleted {0}", status.Text);
                    }
                    catch
                    {
                        Console.WriteLine("Cannot delete status: {0}", RequestStatus.LastRequestStatus.ErrorDetails.ErrorMessage);
                    }
                    break;
                case "everyone":
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
                case "direct":
                    try
                    {
                        dmcol = TwitterDirectMessage.DirectMessages(tokens);
                    }
                    catch
                    {
                        Console.WriteLine("Cannot get Timeline: {0}", RequestStatus.LastRequestStatus.ErrorDetails.ErrorMessage);
                    }
                    dmprintList(dmcol, args);
                    break;
                case "directsent":
                    try
                    {
                        dmcol = TwitterDirectMessage.DirectMessagesSent(tokens);
                    }
                    catch
                    {
                        Console.WriteLine("Cannot get Timeline: {0}", RequestStatus.LastRequestStatus.ErrorDetails.ErrorMessage);
                    }
                    dmsprintList(dmcol, args);
                    break;
                case "cls":
                    Console.Clear();
                    break;
                case "directmessage":
                    TwitterUser dmuser = TwitterUser.Search(tokens, args[1])[0];
                    s = new StringBuilder();
                    i = 2;
                    for (; i < args.Length; i++)
                    {
                        s.Append(args[i]);
                        if (i != args.Length - 1)
                        {
                            s.Append(" ");
                        }
                    }
                    try
                    {
                        int formattingBuffer = 6; //This is used to make the string look nicer in twitter.
                        int MAXLENGTH = 140;//Maximum length of twitter string is 140
                        if (s.Length > MAXLENGTH)
                        {
                            int multiplier = 0;
                            int to_check;
                            string to_continue;
                            Console.WriteLine("The message is too long and will be truncated on Twitter.");
                            Console.Write("Continue? (y, n)");
                            to_continue = Console.ReadLine();
                            if (char.ToLower(to_continue[0]) == 'n')
                                break;
                            string currentString;
                            do
                            {
                                to_check = MAXLENGTH - formattingBuffer - multiplier.ToString().Length;
                                currentString = s.ToString().Substring(multiplier * to_check, to_check);
                                multiplier += 1;
                                StringBuilder chunkStatus = new StringBuilder();
                                chunkStatus.Append("{");
                                chunkStatus.Append(multiplier.ToString());
                                chunkStatus.Append("} ");
                                chunkStatus.Append(currentString);
                                chunkStatus.Append("...");
                                TwitterDirectMessage tdm = TwitterDirectMessage.Send(tokens, dmuser.Id, chunkStatus.ToString());
                                Console.WriteLine("Direct Message sent with status {0}", tdm.RequestStatus.Status);
                            } while (s.ToString().Substring(multiplier * to_check).Length > to_check);
                            if (s.ToString().Substring(multiplier * to_check).Length > 0)
                            {
                                currentString = s.ToString().Substring(multiplier * to_check);
                                multiplier += 1;
                                StringBuilder chunkStatus = new StringBuilder();
                                chunkStatus.Append("{");
                                chunkStatus.Append(multiplier.ToString());
                                chunkStatus.Append("} ");
                                chunkStatus.Append(currentString);

                                TwitterDirectMessage tdm = TwitterDirectMessage.Send(tokens, dmuser.Id, chunkStatus.ToString());
                                Console.WriteLine("Direct Message sent with status {0}", tdm.RequestStatus.Status);
                            }

                            Console.WriteLine("Updated with multiple messages: {0}", s.ToString());

                            break;
                        }

                        if (dmuser != null)
                        {
                            TwitterDirectMessage tdm = TwitterDirectMessage.Send(tokens, dmuser.Id, s.ToString());
                            Console.WriteLine("Direct Message sent with status {0}", tdm.RequestStatus.Status);
                        }
                        else
                        {
                            Console.Write("\nError: reply had incorrect format.\n");
                        }
                    }
                    catch (TwitterizerException e)
                    {
                        Console.WriteLine("Could not send message because: {0}", e.Message);
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine("Could not send message because: {0}", ex.Message);
                    }
                    break;
                case "unfollow":
                    if (args.Length > 1)
                    {
                        TwitterUser tfunuser = TwitterUser.Search(tokens, args[1])[0];
                        if (tfunuser.IsFollowing.Value)
                        {
                            TwitterFriendship.Delete(tokens, tfunuser.Id);
                            Console.WriteLine("You are no longer following {0}", tfunuser.ScreenName);
                        }
                        else
                        {
                            Console.WriteLine("You must be following the user to unfollow them.");
                        }
                    }
                    else
                    {
                        Console.WriteLine("You must include a username.");
                    }
                    break;
                case "retweet":
                    status = TwitterStatus.Show(decimal.Parse(args[1]));
                    try
                    {
                        TwitterStatus.Retweet(tokens, decimal.Parse(args[1]));
                        Console.WriteLine("Retweeted {0}'s status {1}.", status.User.ScreenName, status.Text);
                    }
                    catch
                    {
                    }
                    break;
                case "follow":
                    if (args.Length > 1)
                    {
                        TwitterUser twfuser = TwitterUser.Search(tokens, args[1])[0];
                        if (twfuser.IsFollowing.Value)
                        {
                            Console.WriteLine("You are already following that person.");
                            break;
                        }
                        try
                        {
                            TwitterFriendship.Create(tokens, twfuser.Id);
                            Console.WriteLine("You are now following {0}", twfuser.ScreenName);
                        }
                        catch
                        {
                            Console.WriteLine("Could not follow because: {0}", RequestStatus.LastRequestStatus.ErrorDetails);
                            break;
                        }
                    }
                    else
                    {
                        Console.WriteLine("You must supply a username.");
                    }
                    break;
                case "searchusers":
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

                case "help":
                    Console.WriteLine("List of commands:");
                    Console.WriteLine("\tCOMMAND\t\t\t\tDESCRIPTION");
                    Console.WriteLine();
                    Console.WriteLine("\tstatus <message>\t\tUpdate status.");
                    Console.WriteLine("\treply [ID] <message>\t\tReply to @User.");
                    Console.Write("\tuser <user> [latest/oldest]\tGet Your or <user's> Updates,\n\t\t\t");
                    Console.WriteLine("\t\t\t<user> is optional.");
                    Console.WriteLine("\tfriends [latest/oldest]\t\tGet Friends updates");
                    Console.WriteLine("\teveryone [latest/oldest]\tGet Everyone's updates");
                    Console.WriteLine("\treplies [latest/oldest]\t\tGet replies to you.");
                    Console.WriteLine("\tdirect [latest/oldest]\t\tGet direct messages to you.");
                    Console.WriteLine("\tdirectsent [latest/oldest]\tGet direct messages from you.");
                    Console.WriteLine("\tshow <username>\t\t\tShow information about <username>");
                    Console.WriteLine("\texit\t\t\t\tQuits the application");
                    Console.WriteLine("\tcls\t\t\t\tClears the screen");
                    Console.WriteLine("\tdirectmessage <user>\t\tSends a Direct Message to <user>.");
                    Console.WriteLine("\tfollow <user>\t\t\tBegin following <user>.");
                    Console.WriteLine("\tunfollow <user>\t\t\tStop following <user>.");
                    Console.WriteLine("\tsearchusers <name>\t\tSearch twitter users for a name.");
                    Console.WriteLine("\tdelete [ID]\t\t\tDelete a status.");
                    Console.WriteLine("\tretweet [ID]\t\t\tRetweet a status.");
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
