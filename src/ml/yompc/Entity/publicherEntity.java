package ml.yompc.Entity;

public class publicherEntity {
	private String publisherId;
	private String publisher;
	public publicherEntity(String publisherId, String publisher) {
		super();
		this.publisherId = publisherId;
		this.publisher = publisher;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
