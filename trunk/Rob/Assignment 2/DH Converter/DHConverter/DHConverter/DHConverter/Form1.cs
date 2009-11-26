using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using System.Xml;

namespace DHConverter
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

       
        Template template;
        private void button1_Click(object sender, EventArgs e)
        {   
            String path = textBox1.Text;
            if (path.Length < 4) {
                MessageBox.Show("Path not entered");
                return; 
            }//!!
            path.Replace("\\","\\\\");// \->\\   
            
            try
            {
                StreamReader sr = new StreamReader(path);
                String content = sr.ReadToEnd();
                ParseTxtDoc txtParser = new ParseTxtDoc();
                template = new Template();
                txtParser.ParseContent(content, template);
                //button2.Enabled = true;
                //MessageBox.Show("Save now to XML");
                sr.Close();
            }
            catch
            {
                MessageBox.Show("Error!");
            }
            String XmlFileName = "DH_File.Xml";
            XmlFileName = textBox2.Text;
            CreateXmlDoc XmlDoc = new CreateXmlDoc();
            if (XmlFileName.Length == 0)
            {
                XmlFileName = "DH_File.Xml";
            }
            XmlDoc.CreateXmlFile(XmlFileName, template);
            MessageBox.Show("Xml file saved, file name: " + XmlFileName);
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}

