package ml.yompc.Entity;

public class lendtableEntity {
	private String lendBookId;
	private String bookId;
	private String bookName;
	private String stuName;
	private String lendTime;
	private String returnFlag;
	public String getLendBookId() {
		return lendBookId;
	}
	public void setLendBookId(String lendBookId) {
		this.lendBookId = lendBookId;
	}
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
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getLendTime() {
		return lendTime;
	}
	public void setLendTime(String lendTime) {
		this.lendTime = lendTime;
	}
	public String getReturnFlag() {
		return returnFlag;
	}
	public void setReturnFlag(String returnFlag) {
		this.returnFlag = returnFlag;
	}
	public lendtableEntity(String lendBookId, String bookId, String bookName, String stuName, String lendTime,
			String returnFlag) {
		super();
		this.lendBookId = lendBookId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.stuName = stuName;
		this.lendTime = lendTime;
		this.returnFlag = returnFlag;
	}
	

}
