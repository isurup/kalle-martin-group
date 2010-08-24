using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.IO;
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
            incomingTweets.SelectedText += "Hello World - ";
            feedback.SelectedText += "Hello World - ";

            sortTweets.SelectionFont = new Font("Arial", (float)7.0, FontStyle.Bold);
            sortTweets.SelectionColor = Color.Blue;
            sortTweets.SelectedText += "Hello World - ";
        }

        private void Clear_Click(object sender, EventArgs e)
        {
            incomingTweets.Clear();
        }

        private void Crawl_Click(object sender, EventArgs e)
        {

        }

        private void Sort_Click(object sender, EventArgs e)
        {

        }
    }
}
