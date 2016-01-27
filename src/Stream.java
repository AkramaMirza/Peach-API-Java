public class Stream {
	private String id;
	private String name;
	private String displayName;
	private String bio;
	private boolean isPublic;
	private Post[] posts;
	private Integer unreadPostCount;
	private Integer lastRead;
	private Integer lastOnline;
	private String avatarSrc;
	public Stream(String id, String name, String displayName, String bio, boolean isPublic, Post[] posts,
			Integer unreadPostCount, Integer lastRead, Integer lastOnline, String avatarSrc) {
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		this.bio = bio;
		this.isPublic = isPublic;
		this.posts = posts;
		this.unreadPostCount = unreadPostCount;
		this.lastRead = lastRead;
		this.lastOnline = lastOnline;
		this.avatarSrc = avatarSrc;
	}
	
	public String getAvatarSrc() {
		return avatarSrc;
	}

	public void setAvatarSrc(String avatarSrc) {
		this.avatarSrc = avatarSrc;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public Post[] getPosts() {
		return posts;
	}
	public void setPosts(Post[] posts) {
		this.posts = posts;
	}
	public Integer getUnreadPostCount() {
		return unreadPostCount;
	}
	public void setUnreadPostCount(Integer unreadPostCount) {
		this.unreadPostCount = unreadPostCount;
	}
	public Integer getLastRead() {
		return lastRead;
	}
	public void setLastRead(Integer lastRead) {
		this.lastRead = lastRead;
	}
	public Integer getLastOnline() {
		return lastOnline;
	}
	public void setLastOnline(Integer lastOnline) {
		this.lastOnline = lastOnline;
	}
	
}
