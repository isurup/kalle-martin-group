﻿namespace SSE3
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.Retrive = new System.Windows.Forms.Button();
            this.TwitterUrl = new System.Windows.Forms.TextBox();
            this.searchTweets = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.Sort = new System.Windows.Forms.Button();
            this.ClearTweet = new System.Windows.Forms.Button();
            this.Crawl = new System.Windows.Forms.Button();
            this.sortTweets = new System.Windows.Forms.RichTextBox();
            this.incomingTweets = new System.Windows.Forms.RichTextBox();
            this.feedback = new System.Windows.Forms.RichTextBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.ClearSort = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Retrive
            // 
            this.Retrive.Location = new System.Drawing.Point(386, 12);
            this.Retrive.Name = "Retrive";
            this.Retrive.Size = new System.Drawing.Size(104, 23);
            this.Retrive.TabIndex = 0;
            this.Retrive.Text = "Retrive Tweets";
            this.Retrive.UseVisualStyleBackColor = true;
            this.Retrive.Click += new System.EventHandler(this.Retrive_Click);
            // 
            // TwitterUrl
            // 
            this.TwitterUrl.Location = new System.Drawing.Point(77, 37);
            this.TwitterUrl.Name = "TwitterUrl";
            this.TwitterUrl.Size = new System.Drawing.Size(413, 20);
            this.TwitterUrl.TabIndex = 1;
            this.TwitterUrl.Text = "http://twitter.com/CNNbrk";
            // 
            // searchTweets
            // 
            this.searchTweets.Location = new System.Drawing.Point(557, 37);
            this.searchTweets.Name = "searchTweets";
            this.searchTweets.Size = new System.Drawing.Size(417, 20);
            this.searchTweets.TabIndex = 4;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(32, 40);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(45, 13);
            this.label1.TabIndex = 5;
            this.label1.Text = "Twitter :";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(522, 40);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(32, 13);
            this.label2.TabIndex = 6;
            this.label2.Text = "Sort :";
            // 
            // Sort
            // 
            this.Sort.Location = new System.Drawing.Point(899, 12);
            this.Sort.Name = "Sort";
            this.Sort.Size = new System.Drawing.Size(75, 23);
            this.Sort.TabIndex = 8;
            this.Sort.Text = "Sort";
            this.Sort.UseVisualStyleBackColor = true;
            this.Sort.Click += new System.EventHandler(this.Sort_Click);
            // 
            // ClearTweet
            // 
            this.ClearTweet.Location = new System.Drawing.Point(305, 12);
            this.ClearTweet.Name = "ClearTweet";
            this.ClearTweet.Size = new System.Drawing.Size(75, 23);
            this.ClearTweet.TabIndex = 10;
            this.ClearTweet.Text = "Clear";
            this.ClearTweet.UseVisualStyleBackColor = true;
            this.ClearTweet.Click += new System.EventHandler(this.ClearTweet_Click);
            // 
            // Crawl
            // 
            this.Crawl.Location = new System.Drawing.Point(77, 12);
            this.Crawl.Name = "Crawl";
            this.Crawl.Size = new System.Drawing.Size(113, 23);
            this.Crawl.TabIndex = 11;
            this.Crawl.Text = "Crawl Twitter";
            this.Crawl.UseVisualStyleBackColor = true;
            this.Crawl.Click += new System.EventHandler(this.Crawl_Click);
            // 
            // sortTweets
            // 
            this.sortTweets.BackColor = System.Drawing.SystemColors.Window;
            this.sortTweets.Location = new System.Drawing.Point(496, 63);
            this.sortTweets.Name = "sortTweets";
            this.sortTweets.ReadOnly = true;
            this.sortTweets.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.ForcedVertical;
            this.sortTweets.Size = new System.Drawing.Size(477, 392);
            this.sortTweets.TabIndex = 13;
            this.sortTweets.Text = "";
            // 
            // incomingTweets
            // 
            this.incomingTweets.BackColor = System.Drawing.SystemColors.Window;
            this.incomingTweets.Location = new System.Drawing.Point(12, 63);
            this.incomingTweets.Name = "incomingTweets";
            this.incomingTweets.ReadOnly = true;
            this.incomingTweets.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.ForcedVertical;
            this.incomingTweets.Size = new System.Drawing.Size(477, 303);
            this.incomingTweets.TabIndex = 14;
            this.incomingTweets.Text = "";
            // 
            // feedback
            // 
            this.feedback.BackColor = System.Drawing.SystemColors.Window;
            this.feedback.Location = new System.Drawing.Point(12, 372);
            this.feedback.Name = "feedback";
            this.feedback.ReadOnly = true;
            this.feedback.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.ForcedVertical;
            this.feedback.Size = new System.Drawing.Size(477, 83);
            this.feedback.TabIndex = 15;
            this.feedback.Text = "";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(848, 387);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.textBox1.Size = new System.Drawing.Size(95, 52);
            this.textBox1.TabIndex = 16;
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            this.timer1.Interval = 5000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // ClearSort
            // 
            this.ClearSort.Location = new System.Drawing.Point(818, 12);
            this.ClearSort.Name = "ClearSort";
            this.ClearSort.Size = new System.Drawing.Size(75, 23);
            this.ClearSort.TabIndex = 17;
            this.ClearSort.Text = "Clear";
            this.ClearSort.UseVisualStyleBackColor = true;
            this.ClearSort.Click += new System.EventHandler(this.ClearSort_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(985, 467);
            this.Controls.Add(this.ClearSort);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.feedback);
            this.Controls.Add(this.incomingTweets);
            this.Controls.Add(this.sortTweets);
            this.Controls.Add(this.Crawl);
            this.Controls.Add(this.ClearTweet);
            this.Controls.Add(this.Sort);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.searchTweets);
            this.Controls.Add(this.TwitterUrl);
            this.Controls.Add(this.Retrive);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Name = "Form1";
            this.Text = "Twitter Social Network Analysis";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button Retrive;
        private System.Windows.Forms.TextBox TwitterUrl;
        private System.Windows.Forms.TextBox searchTweets;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button Sort;
        private System.Windows.Forms.Button ClearTweet;
        private System.Windows.Forms.Button Crawl;
        private System.Windows.Forms.RichTextBox sortTweets;
        private System.Windows.Forms.RichTextBox incomingTweets;
        private System.Windows.Forms.RichTextBox feedback;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Button ClearSort;
    }
}
