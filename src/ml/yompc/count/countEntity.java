package ml.yompc.count;

public class countEntity {
	private String lendBookId;
	private String bookId;
	public countEntity(String lendBookId, String bookId, String stuId, String lendTime, String returnTime,
			String returnFlag) {
		super();
		this.lendBookId = lendBookId;
		this.bookId = bookId;
		this.stuId = stuId;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
		this.returnFlag = returnFlag;
	}
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
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getLendTime() {
		return lendTime;
	}
	public void setLendTime(String lendTime) {
		this.lendTime = lendTime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getReturnFlag() {
		return returnFlag;
	}
	public void setReturnFlag(String returnFlag) {
		this.returnFlag = returnFlag;
	}
	private String stuId;
	private String lendTime;
	private String returnTime;
	private String returnFlag;
	

}
