package ml.yompc;

public class student {
	private String bookId;
	private String bookName;
	private String ISBN;
	private String author;
	private String publisherId;
	private String pricer;
	private String total;
	private String introduction;
	
	private String totalLending;
	private String bookTypeId;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public String getPricer() {
		return pricer;
	}
	public void setPricer(String pricer) {
		this.pricer = pricer;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getTotalLending() {
		return totalLending;
	}
	public void setTotalLending(String totalLending) {
		this.totalLending = totalLending;
	}
	public String getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(String bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public student(String bookId, String bookName, String iSBN, String author, String publisherId, String pricer,
			String total, String introduction, String totalLending, String bookTypeId) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		ISBN = iSBN;
		this.author = author;
		this.publisherId = publisherId;
		this.pricer = pricer;
		this.total = total;
		this.introduction = introduction;
		this.totalLending = totalLending;
		this.bookTypeId = bookTypeId;
	}
}