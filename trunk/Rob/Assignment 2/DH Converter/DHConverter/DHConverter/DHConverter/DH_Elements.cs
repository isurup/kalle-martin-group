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
            this.j[this.jId+1] = new Joint();
        }
    }
    public class Joint
    {        
        public string joint;
        public string id;
        public string a;
        public string alpha;
        public string d;
        public string theta;

        public Joint()
        {
            joint = "nil";
            id = "nil";
            a = "0";
            alpha = "0";
            d = "0";
            theta = "0";
        }
    }        
}
