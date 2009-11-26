using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;

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
            xmlSerialDevice.SetAttribute("name", "Simple Plannar Link");
            xmlWorkCell.AppendChild(xmlSerialDevice);

            //-------------------------------------------------------------------------
            //Here Adding Joints and Frames
            //-------------------------------------------------------------------------
                    
                    
                    if (template.jId >= 1)
                    {
                        int joint = 0;
                        while (template.jId > joint)
                        {
                            XmlCreateJoint(xmlDoc, xmlSerialDevice, template.j[joint++]);
                        }
                    }
            
            XmlCreateFrame(xmlDoc, xmlSerialDevice);
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

        public void XmlCreateJoint(XmlDocument xmlDoc, XmlElement root, Joint joint)
        {
            XmlElement xmlDHJoint, Drawable, PosLimit, Cylinder, RPY, Box, Pos;
            XmlText xmlText;
            
            xmlDHJoint = xmlDoc.CreateElement("", "DHJoint", "");

            //name="Joint1" alpha="0" a="0" d="0.2" offset="0"
            xmlDHJoint.SetAttribute("name", "", joint.joint);//xmlDHJoint.SetAttribute("name", "", "Joint1");
            xmlDHJoint.SetAttribute("alpha", "", joint.alpha);//xmlDHJoint.SetAttribute("alpha", "", "0");
            xmlDHJoint.SetAttribute("a", "", joint.a);//xmlDHJoint.SetAttribute("a", "", "0");
            xmlDHJoint.SetAttribute("d", "", joint.d);//xmlDHJoint.SetAttribute("d", "", "0.2");
            xmlDHJoint.SetAttribute("offset", "", "0");
            root.AppendChild(xmlDHJoint);

            //<PosLimit min="-180" max="180" />
            PosLimit = xmlDoc.CreateElement("", "PosLimit", "");
            PosLimit.SetAttribute("min", "-180");
            PosLimit.SetAttribute("max", "180");
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

            //<RPY>0 0 0</RPY>
            RPY = xmlDoc.CreateElement("", "RPY", "");
            xmlText = xmlDoc.CreateTextNode("0 0 0");
            RPY.AppendChild(xmlText);
            Drawable.AppendChild(RPY);

            //<Pos>0.5 0 0</Pos>
            Pos = xmlDoc.CreateElement("", "Pos", "");
            xmlText = xmlDoc.CreateTextNode("0.5 0 0");
            Pos.AppendChild(xmlText);
            Drawable.AppendChild(Pos);

            //<Box x="1.0" y="0.1" z="0.1" />
            Box = xmlDoc.CreateElement("", "Box", "");
            Box.SetAttribute("x", "1.0");
            Box.SetAttribute("y", "0.1");
            Box.SetAttribute("z", "0.1");
            Drawable.AppendChild(Box);
            //</Drawable>
        }
    }
}
