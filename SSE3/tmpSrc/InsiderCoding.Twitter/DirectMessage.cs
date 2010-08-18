using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;
using System.Globalization;

namespace InsiderCoding.Twitter
{
	/// <summary>
	/// Represents a direct message on Twitter.
	/// </summary>
	[DataContract(Name = "direct_message", Namespace = "")]
	public class DirectMessage
	{
		/// <summary>
		/// Id of the message.
		/// </summary>
		[DataMember(Name = "id")]
		public int Id { get; set; }

		/// <summary>
		/// Id of the sending user.
		/// </summary>
		[DataMember(Name = "sender_id")]
		public int SenderId { get; set; }

		/// <summary>
		/// Text of the message.
		/// </summary>
		[DataMember(Name = "text")]
		public string Text { get; set; }

		/// <summary>
		/// Id of the recipient user.
		/// </summary>
		[DataMember(Name = "recipient_id")]
		public int RecipientId { get; set; }

		/// <summary>
		/// String representation of the date in which the message was created.
		/// <seealso cref="CreatedAt"/>.
		/// </summary>
		[DataMember(Name = "created_at")]
		public string CreatedAtString { get; set; }

		/// <summary>
		/// The date in which the message was created.
		/// <seealso cref="CreatedAtString"/>.
		/// </summary>
		public DateTime CreatedAt
		{
			get
			{
				return DateTime.ParseExact(CreatedAtString, "ddd MMM dd HH:mm:ss zzz yyyy", CultureInfo.InvariantCulture);
			}
		}

		/// <summary>
		/// Screen name of the sending user.
		/// </summary>
		[DataMember(Name = "sender_screen_name")]
		public string SenderScreenName { get; set; }

		/// <summary>
		/// Screen name of the recipient user.
		/// </summary>
		[DataMember(Name = "recipient_screen_name")]
		public string RecipientScreenName { get; set; }

		/// <summary>
		/// Basic user information of the sending user.
		/// </summary>
		[DataMember(Name = "sender")]
		public BasicUser Sender { get; set; }

		/// <summary>
		/// Basic user information of the recipient user.
		/// </summary>
		[DataMember(Name = "recipient")]
		public BasicUser Recipient { get; set; }
	}
}
