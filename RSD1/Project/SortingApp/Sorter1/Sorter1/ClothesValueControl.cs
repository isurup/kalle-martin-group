using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Reflection;
using System.Windows.Forms;

using SorterLib;
using StorageLib;

namespace Sorter1
{
    partial class ClothesValueControl : Form
    {
        public ArrayList data;
        Form1 frm1;

        public ClothesValueControl()
        {
            InitializeComponent();
            this.Text = String.Format("Clothes Value Control");
            data = new ArrayList();
            createDefaultValues();
        }
        public ClothesValueControl(Form1 frm1)
        {
            InitializeComponent();
            this.frm1 = frm1;
            this.Text = String.Format("Clothes Value Control");
            data = new ArrayList();
            createDefaultValues();
        }

        #region Assembly Attribute Accessors

        public string AssemblyTitle
        {
            get
            {
                object[] attributes = Assembly.GetExecutingAssembly().GetCustomAttributes(typeof(AssemblyTitleAttribute), false);
                if (attributes.Length > 0)
                {
                    AssemblyTitleAttribute titleAttribute = (AssemblyTitleAttribute)attributes[0];
                    if (titleAttribute.Title != "")
                    {
                        return titleAttribute.Title;
                    }
                }
                return System.IO.Path.GetFileNameWithoutExtension(Assembly.GetExecutingAssembly().CodeBase);
            }
        }

        public string AssemblyVersion
        {
            get
            {
                return Assembly.GetExecutingAssembly().GetName().Version.ToString();
            }
        }

        public string AssemblyDescription
        {
            get
            {
                object[] attributes = Assembly.GetExecutingAssembly().GetCustomAttributes(typeof(AssemblyDescriptionAttribute), false);
                if (attributes.Length == 0)
                {
                    return "";
                }
                return ((AssemblyDescriptionAttribute)attributes[0]).Description;
            }
        }

        public string AssemblyProduct
        {
            get
            {
                object[] attributes = Assembly.GetExecutingAssembly().GetCustomAttributes(typeof(AssemblyProductAttribute), false);
                if (attributes.Length == 0)
                {
                    return "";
                }
                return ((AssemblyProductAttribute)attributes[0]).Product;
            }
        }

        public string AssemblyCopyright
        {
            get
            {
                object[] attributes = Assembly.GetExecutingAssembly().GetCustomAttributes(typeof(AssemblyCopyrightAttribute), false);
                if (attributes.Length == 0)
                {
                    return "";
                }
                return ((AssemblyCopyrightAttribute)attributes[0]).Copyright;
            }
        }

        public string AssemblyCompany
        {
            get
            {
                object[] attributes = Assembly.GetExecutingAssembly().GetCustomAttributes(typeof(AssemblyCompanyAttribute), false);
                if (attributes.Length == 0)
                {
                    return "";
                }
                return ((AssemblyCompanyAttribute)attributes[0]).Company;
            }
        }
        #endregion

        private void updateListbox()
        {
            listBox1.Items.Clear();
            if (data != null)
            {
                for (int i = 0; i < data.Count; i++)
                {
                    listBox1.Items.Add(Parser.dataToStringValues__(data[i]));
                }
            }
        }

        private void createDefaultValues()
        {
            if (data == null) { return; }
            for (eAllData e = eAllData.Sweater; e < eAllData.BedLinen; e++)
            {
                data.Add(new ClothesValueData((int)e, 1,1));
            }
            updateListbox();
        }
        private void ClothesValueControl_Load(object sender, EventArgs e)
        {
            string meessage = "1. Choose the clothe from the list and set how many of this types of clothe could fit into washing mashine";
            textBox1.Text = meessage;
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Parser p = new Parser();

            if (listBox1.SelectedItem != null)
            {
                ClothesValueData cvd = (ClothesValueData)p.stringToData__(listBox1.SelectedItem.ToString());
                updateControls(cvd);
            }
        }

        private void updateControls(ClothesValueData cvd)
        {
            if (cvd == null) { return; }
            numericUpDown1.Value = cvd.numberOfClothes;
            numericUpDown2.Value = cvd.mashine_total_value;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            int type = (int)listBox1.SelectedIndex + (int)eAllData.Sweater;
            int numberOfClothes = (int)numericUpDown1.Value;
            int total_value = (int)numericUpDown2.Value;

            if (data == null) { MessageBox.Show("null"); return; }


            if (!Tools.updateData(data, new ClothesValueData(type, numberOfClothes, total_value)))
            {
                MessageBox.Show("Can't update");
            }
            updateListbox();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            saveFileDialog1.ShowDialog();
            String fname = saveFileDialog1.FileName;
            Storage.Save(data, fname);
            updateListbox();
        }

        private void btnLoad_Click(object sender, EventArgs e)
        {
            openFileDialog1.ShowDialog();
            String fname = openFileDialog1.FileName;
            data = (ArrayList)Storage.Load(fname);
            updateListbox();
        }

        private void btnOK_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}