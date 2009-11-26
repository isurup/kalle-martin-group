using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using System.Globalization;
using System.Windows.Forms;

namespace DHConverter
{
    public class CreateXmlDoc
    {

        public void CreateXmlFile(String filename,Template template)
        {
            //-------------------------------------------------------------------------
            //Template
            //-------------------------------------------------------------------------
            XmlDocument xmlDoc = new XmlDocument();
            XmlElement xmlWorkCell, xmlSerialDevice;

            xmlWorkCell = xmlDoc.CreateElement("", "WorkCell", "");
            xmlWorkCell.SetAttribute("name", "scene");
            xmlDoc.AppendChild(xmlWorkCell);

            xmlSerialDevice = xmlDoc.DocumentElement;
            xmlSerialDevice = xmlDoc.CreateElement("", "SerialDevice", "");
            xmlSerialDevice.SetAttribute("name", "Simple Planar Link");
            xmlWorkCell.AppendChild(xmlSerialDevice);

            //-------------------------------------------------------------------------
            //Here Adding Joints and Frames
            //-------------------------------------------------------------------------

            XmlCreateFrame(xmlDoc, xmlSerialDevice, template);
            for (int joint = 1; joint <= template.jId; joint++)
                XmlCreateJoint(xmlDoc, xmlSerialDevice, template, joint);
            //-------------------------------------------------------------------------
            //-------------------------------------------------------------------------

            xmlDoc.Save(filename);
            //-------------------------------------------------------------------------
            //End Template
            //-------------------------------------------------------------------------
        }

        public void XmlCreateFrame(XmlDocument xmlDoc, XmlElement root, Template template)
        {
            XmlElement Frame, Drawable, RPY, Cylinder, Pos, Box;
            XmlText xmlText;
            Joint j1 = template.j[1];

            // <Frame name="Base">
            Frame = xmlDoc.CreateElement("", "Frame", "");
            Frame.SetAttribute("name", "Base");
            root.AppendChild(Frame);

            //<Drawable name="A cyl" >
            Drawable = xmlDoc.CreateElement("", "Drawable", "");
            Drawable.SetAttribute("name", "A cyl");
            Frame.AppendChild(Drawable);

            //    <RPY>0 0 0</RPY>
            RPY = xmlDoc.CreateElement("", "RPY", "");
            xmlText = xmlDoc.CreateTextNode("0 0 0");
            RPY.AppendChild(xmlText);
            Drawable.AppendChild(RPY);

            //<Pos>0.5 0 0</Pos>
            Pos = xmlDoc.CreateElement("", "Pos", "");
            xmlText = xmlDoc.CreateTextNode("0.0 0 0.1");
            Pos.AppendChild(xmlText);
            Drawable.AppendChild(Pos);


            //<Cylinder radius="0.1" z="0.12" />
            Cylinder = xmlDoc.CreateElement("", "Cylinder", "");
            Cylinder.SetAttribute("radius", "0.12");
            Cylinder.SetAttribute("z", "0.2");
            Drawable.AppendChild(Cylinder);
            //</Drawable>

            if (String.Compare(j1.joint, "nil") != 0)
            {
                double d = double.Parse(j1.d, NumberStyles.Any, CultureInfo.InvariantCulture);
                //<Drawable name="A box" >
                Drawable = xmlDoc.CreateElement("", "Drawable", "");
                Drawable.SetAttribute("name", "A box");
                Frame.AppendChild(Drawable);

                //<RPY>0 0 0</RPY>
                RPY = xmlDoc.CreateElement("", "RPY", "");
                xmlText = xmlDoc.CreateTextNode("0 90 0");
                RPY.AppendChild(xmlText);
                Drawable.AppendChild(RPY);

                //<Pos>0 0 d1/2</Pos>
                Pos = xmlDoc.CreateElement("", "Pos", "");
                xmlText = xmlDoc.CreateTextNode("0 0 " + (d / 2).ToString(CultureInfo.InvariantCulture));
                Pos.AppendChild(xmlText);
                Drawable.AppendChild(Pos);

                //<Box x="d1" y="0.1" z="0.1" />
                Box = xmlDoc.CreateElement("", "Box", "");
                Box.SetAttribute("x", d.ToString(CultureInfo.InvariantCulture));
                Box.SetAttribute("y", "0.1");
                Box.SetAttribute("z", "0.1");
                Drawable.AppendChild(Box);
            }
            //</Frame>          
        }

