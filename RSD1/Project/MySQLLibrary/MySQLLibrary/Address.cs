using System;
using System.Collections.Generic;
using System.Text;

namespace MySQLLibrary
{
    public class Address
    {
        public string streetName;
        public string buildingNo;
        public string roomNo;
        public string city;
        public string postCode;
        public string country;

        public Address() { }
        public Address(string streetName, string buildingNo, string roomNo, string city, string postCode, string country)
        {
            this.streetName = streetName;
            this.buildingNo = buildingNo;
            this.roomNo = roomNo;
            this.city = city;
            this.postCode = postCode;
            this.country = country;
        }
    }
}
