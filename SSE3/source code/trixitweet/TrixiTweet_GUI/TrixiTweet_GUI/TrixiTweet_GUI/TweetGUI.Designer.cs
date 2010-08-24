namespace TrixiTweet_GUI
{
    partial class TweetGUI
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

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.m_UserName = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.SourceLabel = new System.Windows.Forms.LinkLabel();
            this.SourceLabelNoLink = new System.Windows.Forms.Label();
            this.NickLabel = new System.Windows.Forms.Label();
            this.tweetText = new System.Windows.Forms.RichTextBox();
            this.timeLabel = new System.Windows.Forms.LinkLabel();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.ReplyToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.retweetToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.deleteToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.directMessageToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.followToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.SendButton = new System.Windows.Forms.Button();
            this.InreplyLink = new System.Windows.Forms.LinkLabel();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.contextMenuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // m_UserName
            // 
            this.m_UserName.AutoSize = true;
            this.m_UserName.Location = new System.Drawing.Point(95, 64);
            this.m_UserName.Name = "m_UserName";
            this.m_UserName.Size = new System.Drawing.Size(35, 13);
            this.m_UserName.TabIndex = 0;
            this.m_UserName.Text = "label1";
            this.m_UserName.MouseClick += new System.Windows.Forms.MouseEventHandler(this.TweetGUI_MouseClick);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Location = new System.Drawing.Point(3, 4);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(77, 50);
            this.pictureBox1.TabIndex = 1;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.MouseClick += new System.Windows.Forms.MouseEventHandler(this.TweetGUI_MouseClick);
            // 
            // SourceLabel
            // 
            this.SourceLabel.AutoSize = true;
            this.SourceLabel.LinkArea = new System.Windows.Forms.LinkArea(4, 30);
            this.SourceLabel.Location = new System.Drawing.Point(345, 66);
            this.SourceLabel.Name = "SourceLabel";
            this.SourceLabel.Size = new System.Drawing.Size(55, 17);
            this.SourceLabel.TabIndex = 2;
            this.SourceLabel.TabStop = true;
            this.SourceLabel.Text = "linkLabel1";
            this.SourceLabel.UseCompatibleTextRendering = true;
            this.SourceLabel.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.SourceLabel_LinkClicked);
            this.SourceLabel.MouseClick += new System.Windows.Forms.MouseEventHandler(this.TweetGUI_MouseClick);
            // 
            // SourceLabelNoLink
            // 
            this.SourceLabelNoLink.AutoSize = true;
            this.SourceLabelNoLink.Location = new System.Drawing.Point(355, 65);
            this.SourceLabelNoLink.Name = "SourceLabelNoLink";
            this.SourceLabelNoLink.Size = new System.Drawing.Size(35, 13);
            this.SourceLabelNoLink.TabIndex = 0;
            this.SourceLabelNoLink.Text = "label1";
            this.SourceLabelNoLink.MouseClick += new System.Windows.Forms.MouseEventHandler(this.TweetGUI_MouseClick);
            // 
            // NickLabel
            // 
            this.NickLabel.AutoSize = true;
            this.NickLabel.Location = new System.Drawing.Point(3, 57);
            this.NickLabel.Name = "NickLabel";
            this.NickLabel.Size = new System.Drawing.Size(35, 13);
            this.NickLabel.TabIndex = 0;
            this.NickLabel.Text = "label1";
            this.NickLabel.MouseClick += new System.Windows.Forms.MouseEventHandler(this.TweetGUI_MouseClick);
            // 
            // tweetText
            // 
            this.tweetText.BackColor = System.Drawing.SystemColors.ButtonFace;
            this.tweetText.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.tweetText.Location = new System.Drawing.Point(86, 3);
            this.tweetText.Name = "tweetText";
            this.tweetText.ReadOnly = true;
            this.tweetText.Size = new System.Drawing.Size(344, 57);
            this.tweetText.TabIndex = 3;
            this.tweetText.Text = "";
            this.tweetText.LinkClicked += new System.Windows.Forms.LinkClickedEventHandler(this.tweetText_LinkClicked);
            this.tweetText.MouseClick += new System.Windows.Forms.MouseEventHandler(this.TweetGUI_MouseClick);
            // 
            // timeLabel
            // 
            this.timeLabel.AutoSize = true;
            this.timeLabel.Location = new System.Drawing.Point(265, 66);
            this.timeLabel.Name = "timeLabel";
            this.timeLabel.Size = new System.Drawing.Size(55, 13);
            this.timeLabel.TabIndex = 4;
            this.timeLabel.TabStop = true;
            this.timeLabel.Text = "linkLabel1";
            this.timeLabel.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.timeLabel_LinkClicked);
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.ReplyToolStripMenuItem1,
            this.retweetToolStripMenuItem,
            this.deleteToolStripMenuItem,
            this.directMessageToolStripMenuItem,
            this.followToolStripMenuItem});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(159, 136);
            // 
            // ReplyToolStripMenuItem1
            // 
            this.ReplyToolStripMenuItem1.Name = "ReplyToolStripMenuItem1";
            this.ReplyToolStripMenuItem1.Size = new System.Drawing.Size(158, 22);
            this.ReplyToolStripMenuItem1.Text = "Reply";
            this.ReplyToolStripMenuItem1.Click += new System.EventHandler(this.ReplyToolStripMenuItem1_Click);
            // 
            // retweetToolStripMenuItem
            // 
            this.retweetToolStripMenuItem.Name = "retweetToolStripMenuItem";
            this.retweetToolStripMenuItem.Size = new System.Drawing.Size(158, 22);
            this.retweetToolStripMenuItem.Text = "Retweet";
            this.retweetToolStripMenuItem.Click += new System.EventHandler(this.retweetToolStripMenuItem_Click);
            // 
            // deleteToolStripMenuItem
            // 
            this.deleteToolStripMenuItem.Name = "deleteToolStripMenuItem";
            this.deleteToolStripMenuItem.Size = new System.Drawing.Size(158, 22);
            this.deleteToolStripMenuItem.Text = "Delete";
            this.deleteToolStripMenuItem.Click += new System.EventHandler(this.deleteToolStripMenuItem_Click);
            // 
            // directMessageToolStripMenuItem
            // 
            this.directMessageToolStripMenuItem.Name = "directMessageToolStripMenuItem";
            this.directMessageToolStripMenuItem.Size = new System.Drawing.Size(158, 22);
            this.directMessageToolStripMenuItem.Text = "Direct Message";
            this.directMessageToolStripMenuItem.Click += new System.EventHandler(this.directMessageToolStripMenuItem_Click);
            // 
            // followToolStripMenuItem
            // 
            this.followToolStripMenuItem.Name = "followToolStripMenuItem";
            this.followToolStripMenuItem.Size = new System.Drawing.Size(158, 22);
            this.followToolStripMenuItem.Text = "Unfollow";
            this.followToolStripMenuItem.Click += new System.EventHandler(this.UnfollowToolStripMenuItem_Click);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(98, 4);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(279, 50);
            this.textBox1.TabIndex = 5;
            this.textBox1.Visible = false;
            // 
            // SendButton
            // 
            this.SendButton.Location = new System.Drawing.Point(178, 59);
            this.SendButton.Name = "SendButton";
            this.SendButton.Size = new System.Drawing.Size(75, 23);
            this.SendButton.TabIndex = 6;
            this.SendButton.Text = "Send";
            this.SendButton.UseVisualStyleBackColor = true;
            this.SendButton.Visible = false;
            this.SendButton.Click += new System.EventHandler(this.SendButton_Click);
            // 
            // InreplyLink
            // 
            this.InreplyLink.AutoSize = true;
            this.InreplyLink.Location = new System.Drawing.Point(159, 66);
            this.InreplyLink.Name = "InreplyLink";
            this.InreplyLink.Size = new System.Drawing.Size(55, 13);
            this.InreplyLink.TabIndex = 7;
            this.InreplyLink.TabStop = true;
            this.InreplyLink.Text = "linkLabel1";
            this.InreplyLink.Visible = false;
            this.InreplyLink.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.InreplyLink_LinkClicked);
            // 
            // TweetGUI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.InreplyLink);
            this.Controls.Add(this.tweetText);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.NickLabel);
            this.Controls.Add(this.SendButton);
            this.Controls.Add(this.timeLabel);
            this.Controls.Add(this.m_UserName);
            this.Controls.Add(this.SourceLabelNoLink);
            this.Controls.Add(this.SourceLabel);
            this.Name = "TweetGUI";
            this.Size = new System.Drawing.Size(441, 82);
            this.MouseClick += new System.Windows.Forms.MouseEventHandler(this.TweetGUI_MouseClick);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.contextMenuStrip1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label m_UserName;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.LinkLabel SourceLabel;
        private System.Windows.Forms.Label SourceLabelNoLink;
        private System.Windows.Forms.Label NickLabel;
        private System.Windows.Forms.RichTextBox tweetText;
        private System.Windows.Forms.LinkLabel timeLabel;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem ReplyToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem retweetToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem deleteToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem directMessageToolStripMenuItem;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Button SendButton;
        private System.Windows.Forms.ToolStripMenuItem followToolStripMenuItem;
        private System.Windows.Forms.LinkLabel InreplyLink;
    }
}
