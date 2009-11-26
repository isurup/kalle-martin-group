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
        public int jId;
        //---------------------               
        public void AddJoint(Joint j)
        {
            this.j[this.jId++] = j;            
        }
    }
    public class Joint
    {        
        public string joint;
        public string a;
        public string alpha;
        public string d;
        public string theta;
    }        
}
