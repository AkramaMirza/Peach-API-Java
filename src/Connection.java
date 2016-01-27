
public class Connection extends Stream {
	private boolean followsYou;
	private boolean youFollow;
	public Connection(String id, String name, String displayName, String bio, boolean isPublic, Post[] posts,
			Integer unreadPostCount, Integer lastRead, Integer lastOnline, boolean followsYou, boolean youFollow, String avatarSrc) {
		super(id, name, displayName, bio, isPublic, posts, unreadPostCount, lastRead, lastOnline, avatarSrc);
		this.followsYou = followsYou;
		this.youFollow = youFollow;
	}
	public boolean isFollowsYou() {
		return followsYou;
	}
	public void setFollowsYou(boolean followsYou) {
		this.followsYou = followsYou;
	}
	public boolean isYouFollow() {
		return youFollow;
	}
	public void setYouFollow(boolean youFollow) {
		this.youFollow = youFollow;
	}
	

}
