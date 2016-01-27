# Peach-API-Java
A library you can use to access the unofficial Peach.cool API using Java/Android.

# Features
### Register
You can create a new account on Peach by calling: 
``` java
API.register(String email, String username, String password, PeachCallback callback);
```
This will allow you to retrieve a `token` which will be used later to access the Peach API
``` java
API.register("email@example.com", "your-username", "your-password", new PeachCallback() {
  @Override
  public void tokenDone(String token, boolean success) {
    // Make sure the API request was successful
    if (success) {
      // STORE token FOR LATER USE
    }
  }
});
```
### Login
You can log in to your existing account on Peach by calling: 
``` java
API.login(String email, String password, PeachCallback callback);
```
This will allow you to retrieve a `token` which will be used later to access the Peach API
``` java
API.register("email@example.com", "your-password", new PeachCallback() {
  @Override
  public void tokenDone(String token, boolean success) {
    // Make sure the API request was successful
    if (success) {
      // STORE token FOR LATER USE
    }
  }
});
```
### Get Connections
You can get all connections (who you follow) by calling:
``` java
API.getConnections(String token, PeachCallback callback);
```
This will allow you to retrieve posts from a list of connections. 
For example this will print the first message from the first connection:
``` java 
API.getConnections("your-token", new PeachCallback() {
  @Override
  public void connectionsDone(List<Connection> connections, boolean success) {
    // Make sure the API request was successful
    if (success) {
      // Make sure you have at least 1 connection
      if (connections.size() > 0) {
        // This returns an array of posts from your first connection
        Post[] posts = connections.get(0).getPosts();
        // Make sure there is at least 1 post
        if (posts.length > 0) {
          // This returns an array of Message objects because each post can contain
          // more than 1 message. For example a post with an image and text will
          // contain 2 messages; 1 for the image and 1 for the text.
          Message[] messages = posts[0].getMessages();
          Message message = messages[0];
          if (message.getType().equals(Message.TYPE_TEXT)) {
            System.out.print(message.getText());
          }
        }
      }
    }
  }
});
```
You can also retrieve a list of incoming or outgoing friend requests by calling:
``` java 
API.getConnections(String token, PeachCallback callback);
```
and overriding 
``` java 
public void inboundFriendRequestsDone(List<FriendRequest> inboundFriendRequests, boolean success);
public void outboundFriendRequestsDone(List<FriendRequest> outboundFriendRequests, boolean success);
```
in the PeachCallback argument.

Example:
``` java
API.getConnections("your-token", new PeachCallback() {
  @Override
  public void inboundFriendRequestsDone(List<FriendRequest> inboundFriendRequests, boolean success) {
    // Make sure the API request was successful
    if (success) {
      // Make sure you have at least 1 friend request
      if (inboundFriendRequestsDone.size() > 0) {
        FriendRequest friendRequest = inboundFriendRequestsDone.get(0);
        // This id can later be used to accept or decline the friend request (upcoming feature)
        String id = friendRequest.getId();
      }
    }
  }
});
```

