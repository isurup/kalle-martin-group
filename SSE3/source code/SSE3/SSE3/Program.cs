using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Windows.Forms;
using Twitterizer;

namespace SSE3
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}

//using System;
//using System.Text;
//using CsharpTwitt;
//using System.IO;

//namespace TwitterTest
//{
//    class Program
//    {
//        static void Main(string[] args)
//        {
//            Twitter.PublicTwitt publicTwitter = new Twitter.PublicTwitt();

//            string timeline = publicTwitter.ShowUser("CNNbrk", Twitter.OutputFormatType.xml);

//            StreamWriter writer = new StreamWriter("file.xml");
//            writer.WriteLine(timeline);
//            writer.Close();


//            // DO SOMETHING WITH THE FILE OR timeline STRING...

//            Console.WriteLine("done");

//            Console.ReadLine();
//        }
//    }
