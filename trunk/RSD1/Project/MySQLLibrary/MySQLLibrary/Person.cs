using System;
using System.Collections.Generic;
using System.Text;
//using System.Drawing;
using System.Net;
using System.IO;

namespace MySQLLibrary
{
    /// <summary>
    /// Class allow transactions with the person if connection to DB was succesfully.
    /// </summary>
    public class Person
    {
        public String CPR;        
        public Address address;
        public Name name;  
        
               
        public Person(Address address, Name name, String CPR)
        {            
            this.CPR = CPR;
            this.address = address;
            this.name = name;
        }
    }
}
