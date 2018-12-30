package ml.yompc.Entity;

public class booktypeEntity {
	private String bookTypeId;
	private String bookType;
	public booktypeEntity(String bookTypeId, String bookType) {
		super();
		this.bookTypeId = bookTypeId;
		this.bookType = bookType;
	}
	public String getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(String bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

}
