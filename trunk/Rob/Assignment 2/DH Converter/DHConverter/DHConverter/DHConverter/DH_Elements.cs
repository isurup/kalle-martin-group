using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DHConverter
{
    public class Template
    {
        public string DOH;
        public string Comment;        
        //---------------------               
        public Joint[] j = new Joint[10];//!!
        public int jId = 0;
        //---------------------               

        public Template()
        {
            this.j[0] = new Joint();
        }

        public void AddJoint(Joint j)
        {
            this.jId++;
            this.j[this.jId] = j;
            System.Windows.Forms.MessageBox.Show("added: " + j.alpha);
            this.j[this.jId+1] = new Joint();
        }
    }
    public class Joint
    {        
        public string joint;
        public string type;
        public string a;
        public string alpha;
        public string d;
        public string theta;

        public Joint()
        {
            joint = "0";
            type = "nil";
            a = "0";
            alpha = "0";
            d = "0";
            theta = "0";
        }
    }        
}
