namespace TrixiTweet_GUI
{
    partial class TrixiTweet_GUI
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(TrixiTweet_GUI));
            this.button1 = new System.Windows.Forms.Button();
            this.m_accessCode = new System.Windows.Forms.TextBox();
            this.m_button = new System.Windows.Forms.Button();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.FriendsTimeline = new System.Windows.Forms.FlowLayoutPanel();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.RepliesTimeline = new System.Windows.Forms.FlowLayoutPanel();
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.DirectMessagesTimeline = new System.Windows.Forms.FlowLayoutPanel();
            this.tabPage4 = new System.Windows.Forms.TabPage();
            this.DirectSentTimeline = new System.Windows.Forms.FlowLayoutPanel();
            this.tabPage5 = new System.Windows.Forms.TabPage();
            this.EveryoneTimeline = new System.Windows.Forms.FlowLayoutPanel();
            this.RefreshTimelines = new System.Windows.Forms.Timer(this.components);
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.tabPage3.SuspendLayout();
            this.tabPage4.SuspendLayout();
            this.tabPage5.SuspendLayout();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Image = ((System.Drawing.Image)(resources.GetObject("button1.Image")));
            this.button1.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.button1.Location = new System.Drawing.Point(511, 10);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(21, 22);
            this.button1.TabIndex = 1;
            this.button1.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText;
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.close_Click);
            // 
            // m_accessCode
            // 
            this.m_accessCode.Location = new System.Drawing.Point(74, 12);
            this.m_accessCode.Name = "m_accessCode";
            this.m_accessCode.Size = new System.Drawing.Size(100, 20);
            this.m_accessCode.TabIndex = 1;
            // 
            // m_button
            // 
            this.m_button.Location = new System.Drawing.Point(180, 12);
            this.m_button.Name = "m_button";
            this.m_button.Size = new System.Drawing.Size(75, 23);
            this.m_button.TabIndex = 0;
            this.m_button.Text = "Done";
            this.m_button.UseVisualStyleBackColor = true;
            this.m_button.Click += new System.EventHandler(this.m_button_Click);
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Controls.Add(this.tabPage3);
            this.tabControl1.Controls.Add(this.tabPage4);
            this.tabControl1.Controls.Add(this.tabPage5);
            this.tabControl1.Location = new System.Drawing.Point(12, 12);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(493, 426);
            this.tabControl1.TabIndex = 0;
            this.tabControl1.MouseWheel += new System.Windows.Forms.MouseEventHandler(this.flowLayoutPanel1_MouseWheel);
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.FriendsTimeline);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(485, 400);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Friend\'s Statuses";
            this.tabPage1.UseVisualStyleBackColor = true;
            this.tabPage1.MouseWheel += new System.Windows.Forms.MouseEventHandler(this.flowLayoutPanel1_MouseWheel);
            // 
            // FriendsTimeline
            // 
            this.FriendsTimeline.AutoScroll = true;
            this.FriendsTimeline.Location = new System.Drawing.Point(7, 7);
            this.FriendsTimeline.Name = "FriendsTimeline";
            this.FriendsTimeline.Size = new System.Drawing.Size(472, 387);
            this.FriendsTimeline.TabIndex = 0;
            this.FriendsTimeline.MouseWheel += new System.Windows.Forms.MouseEventHandler(this.flowLayoutPanel1_MouseWheel);
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.RepliesTimeline);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(485, 400);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Replies";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // RepliesTimeline
            // 
            this.RepliesTimeline.AutoScroll = true;
            this.RepliesTimeline.Location = new System.Drawing.Point(7, 7);
            this.RepliesTimeline.Name = "RepliesTimeline";
            this.RepliesTimeline.Size = new System.Drawing.Size(472, 390);
            this.RepliesTimeline.TabIndex = 0;
            // 
            // tabPage3
            // 
            this.tabPage3.Controls.Add(this.DirectMessagesTimeline);
            this.tabPage3.Location = new System.Drawing.Point(4, 22);
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.Size = new System.Drawing.Size(485, 400);
            this.tabPage3.TabIndex = 2;
            this.tabPage3.Text = "Direct Messages";
            this.tabPage3.UseVisualStyleBackColor = true;
            // 
            // DirectMessagesTimeline
            // 
            this.DirectMessagesTimeline.AutoScroll = true;
            this.DirectMessagesTimeline.Location = new System.Drawing.Point(7, 5);
            this.DirectMessagesTimeline.Name = "DirectMessagesTimeline";
            this.DirectMessagesTimeline.Size = new System.Drawing.Size(475, 390);
            this.DirectMessagesTimeline.TabIndex = 1;
            // 
            // tabPage4
            // 
            this.tabPage4.Controls.Add(this.DirectSentTimeline);
            this.tabPage4.Location = new System.Drawing.Point(4, 22);
            this.tabPage4.Name = "tabPage4";
            this.tabPage4.Size = new System.Drawing.Size(485, 400);
            this.tabPage4.TabIndex = 3;
            this.tabPage4.Text = "Direct Sent";
            this.tabPage4.UseVisualStyleBackColor = true;
            // 
            // DirectSentTimeline
            // 
            this.DirectSentTimeline.AutoScroll = true;
            this.DirectSentTimeline.Location = new System.Drawing.Point(7, 5);
            this.DirectSentTimeline.Name = "DirectSentTimeline";
            this.DirectSentTimeline.Size = new System.Drawing.Size(475, 390);
            this.DirectSentTimeline.TabIndex = 1;
            // 
            // tabPage5
            // 
            this.tabPage5.Controls.Add(this.EveryoneTimeline);
            this.tabPage5.Location = new System.Drawing.Point(4, 22);
            this.tabPage5.Name = "tabPage5";
            this.tabPage5.Size = new System.Drawing.Size(485, 400);
            this.tabPage5.TabIndex = 4;
            this.tabPage5.Text = "Everyone\'s Statuses";
            this.tabPage5.UseVisualStyleBackColor = true;
            // 
            // EveryoneTimeline
            // 
            this.EveryoneTimeline.AutoScroll = true;
            this.EveryoneTimeline.Location = new System.Drawing.Point(7, 5);
            this.EveryoneTimeline.Name = "EveryoneTimeline";
            this.EveryoneTimeline.Size = new System.Drawing.Size(475, 390);
            this.EveryoneTimeline.TabIndex = 1;
            // 
            // RefreshTimelines
            // 
            this.RefreshTimelines.Enabled = true;
            this.RefreshTimelines.Interval = 45000;
            this.RefreshTimelines.Tick += new System.EventHandler(this.Refresh_Tick);
            // 
            // TrixiTweet_GUI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(544, 446);
            this.Controls.Add(this.tabControl1);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.m_button);
            this.Controls.Add(this.m_accessCode);
            this.Name = "TrixiTweet_GUI";
            this.Text = "TrixiTweet GUI";
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage2.ResumeLayout(false);
            this.tabPage3.ResumeLayout(false);
            this.tabPage4.ResumeLayout(false);
            this.tabPage5.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox m_accessCode;
        private System.Windows.Forms.Button m_button;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.FlowLayoutPanel FriendsTimeline;
        private System.Windows.Forms.TabPage tabPage3;
        private System.Windows.Forms.TabPage tabPage4;
        private System.Windows.Forms.TabPage tabPage5;
        private System.Windows.Forms.FlowLayoutPanel RepliesTimeline;
        private System.Windows.Forms.FlowLayoutPanel DirectMessagesTimeline;
        private System.Windows.Forms.FlowLayoutPanel DirectSentTimeline;
        private System.Windows.Forms.FlowLayoutPanel EveryoneTimeline;
        private System.Windows.Forms.Timer RefreshTimelines;
    }
}

