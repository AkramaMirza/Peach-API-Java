import java.util.List;

public interface PeachCallback {
	
	default public void tokenDone(String token, boolean success) {}
	
	default public void connectionsDone(List<Connection> connections, boolean success) {}
	default public void inboundFriendRequestsDone(List<FriendRequest> inboundFriendRequests, boolean success) {}
	default public void outboundFriendRequestsDone(List<FriendRequest> outboundFriendRequests, boolean success) {}
	default public void requesterStreamDone(Stream stream, boolean success) {}
	
}