        public void XmlCreateJoint(XmlDocument xmlDoc, XmlElement root, Template template, int id)
        {
            XmlElement xmlDHJoint, Drawable, PosLimit, Cylinder, RPY, Box, Pos;
            XmlText xmlText;
            Joint prevjoint = template.j[id - 1];
            Joint joint = template.j[id];
            Joint nextjoint = template.j[id + 1];
            xmlDHJoint = xmlDoc.CreateElement("", "DHJoint", "");
            

            //name="Joint1" alpha="0" a="0" d="0.2" offset="0"
            xmlDHJoint.SetAttribute("name", "", joint.id);//xmlDHJoint.SetAttribute("name", "", "Joint1");
            xmlDHJoint.SetAttribute("alpha", "", prevjoint.alpha);//xmlDHJoint.SetAttribute("alpha", "", "0");
            
            if (String.Compare(joint.joint, "prismatic", true) == 0)
            {
                xmlDHJoint.SetAttribute("a", "", prevjoint.a);
                xmlDHJoint.SetAttribute("theta", "", joint.theta);
                xmlDHJoint.SetAttribute("offset", "", "0");
            }
            else
            {
                xmlDHJoint.SetAttribute("a", "", prevjoint.a);//xmlDHJoint.SetAttribute("a", "", "0");
                xmlDHJoint.SetAttribute("d", "", joint.d);//xmlDHJoint.SetAttribute("d", "", "0.2");
                xmlDHJoint.SetAttribute("offset", "", "0");
            }
            root.AppendChild(xmlDHJoint);

            //<PosLimit min="-180" max="180" />
            PosLimit = xmlDoc.CreateElement("", "PosLimit", "");
            if (String.Compare(joint.joint, "prismatic", true) == 0)
            {
                PosLimit.SetAttribute("min", "-0.4");
                PosLimit.SetAttribute("max", "0.4");
            }
            else
            {
                PosLimit.SetAttribute("min", "-180");
                PosLimit.SetAttribute("max", "180");
            }
            xmlDHJoint.AppendChild(PosLimit);

            //<Drawable name="A cyl" >
            Drawable = xmlDoc.CreateElement("", "Drawable", "");
            Drawable.SetAttribute("name", "A cyl");
            root.AppendChild(Drawable);
            
            //<Cylinder radius="0.1" z="0.12" />
            Cylinder = xmlDoc.CreateElement("", "Cylinder", "");
            Cylinder.SetAttribute("radius", "0.1");
            Cylinder.SetAttribute("z", "0.12");
            Drawable.AppendChild(Cylinder);
            xmlDHJoint.AppendChild(Drawable);
            //	</Drawable>

            //<Drawable name="A box" >
            Drawable = xmlDoc.CreateElement("", "Drawable", "");
            Drawable.SetAttribute("name", "A box");
            xmlDHJoint.AppendChild(Drawable);

            String rpy, pos;
            double floata, floatd, alpha, length, y, p, cosd, sind;
            double.TryParse(joint.a, NumberStyles.Any, CultureInfo.InvariantCulture, out floata);
            double.TryParse(nextjoint.d, NumberStyles.Any, CultureInfo.InvariantCulture, out floatd);
            double.TryParse(joint.alpha, NumberStyles.Any, CultureInfo.InvariantCulture, out alpha);
            length = Math.Sqrt(floata * floata + floatd * floatd);
            cosd = Math.Cos((90 - alpha) * Math.PI / 180) * floatd;
            sind = Math.Sin((90 - alpha) * Math.PI / 180) * floatd;

            if (floata != 0)
            {
                p = Math.Atan(sind / floata) * 180 / Math.PI * (-1);
                y = Math.Atan(cosd / floata) * 180 / Math.PI * (-1);
            }
            else
            {
                p = -90;
                y = 0;
            }

            if (String.Compare(nextjoint.joint, "prismatic", true) == 0)
            {
                //rpy = "90 0 0";
                //rpy = joint.alpha + " 0 0";
                rpy = "0 0 " + joint.alpha;
                pos = "0 0 0";
                length = 0.8;
            }
            else
            {
                rpy = y.ToString(CultureInfo.InvariantCulture) 
                      + " " + p.ToString(CultureInfo.InvariantCulture)
                      + " " + ((90-alpha) * (-1)).ToString(CultureInfo.InvariantCulture);// + 
                //      " " + p.ToString(CultureInfo.InvariantCulture) + " 0";
                        //" 0 0";
                pos = "";
                pos += (floata / 2).ToString(CultureInfo.InvariantCulture);
                pos += " " + (cosd / 2 * (-1)).ToString(CultureInfo.InvariantCulture);
                pos += " " + (sind / 2).ToString(CultureInfo.InvariantCulture);
            }

            //<RPY>0 0 0</RPY>
            RPY = xmlDoc.CreateElement("", "RPY", "");
            xmlText = xmlDoc.CreateTextNode(rpy);
            RPY.AppendChild(xmlText);
            Drawable.AppendChild(RPY);

            //<Pos>0.5 0 0</Pos>
            Pos = xmlDoc.CreateElement("", "Pos", "");
            xmlText = xmlDoc.CreateTextNode(pos);
            Pos.AppendChild(xmlText);
            Drawable.AppendChild(Pos);

            //<Box x="1.0" y="0.1" z="0.1" />
            Box = xmlDoc.CreateElement("", "Box", "");
            if (String.Compare(nextjoint.joint, "prismatic", true) == 0)
            {
                Box.SetAttribute("x", "0.1");
                Box.SetAttribute("y", "0.1");
                Box.SetAttribute("z", length.ToString(CultureInfo.InvariantCulture));
            }
            else
            {
                Box.SetAttribute("x", length.ToString(CultureInfo.InvariantCulture));
                Box.SetAttribute("y", "0.1");
                Box.SetAttribute("z", "0.1");
            }
            Drawable.AppendChild(Box);
            //</Drawable>
        }
    }
}
