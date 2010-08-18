using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;

namespace InsiderCoding.Twitter
{
	/// <summary>
	/// Represents the basic information for a user.
	/// </summary>
	[DataContract(Name = "user", Namespace = "")]
	public class BasicUser
	{
		/// <summary>
		/// Id of the user.
		/// </summary>
		[DataMember(Name = "id")]
		public int Id { get; set; }

		/// <summary>
		/// Name of the user.
		/// </summary>
		[DataMember(Name = "name")]
		public string Name { get; set; }

		/// <summary>
		/// Screen name of the user.
		/// </summary>
		[DataMember(Name = "screen_name")]
		public string ScreenName { get; set; }

		/// <summary>
		/// Description of the user.
		/// </summary>
		[DataMember(Name = "description")]
		public string Description { get; set; }

		/// <summary>
		/// Location of the user.
		/// </summary>
		[DataMember(Name = "location")]
		public string Location { get; set; }

		/// <summary>
		/// String representation of the URL for the image in the user's profile.
		/// <seealso cref="ProfileImageUrl"/>.
		/// </summary>
		[DataMember(Name = "profile_image_url")]
		public string ProfileImageUrlString { get; set; }

		/// <summary>
		/// URL for the image in the user's profile.
		/// <seealso cref="ProfileImageUrlString"/>.
		/// </summary>
		public Uri ProfileImageUrl
		{
			get
			{
				if (String.IsNullOrEmpty(ProfileImageUrlString))
					return null;

				return new Uri(ProfileImageUrlString);
			}
		}

		/// <summary>
		/// String representation of the URL for the user.
		/// <seealso cref="Url"/>.
		/// </summary>
		[DataMember(Name = "url")]
		public string UrlString { get; set; }

		/// <summary>
		/// URL for the user.
		/// <seealso cref="UrlString"/>.
		/// </summary>
		public Uri Url
		{
			get
			{
				if (String.IsNullOrEmpty(UrlString))
					return null;

				return new Uri(UrlString);
			}
		}

		/// <summary>
		/// Indicates whether the user is protected.
		/// </summary>
		[DataMember(Name = "protected")]
		public bool Protected { get; set; }

		/// <summary>
		/// Indicates the number of followers for this user.
		/// </summary>
		[DataMember(Name = "followers_count")]
		public int FollowersCount { get; set; }
	}
}
