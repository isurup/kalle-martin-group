using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;

namespace InsiderCoding.Twitter
{
	/// <summary>
	/// Interface for communicating with twitter.com.
	/// </summary>
	[ServiceContract]
	public interface ITwitterClient
	{
		#region Status Methods

		/// <summary>
		/// Returns the 20 most recent statuses from non-protected users who have set a custom user icon.
		/// </summary>
		/// <returns>List of <see cref="Status"/> objects.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "statuses/public_timeline.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Statuses PublicTimeline();

		/// <summary>
		/// Returns the 20 most recent statuses posted by the authenticating user and that user's friends. This is the equivalent of /home on the Web.
		/// </summary>
		/// <returns>List of <see cref="Status"/> objects.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "statuses/friends_timeline.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Statuses FriendsTimeline();

		/// <summary>
		/// Returns the 20 most recent statuses posted by the authenticating user and that user's friends.
		/// Returns only statuses with an ID greater than (that is, more recent than) the specified ID.
		/// </summary>
		/// <param name="nSinceId">Last status id received.</param>
		/// <returns>List of <see cref="Status"/> objects.</returns>
		[OperationContract(Name = "FriendsTimelineSince")]
		[WebGet(UriTemplate = "statuses/friends_timeline.json?since_id={nSinceId}",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Statuses FriendsTimeline(int nSinceId);

		/// <summary>
		/// Returns the 20 most recent statuses posted from the authenticating user.
		/// </summary>
		/// <returns>List of <see cref="Status"/> objects.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "statuses/user_timeline.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Statuses UserTimeline();

		/// <summary>
		/// Returns a single status, specified by the id parameter below.  The status's author will be returned inline.
		/// </summary>
		/// <param name="sId">The numerical ID of the status you're trying to retrieve.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "statuses/show/{sId}.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Status ShowStatus(string sId); // Web service required

		/// <summary>
		/// Returns a single status, specified by the id parameter below.  The status's author will be returned inline.
		/// </summary>
		/// <param name="nId">The numerical ID of the status you're trying to retrieve.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		Status ShowStatus(int nId); // Type friendly

		/// <summary>
		/// Updates the authenticating user's status.  A status update with text identical to the 
		/// authenticating user's current status will be ignored.
		/// </summary>
		/// <param name="sStatus">The text of your status update.  Be sure to URL encode as necessary.  Should not be more than 140 characters.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		[OperationContract]
		[WebInvoke(UriTemplate = "/statuses/update.json?status={sStatus}",
			Method = "POST",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Status UpdateStatus(string sStatus);

		/// <summary>
		/// Returns the 20 most recent mentions (status containing @username) for the authenticating user.
		/// </summary>
		/// <returns>List of <see cref="Status"/> objects.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "statuses/mentions.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Statuses Mentions();

		/// <summary>
		/// Destroys the status specified by the required ID parameter.  
		/// The authenticating user must be the author of the specified status.
		/// </summary>
		/// <param name="sId">The ID of the status to destroy.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		[OperationContract]
		[WebInvoke(UriTemplate = "/statuses/destroy/{sId}.json",
			Method = "DELETE",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Status DestroyStatus(string sId); // Web service required

		/// <summary>
		/// Destroys the status specified by the required ID parameter.  
		/// The authenticating user must be the author of the specified status.
		/// </summary>
		/// <param name="nId">The ID of the status to destroy.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		Status DestroyStatus(int nId); // Type friendly

		#endregion

		#region User Methods

		/// <summary>
		/// Returns the authenticating user's friends, each with current status inline. 
		/// They are ordered by the order in which they were added as friends.
		/// </summary>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "statuses/friends.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Users Friends();

		/// <summary>
		/// Returns the friends of the specified user, each with current status inline. 
		/// They are ordered by the order in which they were added as friends.
		/// </summary>
		/// <param name="nId">Specfies the ID of the user for whom to return the list of friends.</param>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		[OperationContract(Name = "FriendsId")]
		[WebGet(UriTemplate = "statuses/friends.json?user_id={nId}",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Users Friends(int nId);

		/// <summary>
		/// Returns the friends of the specified user, each with current status inline. 
		/// They are ordered by the order in which they were added as friends.
		/// </summary>
		/// <param name="sScreenName">Specfies the screen name of the user for whom to return the list of friends.</param>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		[OperationContract(Name = "FriendsScreenName")]
		[WebGet(UriTemplate = "statuses/friends.json?screen_name={sScreenName}",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Users Friends(string sScreenName);

		/// <summary>
		/// Returns the authenticating user's followers, each with current status inline.  
		/// They are ordered by the order in which they joined Twitter (this is going to be changed). 
		/// </summary>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "statuses/followers.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Users Followers();

		/// <summary>
		/// Returns the followers of the specified user, each with current status inline.  
		/// They are ordered by the order in which they joined Twitter (this is going to be changed). 
		/// </summary>
		/// <param name="nId">Specfies the ID of the user for whom to return the list of followers.</param>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		[OperationContract(Name = "FollowersId")]
		[WebGet(UriTemplate = "statuses/followers.json?user_id={nId}",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Users Followers(int nId);

		/// <summary>
		/// Returns the followers of the specified user, each with current status inline.  
		/// They are ordered by the order in which they joined Twitter (this is going to be changed). 
		/// </summary>
		/// <param name="sScreenName">Specfies the screen name of the user for whom to return the list of followers.</param>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		[OperationContract(Name = "FollowersScreenName")]
		[WebGet(UriTemplate = "statuses/followers.json?screen_name={sScreenName}",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Users Followers(string sScreenName);

		/// <summary>
		/// Returns extended information of a given user.  
		/// This information includes design settings, so third party developers 
		/// can theme their widgets according to a given user's preferences.
		/// </summary>
		/// <param name="nId">Specfies the ID of the user to return.</param>
		/// <returns>A <see cref="User"/> object.</returns>
		[OperationContract(Name = "ShowUserId")]
		[WebGet(UriTemplate = "users/show/show.json?user_id={nId}",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		User ShowUser(int nId);

		/// <summary>
		/// Returns extended information of a given user.  
		/// This information includes design settings, so third party developers 
		/// can theme their widgets according to a given user's preferences.
		/// </summary>
		/// <param name="sScreenName">Specfies the screen name of the user to return.</param>
		/// <returns>A <see cref="User"/> object.</returns>
		[OperationContract(Name = "ShowUserScreenName")]
		[WebGet(UriTemplate = "users/show/show.json?screen_name={sScreenName}",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		User ShowUser(string sScreenName);

		#endregion

		#region Direct Message Methods

		/// <summary>
		/// Returns a list of the 20 most recent direct messages sent to the authenticating user.  
		/// Includes detailed information about the sending and recipient users.
		/// </summary>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "/direct_messages.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		DirectMessages DirectMessages();

		/// <summary>
		/// Returns a list of the 20 most recent direct messages sent to the authenticating user.  
		/// Returns only direct messages with an ID greater than (that is, more recent than) the specified ID.
		/// Includes detailed information about the sending and recipient users.
		/// </summary>
		/// <param name="nId">Id of the last message received.</param>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		[OperationContract(Name = "DirectMessagesSince)")]
		[WebGet(UriTemplate = "/direct_messages.json?since_id={nId}",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		DirectMessages DirectMessages(int nId);

		/// <summary>
		/// Returns a list of the 20 most recent direct messages sent by the authenticating user.
		/// Includes detailed information about the sending and recipient users.
		/// </summary>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "/direct_messages/sent.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		DirectMessages DirectMessagesSent();

		/// <summary>
		/// Sends a new direct message to the specified user from the authenticating user.
		/// Returns the sent message when successful.  
		/// </summary>
		/// <param name="sScreenName">The screen name of the recipient user.</param>
		/// <param name="sText">The text of your direct message.  Be sure to URL encode as necessary, and keep it under 140 characters.</param>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		[OperationContract]
		[WebInvoke(UriTemplate = "/direct_messages/new.json?user={sScreenName}&text={sText}",
			Method = "POST",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		DirectMessages NewDirectMessage(string sScreenName, string sText);

		/// <summary>
		/// Sends a new direct message to the specified user from the authenticating user.
		/// Returns the sent message when successful.  
		/// </summary>
		/// <param name="nId">The ID of the recipient user.</param>
		/// <param name="sText">The text of your direct message.  Be sure to URL encode as necessary, and keep it under 140 characters.</param>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		DirectMessages NewDirectMessage(int nId, string sText);

		/// <summary>
		/// Destroys the direct message specified.  
		/// The authenticating user must be the recipient of the specified direct message.
		/// </summary>
		/// <param name="sId">The ID of the direct message to destroy.</param>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		[OperationContract]
		[WebInvoke(UriTemplate = "/direct_messages/destroy/{sId}.json",
			Method = "DELETE",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		DirectMessages DestroyDirectMessage(string sId); // Web service friendly

		/// <summary>
		/// Destroys the direct message specified.  
		/// The authenticating user must be the recipient of the specified direct message.
		/// </summary>
		/// <param name="nId">The ID of the direct message to destroy.</param>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		DirectMessages DestroyDirectMessage(int nId); // Web service friendly

		#endregion

		#region Friendship Methods

		/// <summary>
		/// Befriends the user specified.  Returns the befriended user when successful.
		/// </summary>
		/// <param name="sScreenName">The screen name of the user to befriend</param>
		/// <param name="bFollow">Enable notifications for the target user in addition to becoming friends.</param>
		/// <returns>A <see cref="BasicUser"/> object.</returns>
		[OperationContract]
		[WebInvoke(UriTemplate = "/friendships/create/{sScreenName}.json?follow={bFollow}",
			Method = "POST",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		BasicUser CreateFriendship(string sScreenName, bool bFollow);

		/// <summary>
		/// Befriends the user specified.  Returns the befriended user when successful.
		/// </summary>
		/// <param name="nId">The ID of the user to befriend</param>
		/// <param name="bFollow">Enable notifications for the target user in addition to becoming friends.</param>
		/// <returns>A <see cref="BasicUser"/> object.</returns>
		BasicUser CreateFriendship(int nId, bool bFollow);

		/// <summary>
		/// Discontinues friendship with the specified user.
		/// Returns the un-friended user when successful.
		/// </summary>
		/// <param name="sScreenName">The screen name of the user with whom to discontinue friendship.</param>
		/// <returns>A <see cref="BasicUser"/> object.</returns>
		[OperationContract]
		[WebInvoke(UriTemplate = "/friendships/destroy/{sScreenName}.json",
			Method = "DELETE",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		BasicUser DestroyFriendship(string sScreenName);

		/// <summary>
		/// Discontinues friendship with the specified user.
		/// Returns the un-friended user when successful.
		/// </summary>
		/// <param name="nId">The ID of the user with whom to discontinue friendship.</param>
		/// <returns>A <see cref="BasicUser"/> object.</returns>
		BasicUser DestroyFriendship(int nId);

		/// <summary>
		/// Tests for the existance of friendship between two users. Will return true if user A follows user B, otherwise will return false.
		/// </summary>
		/// <param name="sScreenNameA">The screen name of the first user to test friendship for</param>
		/// <param name="sScreenNameB">The screen name of the second user to test friendship for</param>
		/// <returns><see cref="bool"/> value.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "/friendships/exists/exists.json?user_a={sScreenNameA}&user_b={sScreenNameB}",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		bool FriendshipsExists(string sScreenNameA, string sScreenNameB);

		/// <summary>
		/// Tests for the existance of friendship between two users. Will return true if user A follows user B, otherwise will return false.
		/// </summary>
		/// <param name="nIdA">The ID of the first user to test friendship for</param>
		/// <param name="nIdB">The ID of the second user to test friendship for</param>
		/// <returns><see cref="bool"/> value.</returns>
		bool FriendshipsExists(int nIdA, int nIdB);

		#endregion

		#region Account Methods

		/// <summary>
		/// Returns a representation of the requesting user if authentication was successful
		/// Use this method to test if supplied user credentials are valid.
		/// </summary>
		/// <returns>A <see cref="User"/> object.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "/account/verify_credentials.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		User VerifyCredentials();

		#endregion

		#region Favourite Methods

		/// <summary>
		/// Returns the 20 most recent favorite statuses for the authenticating user. 
		/// </summary>
		/// <returns>A list of <see cref="Status"/> objects.</returns>
		[OperationContract]
		[WebGet(UriTemplate = "/favorites.json",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Statuses Favourites();

		/// <summary>
		/// Favorites the status specified as the authenticating user.  Returns the favorite status when successful.
		/// </summary>
		/// <param name="sId">The ID of the status to favorite.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		[OperationContract]
		[WebInvoke(UriTemplate = "/favorites/create/{sId}.json",
			Method = "POST",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Status CreateFavourite(string sId); // Web service friendly

		/// <summary>
		/// Favorites the status specified as the authenticating user.
		/// Returns the favorite status when successful.
		/// </summary>
		/// <param name="nId">The ID of the status to favorite.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		Status CreateFavourite(int nId); // Type friendly

		/// <summary>
		/// Un-favorites the status specified as the authenticating user.  
		/// Returns the un-favorited status when successful.  
		/// </summary>
		/// <param name="sId">The ID of the status to un-favorite.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		[OperationContract]
		[WebInvoke(UriTemplate = "/favorites/destroy/{sId}.json",
			Method = "DELETE",
			BodyStyle = WebMessageBodyStyle.Bare,
			RequestFormat = WebMessageFormat.Json,
			ResponseFormat = WebMessageFormat.Json)]
		Status DestroyFavourite(string sId); // Web service friendly

		/// <summary>
		/// Un-favorites the status specified as the authenticating user.  
		/// Returns the un-favorited status when successful.  
		/// </summary>
		/// <param name="nId">The ID of the status to un-favorite.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		Status DestroyFavourite(int nId); // Type friendly

		#endregion
	}
}
