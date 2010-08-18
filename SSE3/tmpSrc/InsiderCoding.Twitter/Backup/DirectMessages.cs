using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;

namespace InsiderCoding.Twitter
{
	/// <summary>
	/// Represents a list of Twitter direct messages.
	/// </summary>
	[CollectionDataContract(Name = "direct-messages", ItemName = "direct_message", Namespace = "")]
	public class DirectMessages : List<DirectMessage>
	{
	}
}
