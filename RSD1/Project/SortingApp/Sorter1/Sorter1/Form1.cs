using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

using SorterLib;

namespace Sorter1
{
    public partial class Form1 : Form
    {
        SensitivyControl sc;
        ClothesValueControl cvc;

        public Form1()
        {
            InitializeComponent();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.sc = new SensitivyControl(this);            
            sc.Show();           
        }        
        private void button4_Click(object sender, EventArgs e)
        {
            this.cvc = new ClothesValueControl(this);
            cvc.Show();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            pictureCVC_status.Image = pictureCVC_status.ErrorImage;
            pictureSC_status.Image = pictureSC_status.ErrorImage;
        }
        private void btnSort_Click(object sender, EventArgs e)
        {   
            /*
            if (check_cvc()){
                pictureCVC_status.Image = pictureCVC_status.InitialImage;
            }
            if(check_sc()){
                pictureSC_status.Image = pictureSC_status.InitialImage;
            }
            if (check_cvc() & check_sc())
            {*/



                CreateDummyData dd = new CreateDummyData();
                object clothes = dd.createData(100);
                
           
           
                Algorithm a = new Algorithm();

                Bins bins = a.createBinIDs(clothes);

                bins = a.fillBins(clothes, bins);
           

                int total = a.getNumberOfClothes(bins);

                string str = a.ToString();
                Report r = new Report("0", str);                
                r.Show();

                /*Bin[] b = bins.getBins();
                double cnt = a.washCount(clothes,b[0]);
                Report r1= new Report("Wash count","[0] cnt: "+cnt);
                r1.Show();
                 **/
            //}
        }

        private bool check_cvc()
        {
            if(cvc == null) { return false; }
            if(cvc.data == null) { return false; }
            return true;
        }
        private bool check_sc()
        {
            if (sc == null) { return false; }
            if (sc.data == null) { return false; }
            return true;
        }
    }
}

