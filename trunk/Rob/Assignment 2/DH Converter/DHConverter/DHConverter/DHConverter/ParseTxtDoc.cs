using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace DHConverter
{
    class ParseTxtDoc
    {
        public void ParseContent(String content, Template template)// ref Joint joint
        {
            Joint joint = null;
            content = content.Replace(" ","");//Remove empty places
            string[] lines = Regex.Split(content, "\r\n");

            int last_result=0,result = 0;
            float fvalue = 0;
            bool success = false;

            foreach (string line in lines)//scroll throw all txt
            {       
                if (isValue(line))
                {
                    Regex rule = new Regex("^(?<name>\\w+)(?<ID>\\w+)=(?<value>[a-zA-Z0-9.]+)");
                    Match match = rule.Match(line);
                    string name = match.Groups["name"].Value;
                    string value = match.Groups["value"].Value;
                    string Id = match.Groups["ID"].Value;

                    success = int.TryParse(Id, out result);
                    if (float.TryParse(value, out fvalue))
                    {
                        //value = float.Parse(
                    }

                    if (last_result != result && success)
                    {
                        last_result = result;
                        if (joint != null) {  template.AddJoint(joint); }//ADD joint
                        joint = new Joint();//Create new Joint
                    }
                        joint = TryAddJointValues(joint, name, value, Id);

                }
            }
            if (joint != null)
            {//ADD joint
                 template.AddJoint(joint); 
            }
            
    }


        public Joint TryAddJointValues(Joint joint, string name, string value, string Id)
        {
            if (joint == null || name.Length == 0) { return joint; }
                    
            switch (name)
            {
                case "joint"://joint1 = revolute
                    {
                        joint.joint = value;
                        break;
                    }

                case "a"://a1 = 1
                    {  
                        joint.a = value;
                        break;
                    }

                case "alpha"://alpha1 = 0
                    {
                        joint.alpha = value;
                        break;
                    }
                case "d"://d1 = 0.2
                    { 
                        joint.d = value;
                        break;
                    }
                case "theta"://theta1 = q1
                    {
                        joint.theta = value;
                        break;
                    }
            }
            return joint;
        }

        public bool isValue(String str)
        {
            bool value = false;            
            value |= new Regex("a[0-999]=[0-999]").IsMatch(str);//a1=12, a7=89 ...
            value |= new Regex("DOF=[0-999]").IsMatch(str);//DOF=1, DOF=83 ...
            value |= new Regex("joint[0-999]=[a-zA-Z0-999]").IsMatch(str);///joint1=revolute1, joint2=prismatic3, ...
            value |= new Regex("alpha[0-999]=[0-360]").IsMatch(str);//alpha2=90, alpha4=180
            value |= new Regex("theta[0-999]=[a-z0-360]").IsMatch(str);//theta2=q1, theta4=180 (not sure about this..)           
            value |= new Regex("d[0-999]=[a-z0-360]").IsMatch(str);//theta2=q1, theta4=180 (not sure about this..)
            //Add another rule ... 
            return value;
        } 
    }
}
