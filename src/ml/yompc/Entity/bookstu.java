package ml.yompc.Entity;

public class bookstu {
	private String stuId;
	private String studentId;
	private String stuName;
	private String sexId;
	private String classId;
	private String enterTime;
	public bookstu(String stuId, String studentId, String stuName, String sexId, String classId, String enterTime) {
		super();
		this.stuId = stuId;
		this.studentId = studentId;
		this.stuName = stuName;
		this.sexId = sexId;
		this.classId = classId;
		this.enterTime = enterTime;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getSexId() {
		return sexId;
	}
	public void setSexId(String sexId) {
		this.sexId = sexId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

}
