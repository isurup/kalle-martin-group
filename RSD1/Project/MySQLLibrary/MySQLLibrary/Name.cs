using System;
using System.Collections.Generic;
using System.Text;

namespace MySQLLibrary
{
    public class Name
    {
        public string name;
        public string surname;
        public string middleName;

        public Name() { }
        public Name(string name, string surname)
        {
            this.name = name;
            this.surname = surname;            
        }
        public Name(string name, string surname, string middleName)
        {
            this.name = name;
            this.surname = surname;
            this.middleName = middleName;
        }
    }
}
