using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace SSE3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Retrive_Click(object sender, EventArgs e)
        {
            incomingTweets.Items.Add("hello world aaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa");

            feedback.AppendText("hello world aaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa\n");

            //feedTweets.AppendText("hello world aaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa\n");

            feedTweets.SelectionFont = new Font("Arial", (float)8.75, FontStyle.Bold);
            feedTweets.SelectionColor = Color.DarkBlue;
            feedTweets.SelectedText += "Hello World -- ";
            
        }
    }
}
