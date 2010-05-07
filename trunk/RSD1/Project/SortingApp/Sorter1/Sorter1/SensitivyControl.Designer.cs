namespace Sorter1
{
    partial class SensitivyControl
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
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
            this.combFabric = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.combwTemperature = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.numericWeight = new System.Windows.Forms.NumericUpDown();
            this.btnAdd = new System.Windows.Forms.Button();
            this.btnRemove = new System.Windows.Forms.Button();
            this.listBox1 = new System.Windows.Forms.ListBox();
            this.btnSave = new System.Windows.Forms.Button();
            this.btnSort = new System.Windows.Forms.Button();
            this.btnRecCoeff = new System.Windows.Forms.Button();
            this.btnLoadCfg = new System.Windows.Forms.Button();
            this.info = new System.Windows.Forms.Label();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.saveFileDialog1 = new System.Windows.Forms.SaveFileDialog();
            this.btnwAlternatives = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.numericWeight)).BeginInit();
            this.SuspendLayout();
            // 
            // combFabric
            // 
            this.combFabric.FormatString = "N2";
            this.combFabric.FormattingEnabled = true;
            this.combFabric.Items.AddRange(new object[] {
            "Cotton",
            "Synthetic",
            "Wool"});
            this.combFabric.Location = new System.Drawing.Point(95, 25);
            this.combFabric.Name = "combFabric";
            this.combFabric.Size = new System.Drawing.Size(121, 21);
            this.combFabric.TabIndex = 201;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 28);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(39, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Fabric:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 55);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(70, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Temperature:";
            // 
            // combwTemperature
            // 
            this.combwTemperature.FormattingEnabled = true;
            this.combwTemperature.Items.AddRange(new object[] {
            "Degree30",
            "Degree40",
            "Degree60",
            "Degree95",
            "Handwash"});
            this.combwTemperature.Location = new System.Drawing.Point(95, 52);
            this.combwTemperature.Name = "combwTemperature";
            this.combwTemperature.Size = new System.Drawing.Size(121, 21);
            this.combwTemperature.TabIndex = 151;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 86);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(44, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Weight:";
            // 
            // numericWeight
            // 
            this.numericWeight.Location = new System.Drawing.Point(95, 84);
            this.numericWeight.Name = "numericWeight";
            this.numericWeight.Size = new System.Drawing.Size(120, 20);
            this.numericWeight.TabIndex = 1;
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(182, 117);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(33, 23);
            this.btnAdd.TabIndex = 5;
            this.btnAdd.Text = ">>";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.button1_Click);
            // 
            // btnRemove
            // 
            this.btnRemove.Location = new System.Drawing.Point(143, 117);
            this.btnRemove.Name = "btnRemove";
            this.btnRemove.Size = new System.Drawing.Size(33, 23);
            this.btnRemove.TabIndex = 6;
            this.btnRemove.Text = "<<";
            this.btnRemove.UseVisualStyleBackColor = true;
            this.btnRemove.Click += new System.EventHandler(this.btnRemove_Click);
            // 
            // listBox1
            // 
            this.listBox1.FormattingEnabled = true;
            this.listBox1.Location = new System.Drawing.Point(222, 12);
            this.listBox1.Name = "listBox1";
            this.listBox1.ScrollAlwaysVisible = true;
            this.listBox1.Size = new System.Drawing.Size(233, 186);
            this.listBox1.TabIndex = 7;
            this.listBox1.SelectedIndexChanged += new System.EventHandler(this.listBox1_SelectedIndexChanged);
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(15, 205);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(75, 22);
            this.btnSave.TabIndex = 8;
            this.btnSave.Text = "Save";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.button3_Click);
            // 
            // btnSort
            // 
            this.btnSort.Font = new System.Drawing.Font("Microsoft Sans Serif", 5.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(186)));
            this.btnSort.Location = new System.Drawing.Point(378, 205);
            this.btnSort.Name = "btnSort";
            this.btnSort.Size = new System.Drawing.Size(33, 21);
            this.btnSort.TabIndex = 202;
            this.btnSort.Text = "1 2 3";
            this.btnSort.UseVisualStyleBackColor = true;
            this.btnSort.Click += new System.EventHandler(this.btnSort_Click);
            // 
            // btnRecCoeff
            // 
            this.btnRecCoeff.Font = new System.Drawing.Font("Microsoft Sans Serif", 5.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(186)));
            this.btnRecCoeff.Location = new System.Drawing.Point(417, 205);
            this.btnRecCoeff.Name = "btnRecCoeff";
            this.btnRecCoeff.Size = new System.Drawing.Size(33, 20);
            this.btnRecCoeff.TabIndex = 203;
            this.btnRecCoeff.Text = "=";
            this.btnRecCoeff.UseVisualStyleBackColor = true;
            this.btnRecCoeff.Click += new System.EventHandler(this.btnRecCoeff_Click);
            // 
            // btnLoadCfg
            // 
            this.btnLoadCfg.Location = new System.Drawing.Point(141, 205);
            this.btnLoadCfg.Name = "btnLoadCfg";
            this.btnLoadCfg.Size = new System.Drawing.Size(75, 21);
            this.btnLoadCfg.TabIndex = 204;
            this.btnLoadCfg.Text = "Load";
            this.btnLoadCfg.UseVisualStyleBackColor = true;
            this.btnLoadCfg.Click += new System.EventHandler(this.btnLoadCfg_Click);
            // 
            // info
            // 
            this.info.AutoSize = true;
            this.info.Location = new System.Drawing.Point(12, 12);
            this.info.Name = "info";
            this.info.Size = new System.Drawing.Size(0, 13);
            this.info.TabIndex = 205;
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            // 
            // btnwAlternatives
            // 
            this.btnwAlternatives.Location = new System.Drawing.Point(143, 146);
            this.btnwAlternatives.Name = "btnwAlternatives";
            this.btnwAlternatives.Size = new System.Drawing.Size(72, 23);
            this.btnwAlternatives.TabIndex = 206;
            this.btnwAlternatives.Text = "Alternatives";
            this.btnwAlternatives.UseVisualStyleBackColor = true;
            this.btnwAlternatives.Click += new System.EventHandler(this.btnwAlternatives_Click);
            // 
            // SensitivyControl
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(466, 232);
            this.Controls.Add(this.btnwAlternatives);
            this.Controls.Add(this.info);
            this.Controls.Add(this.btnLoadCfg);
            this.Controls.Add(this.btnRecCoeff);
            this.Controls.Add(this.btnSort);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.listBox1);
            this.Controls.Add(this.btnRemove);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.numericWeight);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.combwTemperature);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.combFabric);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "SensitivyControl";
            this.Padding = new System.Windows.Forms.Padding(9);
            this.ShowIcon = false;
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Sensitivy Control";
            this.Load += new System.EventHandler(this.SensitivyControl_Load);
            ((System.ComponentModel.ISupportInitialize)(this.numericWeight)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox combFabric;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox combwTemperature;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.NumericUpDown numericWeight;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Button btnRemove;
        private System.Windows.Forms.ListBox listBox1;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Button btnSort;
        private System.Windows.Forms.Button btnRecCoeff;
        private System.Windows.Forms.Button btnLoadCfg;
        private System.Windows.Forms.Label info;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.SaveFileDialog saveFileDialog1;
        private System.Windows.Forms.Button btnwAlternatives;

    }
}
