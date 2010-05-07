using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;

using System.Reflection;
using System.Windows.Forms;
using SorterLib;

namespace Sorter1
{
    partial class WashingAlternatives : Form
    {    
        ArrayList data;        
        int index;

        public WashingAlternatives()
        {
            InitializeComponent();
            this.Text = String.Format("Washing Alternative Rules");            
        }
        public WashingAlternatives(ref ArrayList data,int index)
        {                    
            InitializeComponent();
            this.Text = String.Format("Washing Alternative Rules");            
            this.data = data;            
            this.index = index;
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

        private void WashingAlternatives_Load(object sender, EventArgs e)
        {
            SensitivyData sd = ((SensitivyData)data[index]);
            textBox1.Text = (eAllData)sd.fabric + ":" + (eAllData)sd.temperature + ":" + sd.weight;
            //Tools.removeData(data, sd); //?           
            updateListbox();
            updateListBox2();
        }

        private void updateListBox2()
        {
           listBox2.Items.Clear();
           if (data == null) { return; }           
           if (((SensitivyData)data[index]).wad == null) { return; }
            WashingAlternativesData wad = ((SensitivyData)data[index]).wad;            
                for (int i = 0; i < wad.rules.Count; i++){                                        
                    listBox2.Items.Add(Parser.dataToStringValues(wad.rules[i]));                    
                }
        }
        private void updateListbox()
        {
            listBox1.Items.Clear();
            if (data != null)
            {
                for (int i = 0; i < data.Count; i++)
                {
                    listBox1.Items.Add(Parser.dataToStringValues(data[i]));
                }
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            WashingAlternativesData wad = ((SensitivyData)data[index]).wad;
            if (listBox1.SelectedIndex >= 0)
            {                
                Parser p = new Parser();
                SensitivyData sdRule = (SensitivyData)p.stringToData(listBox1.SelectedItem.ToString());                              
                wad.addRule(sdRule);
                listBox1.Items.RemoveAt(listBox1.SelectedIndex);
            }
            updateListBox2();
        }

        private void btnOk_Click(object sender, EventArgs e)
        {           
            
            this.Close();
        }
    }
}
