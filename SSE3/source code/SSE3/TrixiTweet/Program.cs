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
using Twitterizer.Framework;

namespace TrixiTweet
{

    class Program
    {
        static void Main(string[] args)
        {
            string username = string.Empty;
            string password = string.Empty;
            string duplicates = string.Empty;
            Console.Write("Twitter Username: ");
            username = Console.ReadLine();
            Console.Write("Twitter Password: ");
            ConsoleKeyInfo info = Console.ReadKey(true);
            while( info.Key != ConsoleKey.Enter)
            {
                if (info.Key != ConsoleKey.Backspace)
                {
                    password += info.KeyChar;
                    Console.Write("*");
                }
                else
                {
                    if (password.Length > 0)
                    {
                        password = password.Substring(0, password.Length - 1);
                        Console.Write("\b \b");
                    }
                }
                info = Console.ReadKey(true);
            }

            Twitterizer.Framework.Twitter core = new Twitterizer.Framework.Twitter(username, password, Global.Vars.APPSOURCE);

            Console.Clear();

            string[] command = new string[80];
            CommandHandler hndlr = new CommandHandler();

            while (command[0] == null || command[0].ToLower() != "exit")
            {
                Console.Write("Twitter Command: ");
                string getCmd = Console.ReadLine();
                command = getCmd.Split(' ');
                try
                {
                    CommandHandler.HandleCommand(command, core, username, password);
                }
                catch (Exception e)
                {
                    if (e.Message == "Failed")
                    {
                        return;
                    }
                    else
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
        }
    }
}
