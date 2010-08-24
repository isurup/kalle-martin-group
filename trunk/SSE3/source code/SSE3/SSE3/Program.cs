using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Windows.Forms;
using Twitterizer;
using System.Configuration;
using System.Runtime.InteropServices;
using System.Threading;

namespace SSE3
{

    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        /// 
        [STAThread]
        static void Main()
        {
            TwitterConsole tc = new TwitterConsole();
            tc.init();

            Thread t = new Thread(tc.run);
            t.Start();
            
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}
