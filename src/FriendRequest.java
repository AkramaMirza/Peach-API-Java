
public class FriendRequest {
	private Stream stream;
	private String id;
	private Integer createdTime;
	public FriendRequest(Stream stream, String id, Integer createdTime) {
		super();
		this.stream = stream;
		this.id = id;
		this.createdTime = createdTime;
	}
	public Stream getStream() {
		return stream;
	}
	public void setStream(Stream stream) {
		this.stream = stream;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Integer createdTime) {
		this.createdTime = createdTime;
	}
	
}
