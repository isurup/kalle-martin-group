using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;

namespace InsiderCoding.Twitter
{
	/// <summary>
	/// Represents a list of Twitter users.
	/// </summary>
	[CollectionDataContract(Name = "users", ItemName = "user", Namespace = "")]
	public class Users : List<User>
	{
	}
}
