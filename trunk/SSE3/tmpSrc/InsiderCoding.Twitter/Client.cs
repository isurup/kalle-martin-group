using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ServiceModel;

namespace InsiderCoding.Twitter
{
	/// <summary>
	/// Implementation class for <see cref="ITwitterClient"/>.
	/// </summary>
	public class Client : ClientBase<ITwitterClient>, ITwitterClient
	{
		/// <summary>
		/// Constructs a Client object.
		/// </summary>
		/// <param name="sUsername">Username to authenticate with.</param>
		/// <param name="sPassword">Password to authenticate with.</param>
		public Client(string sUsername, string sPassword)
		{
			/*this.*/ClientCredentials.UserName.UserName = sUsername;
			/*this.*/ClientCredentials.UserName.Password = sPassword;
		}

		#region ITwitterClient Members

		/// <summary>
		/// Returns the 20 most recent statuses from non-protected users who have set a custom user icon.
		/// </summary>
		/// <returns>List of <see cref="Status"/> objects.</returns>
		public Statuses PublicTimeline()
		{
			return base.Channel.PublicTimeline();
		}

		/// <summary>
		/// Returns the 20 most recent statuses posted by the authenticating user and that user's friends. This is the equivalent of /home on the Web.
		/// </summary>
		/// <returns>List of <see cref="Status"/> objects.</returns>
		public Statuses FriendsTimeline()
		{
			return base.Channel.FriendsTimeline();
		}

		/// <summary>
		/// Returns the 20 most recent statuses posted by the authenticating user and that user's friends.
		/// Returns only statuses with an ID greater than (that is, more recent than) the specified ID.
		/// </summary>
		/// <param name="nSinceId">Last status id received.</param>
		/// <returns>List of <see cref="Status"/> objects.</returns>
		public Statuses FriendsTimeline(int nSinceId)
		{
			return base.Channel.FriendsTimeline(nSinceId);
		}

		/// <summary>
		/// Returns the 20 most recent statuses posted from the authenticating user.
		/// </summary>
		/// <returns>List of <see cref="Status"/> objects.</returns>
		public Statuses UserTimeline()
		{
			return base.Channel.UserTimeline();
		}

		/// <summary>
		/// Returns a single status, specified by the id parameter below.  The status's author will be returned inline.
		/// </summary>
		/// <param name="sId">The numerical ID of the status you're trying to retrieve.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		public Status ShowStatus(string sId)
		{
			return base.Channel.ShowStatus(sId);
		}

		/// <summary>
		/// Returns a single status, specified by the id parameter below.  The status's author will be returned inline.
		/// </summary>
		/// <param name="nId">The numerical ID of the status you're trying to retrieve.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		public Status ShowStatus(int nId)
		{
			return ShowStatus(nId.ToString());
		}

		/// <summary>
		/// Updates the authenticating user's status.  A status update with text identical to the 
		/// authenticating user's current status will be ignored.
		/// </summary>
		/// <param name="sStatus">The text of your status update.  Be sure to URL encode as necessary.  Should not be more than 140 characters.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		public Status UpdateStatus(string sStatus)
		{
			return base.Channel.UpdateStatus(sStatus);
		}

		/// <summary>
		/// Returns the 20 most recent mentions (status containing @username) for the authenticating user.
		/// </summary>
		/// <returns>List of <see cref="Status"/> objects.</returns>
		public Statuses Mentions()
		{
			return base.Channel.Mentions();
		}

		/// <summary>
		/// Destroys the status specified by the required ID parameter.  
		/// The authenticating user must be the author of the specified status.
		/// </summary>
		/// <param name="sId">The ID of the status to destroy.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		public Status DestroyStatus(string sId)
		{
			return base.Channel.DestroyStatus(sId);
		}

		/// <summary>
		/// Destroys the status specified by the required ID parameter.  
		/// The authenticating user must be the author of the specified status.
		/// </summary>
		/// <param name="nId">The ID of the status to destroy.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		public Status DestroyStatus(int nId)
		{
			return DestroyStatus(nId.ToString());
		}

		/// <summary>
		/// Returns the authenticating user's friends, each with current status inline. 
		/// They are ordered by the order in which they were added as friends.
		/// </summary>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		public Users Friends()
		{
			return base.Channel.Friends();
		}

		/// <summary>
		/// Returns the friends of the specified user, each with current status inline. 
		/// They are ordered by the order in which they were added as friends.
		/// </summary>
		/// <param name="nId">Specfies the ID of the user for whom to return the list of friends.</param>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		public Users Friends(int nId)
		{
			return base.Channel.Friends(nId);
		}

