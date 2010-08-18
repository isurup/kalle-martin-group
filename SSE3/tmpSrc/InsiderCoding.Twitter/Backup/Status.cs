using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;
using System.Globalization;

namespace InsiderCoding.Twitter
{
	/// <summary>
	/// Represents a Twitter status.
	/// </summary>
	[DataContract(Name = "status", Namespace = "")]
	public class Status
	{
		/// <summary>
		/// String representation of when the status was created.
		/// <seealso cref="CreatedAt"/>.
		/// </summary>
		[DataMember(Name = "created_at")]
		public string CreatedAtString { get; set; }

		/// <summary>
		/// Date and time of when the status was created.
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
		/// Id of the status.
		/// </summary>
		[DataMember(Name = "id")]
		public int Id { get; set; }

		/// <summary>
		/// Text of the status.
		/// </summary>
		[DataMember(Name = "text")]
		public string Text { get; set; }

		/// <summary>
		/// Source of the status.
		/// </summary>
		[DataMember(Name = "source")]
		public string Source { get; set; }

		/// <summary>
		/// Indicates whether the status was truncated.
		/// </summary>
		[DataMember(Name = "truncated")]
		public bool Truncated { get; set; }

		/// <summary>
		/// Indicates the id of the status this status was in reply to.
		/// </summary>
		[DataMember(Name = "in_reply_to_status_id")]
		public int? InReplyToStatusId { get; set; }

		/// <summary>
		/// Indicates the id of the user whose status this status was in reply to.
		/// </summary>
		[DataMember(Name = "in_reply_to_user_id")]
		public int? InReplyToUserId { get; set; }

		/// <summary>
		/// Indicates whether this status is favorited.
		/// </summary>
		[DataMember(Name = "favorited")]
		public bool Favourited { get; set; }

		/// <summary>
		/// Indicates the screen name of the user whose status this status was in reply to.
		/// </summary>
		[DataMember(Name = "in_reply_to_screen_name")]
		public string InReplyToScreenName { get; set; }

		/// <summary>
		/// <see cref="User"/> information for the user owning the this status.
		/// </summary>
		[DataMember(Name = "user")]
		public BasicUser User { get; set; }
	}
}
