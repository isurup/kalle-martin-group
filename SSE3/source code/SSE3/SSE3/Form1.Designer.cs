namespace SSE3
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
            this.Retrive = new System.Windows.Forms.Button();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.incomingTweets = new System.Windows.Forms.ListBox();
            this.sortedTweets = new System.Windows.Forms.ListBox();
            this.searchTweets = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.Sort = new System.Windows.Forms.Button();
            this.feedback = new System.Windows.Forms.ListBox();
            this.Clear = new System.Windows.Forms.Button();
            this.Crawl = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Retrive
            // 
            this.Retrive.Location = new System.Drawing.Point(400, 12);
            this.Retrive.Name = "Retrive";
            this.Retrive.Size = new System.Drawing.Size(90, 23);
            this.Retrive.TabIndex = 0;
            this.Retrive.Text = "Retrive Tweets";
            this.Retrive.UseVisualStyleBackColor = true;
            this.Retrive.Click += new System.EventHandler(this.START_Click);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(63, 37);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(427, 20);
            this.textBox1.TabIndex = 1;
            this.textBox1.Text = "http://twitter.com/oprah";
            // 
            // incomingTweets
            // 
            this.incomingTweets.FormattingEnabled = true;
            this.incomingTweets.Location = new System.Drawing.Point(12, 63);
            this.incomingTweets.Name = "incomingTweets";
            this.incomingTweets.Size = new System.Drawing.Size(478, 303);
            this.incomingTweets.TabIndex = 2;
            // 
            // sortedTweets
            // 
            this.sortedTweets.FormattingEnabled = true;
            this.sortedTweets.Location = new System.Drawing.Point(496, 63);
            this.sortedTweets.Name = "sortedTweets";
            this.sortedTweets.Size = new System.Drawing.Size(478, 394);
            this.sortedTweets.TabIndex = 3;
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
            this.label1.Location = new System.Drawing.Point(15, 40);
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
            // 
            // feedback
            // 
            this.feedback.FormattingEnabled = true;
            this.feedback.Location = new System.Drawing.Point(12, 375);
            this.feedback.Name = "feedback";
            this.feedback.Size = new System.Drawing.Size(478, 82);
            this.feedback.TabIndex = 9;
            // 
            // Clear
            // 
            this.Clear.Location = new System.Drawing.Point(319, 12);
            this.Clear.Name = "Clear";
            this.Clear.Size = new System.Drawing.Size(75, 23);
            this.Clear.TabIndex = 10;
            this.Clear.Text = "Clear";
            this.Clear.UseVisualStyleBackColor = true;
            // 
            // Crawl
            // 
            this.Crawl.Location = new System.Drawing.Point(63, 12);
            this.Crawl.Name = "Crawl";
            this.Crawl.Size = new System.Drawing.Size(113, 23);
            this.Crawl.TabIndex = 11;
            this.Crawl.Text = "Crawl Twitter";
            this.Crawl.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(985, 467);
            this.Controls.Add(this.Crawl);
            this.Controls.Add(this.Clear);
            this.Controls.Add(this.feedback);
            this.Controls.Add(this.Sort);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.searchTweets);
            this.Controls.Add(this.sortedTweets);
            this.Controls.Add(this.incomingTweets);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.Retrive);
            this.Name = "Form1";
            this.Text = "Twitter Social Network Analysis";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button Retrive;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.ListBox incomingTweets;
        private System.Windows.Forms.ListBox sortedTweets;
        private System.Windows.Forms.TextBox searchTweets;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button Sort;
        private System.Windows.Forms.ListBox feedback;
        private System.Windows.Forms.Button Clear;
        private System.Windows.Forms.Button Crawl;
    }
}