		/// <summary>
		/// Returns the friends of the specified user, each with current status inline. 
		/// They are ordered by the order in which they were added as friends.
		/// </summary>
		/// <param name="sScreenName">Specfies the screen name of the user for whom to return the list of friends.</param>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		public Users Friends(string sScreenName)
		{
			return base.Channel.Friends(sScreenName);
		}

		/// <summary>
		/// Returns the authenticating user's followers, each with current status inline.  
		/// They are ordered by the order in which they joined Twitter (this is going to be changed). 
		/// </summary>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		public Users Followers()
		{
			return base.Channel.Followers();
		}

		/// <summary>
		/// Returns the followers of the specified user, each with current status inline.  
		/// They are ordered by the order in which they joined Twitter (this is going to be changed). 
		/// </summary>
		/// <param name="nId">Specfies the ID of the user for whom to return the list of followers.</param>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		public Users Followers(int nId)
		{
			return base.Channel.Followers(nId);
		}

		/// <summary>
		/// Returns the followers of the specified user, each with current status inline.  
		/// They are ordered by the order in which they joined Twitter (this is going to be changed). 
		/// </summary>
		/// <param name="sScreenName">Specfies the screen name of the user for whom to return the list of followers.</param>
		/// <returns>A list of <see cref="User"/> objects.</returns>
		public Users Followers(string sScreenName)
		{
			return base.Channel.Followers(sScreenName);
		}

		/// <summary>
		/// Returns extended information of a given user.  
		/// This information includes design settings, so third party developers 
		/// can theme their widgets according to a given user's preferences.
		/// </summary>
		/// <param name="nId">Specfies the ID of the user to return.</param>
		/// <returns>A <see cref="User"/> object.</returns>
		public User ShowUser(int nId)
		{
			return base.Channel.ShowUser(nId);
		}

		/// <summary>
		/// Returns extended information of a given user.  
		/// This information includes design settings, so third party developers 
		/// can theme their widgets according to a given user's preferences.
		/// </summary>
		/// <param name="sScreenName">Specfies the screen name of the user to return.</param>
		/// <returns>A <see cref="User"/> object.</returns>
		public User ShowUser(string sScreenName)
		{
			return base.Channel.ShowUser(sScreenName);
		}

		/// <summary>
		/// Returns a list of the 20 most recent direct messages sent to the authenticating user.  
		/// Includes detailed information about the sending and recipient users.
		/// </summary>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		public DirectMessages DirectMessages()
		{
			return base.Channel.DirectMessages();
		}

		/// <summary>
		/// Returns a list of the 20 most recent direct messages sent to the authenticating user.  
		/// Returns only direct messages with an ID greater than (that is, more recent than) the specified ID.
		/// Includes detailed information about the sending and recipient users.
		/// </summary>
		/// <param name="nId">Id of the last message received.</param>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		public DirectMessages DirectMessages(int nId)
		{
			return base.Channel.DirectMessages(nId);
		}

		/// <summary>
		/// Returns a list of the 20 most recent direct messages sent by the authenticating user.
		/// Includes detailed information about the sending and recipient users.
		/// </summary>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		public DirectMessages DirectMessagesSent()
		{
			return base.Channel.DirectMessagesSent();
		}

		/// <summary>
		/// Sends a new direct message to the specified user from the authenticating user.
		/// Returns the sent message when successful.  
		/// </summary>
		/// <param name="sScreenName">The screen name of the recipient user.</param>
		/// <param name="sText">The text of your direct message.  Be sure to URL encode as necessary, and keep it under 140 characters.</param>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		public DirectMessages NewDirectMessage(string sScreenName, string sText)
		{
			return base.Channel.NewDirectMessage(sScreenName, sText);
		}

		/// <summary>
		/// Sends a new direct message to the specified user from the authenticating user.
		/// Returns the sent message when successful.  
		/// </summary>
		/// <param name="nId">The ID of the recipient user.</param>
		/// <param name="sText">The text of your direct message.  Be sure to URL encode as necessary, and keep it under 140 characters.</param>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		public DirectMessages NewDirectMessage(int nId, string sText)
		{
			return base.Channel.NewDirectMessage(nId.ToString(), sText);
		}

		/// <summary>
		/// Destroys the direct message specified.  
		/// The authenticating user must be the recipient of the specified direct message.
		/// </summary>
		/// <param name="sId">The ID of the direct message to destroy.</param>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		public DirectMessages DestroyDirectMessage(string sId)
		{
			return base.Channel.DestroyDirectMessage(sId);
		}

		/// <summary>
		/// Destroys the direct message specified.  
		/// The authenticating user must be the recipient of the specified direct message.
		/// </summary>
		/// <param name="nId">The ID of the direct message to destroy.</param>
		/// <returns>A list of <see cref="DirectMessage"/> objects.</returns>
		public DirectMessages DestroyDirectMessage(int nId)
		{
			return DestroyDirectMessage(nId.ToString());
		}

