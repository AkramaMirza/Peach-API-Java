public class Post {
	private String id;
	private Message[] message;
	private Integer commentCount;
	private Integer likeCount;
	private boolean likedByMe;
	private boolean isUnread;
	private Integer createdTime;
	private Integer updatedTime;
	public Post(String id, Message[] message, Integer commentCount, Integer likeCount, boolean likedByMe,
			boolean isUnread, Integer createdTime, Integer updatedTime) {
		this.id = id;
		this.message = message;
		this.commentCount = commentCount;
		this.likeCount = likeCount;
		this.likedByMe = likedByMe;
		this.isUnread = isUnread;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Message[] getMessages() {
		return message;
	}
	public void setMessages(Message[] message) {
		this.message = message;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	public boolean isLikedByMe() {
		return likedByMe;
	}
	public void setLikedByMe(boolean likedByMe) {
		this.likedByMe = likedByMe;
	}
	public boolean isUnread() {
		return isUnread;
	}
	public void setUnread(boolean isUnread) {
		this.isUnread = isUnread;
	}
	public Integer getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Integer createdTime) {
		this.createdTime = createdTime;
	}
	public Integer getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Integer updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	

}
