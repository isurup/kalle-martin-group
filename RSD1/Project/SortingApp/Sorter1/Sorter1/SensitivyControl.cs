using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Reflection;
using System.Windows.Forms;
using SorterLib;//!!!
using StorageLib;

namespace Sorter1
{
    [Serializable]
    partial class SensitivyControl : Form
    {   
        public ArrayList data; 
       
        
        public SensitivyControl()
        {
            InitializeComponent();
            this.Text = String.Format("Sensitivy Control");
            data = new ArrayList();
        }
        public SensitivyControl(Form1 frm)
        {
            InitializeComponent();
            this.Text = String.Format("Sensitivy Control");
            data = new ArrayList();
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
            if(data!=null){
                for(int i=0;i<data.Count;i++){
                    listBox1.Items.Add(Parser.dataToStringValues(data[i]));
                }
            }
        }
        //Add values
        private void button1_Click(object sender, EventArgs e)
        {
            int fabric = (int)combFabric.SelectedIndex + (int)eAllData.Cotton;
            int wTemperature = (int)combwTemperature.SelectedIndex + (int)eAllData.Degree30;
            int weight = (int)numericWeight.Value;
            if (data == null) { MessageBox.Show("null"); return; }

            if (fabric >= 0 && wTemperature >= 0 && weight > 0)
            {
                if (Tools.existDuplicates(data, fabric, wTemperature, weight))
                {
                    if (Tools.updateData(data, fabric, wTemperature, weight)) {}
                }
                else
                {
                    Tools.saveData(data, fabric, wTemperature, weight);
                }
            }
            updateListbox();
        }        

        private void btnRemove_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex >= 0)
            {  
                listBox1.Items.RemoveAt(listBox1.SelectedIndex);               
            }
        }

        private void SensitivyControl_Load(object sender, EventArgs e)
        {           
            //uploadListbox();
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            
            Parser p = new Parser();

            if (listBox1.SelectedItem != null)            
            {                
                SensitivyData sd = (SensitivyData)p.stringToData(listBox1.SelectedItem.ToString());                
                updateControls(sd);
            }
            
        }
        private void updateControls(SensitivyData d)
        {
            combFabric.SelectedIndex = d.fabric - (int)eAllData.Cotton;
            combwTemperature.SelectedIndex = d.temperature - (int)eAllData.Degree30;
            numericWeight.Value = d.weight;
        }

        private void btnSort_Click(object sender, EventArgs e)
        {
            Tools t = new Tools();            
            t.sortDataValues_byWeight(data);
            updateListbox();
        }

        private void btnRecCoeff_Click(object sender, EventArgs e)
        {
            Tools t = new Tools();
            t.recalculateCoeffiecients(data);
            updateListbox();
        }

        //btnLoad
        private void btnLoadCfg_Click(object sender, EventArgs e)
        {
            openFileDialog1.ShowDialog();
            String fname = openFileDialog1.FileName;
            data = (ArrayList)Storage.Load(fname);           
            updateListbox();
        }
        //btnSave
        private void button3_Click(object sender, EventArgs e)
        {
            saveFileDialog1.ShowDialog();
            String fname = saveFileDialog1.FileName;
            Storage.Save(data, fname);
            updateListbox();
        }

        private void btnwAlternatives_Click(object sender, EventArgs e)
        {
            Parser p = new Parser();
            SensitivyData sd = (SensitivyData)p.stringToData(listBox1.SelectedItem.ToString());
            int index = Tools.getIndex(this.data, sd);
            

            if (((SensitivyData)data[index]).wad == null)
            {
                ((SensitivyData)data[index]).wad = new WashingAlternativesData(sd);
            }
            WashingAlternatives wa = new WashingAlternatives(ref data,index);                        
            wa.Show();
        }

        private void Open_Form_washingAlternative()
        {
            
        }
    }
}
