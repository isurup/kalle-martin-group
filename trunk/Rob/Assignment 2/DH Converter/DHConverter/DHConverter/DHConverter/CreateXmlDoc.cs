using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using System.Globalization;

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

            XmlCreateFrame(xmlDoc, xmlSerialDevice);
            for (int joint = 1; joint <= template.jId; joint++)
            {
                //System.Windows.Forms.MessageBox.Show("joint: " + joint.ToString());
                //System.Windows.Forms.MessageBox.Show("test: " + template.j[joint].joint.ToString());
                XmlCreateJoint(xmlDoc, xmlSerialDevice, template, joint);
            }
            //-------------------------------------------------------------------------
            //-------------------------------------------------------------------------

            xmlDoc.Save(filename);
            //-------------------------------------------------------------------------
            //End Template
            //-------------------------------------------------------------------------
        }

        public void XmlCreateFrame(XmlDocument xmlDoc, XmlElement root)
        {
            XmlElement Frame, Drawable, RPY, Cylinder, Pos;
            XmlText xmlText;

            // <Frame name="Base">
            Frame = xmlDoc.CreateElement("", "Frame", "");
            Frame.SetAttribute("name", "Base");
            root.AppendChild(Frame);

            //<Drawable name="A box" >
            Drawable = xmlDoc.CreateElement("", "Drawable", "");
            Drawable.SetAttribute("name", "A box");
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
            //</Frame>          
        }

        public void XmlCreateJoint(XmlDocument xmlDoc, XmlElement root, Template template, int id)
        {
            XmlElement xmlDHJoint, Drawable, PosLimit, Cylinder, RPY, Box, Pos;
            XmlText xmlText;
            Joint prevjoint = template.j[id - 1];
            Joint joint = template.j[id];
            Joint nextjoint = template.j[id + 1];
            //System.Windows.Forms.MessageBox.Show("prev: " + prevjoint.joint);
            //System.Windows.Forms.MessageBox.Show("joint: " + joint.joint);
            //System.Windows.Forms.MessageBox.Show("next: " + nextjoint.joint);
            xmlDHJoint = xmlDoc.CreateElement("", "DHJoint", "");
            

            //name="Joint1" alpha="0" a="0" d="0.2" offset="0"
            xmlDHJoint.SetAttribute("name", "", "joint" + joint.joint);//xmlDHJoint.SetAttribute("name", "", "Joint1");
            xmlDHJoint.SetAttribute("alpha", "", prevjoint.alpha);//xmlDHJoint.SetAttribute("alpha", "", "0");
            
            if (String.Compare(joint.type, "prismatic", true) == 0)
            {
                xmlDHJoint.SetAttribute("a", "", "0");
                xmlDHJoint.SetAttribute("theta", "", "0");
                xmlDHJoint.SetAttribute("offset", "", "0.6");
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
            if (String.Compare(joint.type, "prismatic", true) == 0)
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
            float floata;
            float.TryParse(joint.a, NumberStyles.Any, CultureInfo.InvariantCulture, out floata);
            if (String.Compare(nextjoint.type, "prismatic", true) == 0)
            {
                rpy = "90 0 0";
                pos = "0 -";
                pos += (floata / 2).ToString(CultureInfo.InvariantCulture);
                pos += " 0";
            }
            else
            {
                rpy = "0 0 0";
                pos = "";
                pos += (floata / 2).ToString(CultureInfo.InvariantCulture);
                pos += " 0 0";
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
            Box.SetAttribute("x", joint.a);
            Box.SetAttribute("y", "0.1");
            Box.SetAttribute("z", "0.1");
            Drawable.AppendChild(Box);
            //</Drawable>
        }
    }
}