		/// <summary>
		/// Befriends the user specified.  Returns the befriended user when successful.
		/// </summary>
		/// <param name="sScreenName">The screen name of the user to befriend</param>
		/// <param name="bFollow">Enable notifications for the target user in addition to becoming friends.</param>
		/// <returns>A <see cref="BasicUser"/> object.</returns>
		public BasicUser CreateFriendship(string sScreenName, bool bFollow)
		{
			return base.Channel.CreateFriendship(sScreenName, bFollow);
		}

		/// <summary>
		/// Befriends the user specified.  Returns the befriended user when successful.
		/// </summary>
		/// <param name="nId">The ID of the user to befriend</param>
		/// <param name="bFollow">Enable notifications for the target user in addition to becoming friends.</param>
		/// <returns>A <see cref="BasicUser"/> object.</returns>
		public BasicUser CreateFriendship(int nId, bool bFollow)
		{
			return CreateFriendship(nId.ToString(), bFollow);
		}

		/// <summary>
		/// Discontinues friendship with the specified user.
		/// Returns the un-friended user when successful.
		/// </summary>
		/// <param name="sScreenName">The screen name of the user with whom to discontinue friendship.</param>
		/// <returns>A <see cref="BasicUser"/> object.</returns>
		public BasicUser DestroyFriendship(string sScreenName)
		{
			return base.Channel.DestroyFriendship(sScreenName);
		}

		/// <summary>
		/// Discontinues friendship with the specified user.
		/// Returns the un-friended user when successful.
		/// </summary>
		/// <param name="nId">The ID of the user with whom to discontinue friendship.</param>
		/// <returns>A <see cref="BasicUser"/> object.</returns>
		public BasicUser DestroyFriendship(int nId)
		{
			return DestroyFriendship(nId.ToString());
		}

		/// <summary>
		/// Tests for the existance of friendship between two users. Will return true if user A follows user B, otherwise will return false.
		/// </summary>
		/// <param name="sScreenNameA">The screen name of the first user to test friendship for</param>
		/// <param name="sScreenNameB">The screen name of the second user to test friendship for</param>
		/// <returns><see cref="bool"/> value.</returns>
		public bool FriendshipsExists(string sScreenNameA, string sScreenNameB)
		{
			return base.Channel.FriendshipsExists(sScreenNameA, sScreenNameB);
		}

		/// <summary>
		/// Tests for the existance of friendship between two users. Will return true if user A follows user B, otherwise will return false.
		/// </summary>
		/// <param name="nIdA">The ID of the first user to test friendship for</param>
		/// <param name="nIdB">The ID of the second user to test friendship for</param>
		/// <returns><see cref="bool"/> value.</returns>
		public bool FriendshipsExists(int nIdA, int nIdB)
		{
			return FriendshipsExists(nIdA.ToString(), nIdB.ToString());
		}

		/// <summary>
		/// Returns a representation of the requesting user if authentication was successful
		/// Use this method to test if supplied user credentials are valid.
		/// </summary>
		/// <returns>A <see cref="User"/> object.</returns>
		public User VerifyCredentials()
		{
			return base.Channel.VerifyCredentials();
		}

		/// <summary>
		/// Returns the 20 most recent favorite statuses for the authenticating user. 
		/// </summary>
		/// <returns>A list of <see cref="Status"/> objects.</returns>
		public Statuses Favourites()
		{
			return base.Channel.Favourites();
		}

		/// <summary>
		/// Favorites the status specified as the authenticating user.  Returns the favorite status when successful.
		/// </summary>
		/// <param name="sId">The ID of the status to favorite.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		public Status CreateFavourite(string sId)
		{
			return base.Channel.CreateFavourite(sId);
		}

		/// <summary>
		/// Favorites the status specified as the authenticating user.
		/// Returns the favorite status when successful.
		/// </summary>
		/// <param name="nId">The ID of the status to favorite.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		public Status CreateFavourite(int nId)
		{
			return CreateFavourite(nId.ToString());
		}

		/// <summary>
		/// Un-favorites the status specified as the authenticating user.  
		/// Returns the un-favorited status when successful.  
		/// </summary>
		/// <param name="sId">The ID of the status to un-favorite.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		public Status DestroyFavourite(string sId)
		{
			return base.Channel.DestroyFavourite(sId);
		}

		/// <summary>
		/// Un-favorites the status specified as the authenticating user.  
		/// Returns the un-favorited status when successful.  
		/// </summary>
		/// <param name="nId">The ID of the status to un-favorite.</param>
		/// <returns>A <see cref="Status"/> object.</returns>
		public Status DestroyFavourite(int nId)
		{
			return DestroyFavourite(nId.ToString());
		}

		#endregion
	}
}
