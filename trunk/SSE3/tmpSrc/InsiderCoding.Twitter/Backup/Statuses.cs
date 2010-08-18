using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;

namespace InsiderCoding.Twitter
{
	/// <summary>
	/// Represents a list of Twitter statuses.
	/// </summary>
	[CollectionDataContract(Name = "statuses", ItemName = "status", Namespace = "")]
	public class Statuses : List<Status>
	{
	}
}
