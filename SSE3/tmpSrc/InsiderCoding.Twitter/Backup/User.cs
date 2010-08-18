using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;
using System.Globalization;

namespace InsiderCoding.Twitter
{
	/// <summary>
	/// Represents the extended user information for a Twitter user.
	/// <seealso cref="BasicUser"/>.
	/// </summary>
	[DataContract(Name = "user", Namespace = "")]
	public class User : BasicUser
	{
		/// <summary>
		/// Background color for the user's profile.
		/// </summary>
		[DataMember(Name = "profile_background_color")]
		public string ProfileBackgroundColor { get; set; }

		/// <summary>
		/// Text color for the user's profile.
		/// </summary>
		[DataMember(Name = "profile_text_color")]
		public string ProfileTextColor { get; set; }

		/// <summary>
		/// Link color for the user's profile.
		/// </summary>
		[DataMember(Name = "profile_link_color")]
		public string ProfileLinkColor { get; set; }

		/// <summary>
		/// Fill color of the sidebar for the user's profile.
		/// </summary>
		[DataMember(Name = "profile_sidebar_fill_color")]
		public string ProfileSidebarFillColor { get; set; }

		/// <summary>
		/// Border color of the sidebar for the user's profile.
		/// </summary>
		[DataMember(Name = "profile_sidebar_border_color")]
		public string ProfileSidebarBorderColor { get; set; }

		/// <summary>
		/// Indicates the number of friends this user has.
		/// </summary>
		[DataMember(Name = "friends_count")]
		public int FriendsCount { get; set; }

		/// <summary>
		/// String representation of when the user was created.
		/// <seealso cref="CreatedAt"/>.
		/// </summary>
		[DataMember(Name = "created_at")]
		public string CreatedAtString { get; set; }

		/// <summary>
		/// Date and time when the user was created.
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
		/// Indicates the number of favorites the user has.
		/// </summary>
		[DataMember(Name = "favourites_count")]
		public int FavouritesCount { get; set; }

		/// <summary>
		/// UTC offset for the user.
		/// </summary>
		[DataMember(Name = "utc_offset")]
		public int? UtcOffset { get; set; }

		/// <summary>
		/// The timezone of the user.
		/// </summary>
		[DataMember(Name = "time_zone")]
		public string TimeZone { get; set; }

		/// <summary>
		/// String representation of the URL for the background image in the user's profile.
		/// <seealso cref="ProfileBackgroundImageUrl"/>.
		/// </summary>
		[DataMember(Name = "profile_background_image_url")]
		public string ProfileBackgroundImageUrlString { get; set; }

		/// <summary>
		/// URL for the background image in the user's profile.
		/// <seealso cref="ProfileBackgroundImageUrlString"/>.
		/// </summary>
		public Uri ProfileBackgroundImageUrl
		{
			get
			{
				if (String.IsNullOrEmpty(ProfileBackgroundImageUrlString))
					return null;

				return new Uri(ProfileBackgroundImageUrlString);
			}
		}

		/// <summary>
		/// Indicates whether the user's profile has a background title.
		/// </summary>
		[DataMember(Name = "profile_background_title")]
		public bool ProfileBackgroundTitle { get; set; }

		/// <summary>
		/// Indicates how many statuses the user has.
		/// </summary>
		[DataMember(Name = "statuses_count")]
		public int StatusesCount { get; set; }

		/// <summary>
		/// Indicates whether the user receives notifications.
		/// </summary>
		[DataMember(Name = "notifications")]
		public bool Notifications { get; set; }

		/// <summary>
		/// Indicates whether the authenticating user is following this user.
		/// </summary>
		[DataMember(Name = "following")]
		public bool Following { get; set; }

		/// <summary>
		/// Current <see cref="Status"/> of this user.
		/// </summary>
		[DataMember(Name = "status")]
		public Status Status { get; set; }
	}
}
