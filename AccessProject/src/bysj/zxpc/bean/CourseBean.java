package bysj.zxpc.bean;

public class CourseBean {
	int courseId;
	String courseName;
	int courseTime;
	int courseGra;
	String courseTea;
	String courseBz;
	public CourseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseBean(int courseId, String courseName, int courseTime, int courseGra, String courseTea,
			String courseBz) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseTime = courseTime;
		this.courseGra = courseGra;
		this.courseTea = courseTea;
		this.courseBz = courseBz;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(int courseTime) {
		this.courseTime = courseTime;
	}
	public int getCourseGra() {
		return courseGra;
	}
	public void setCourseGra(int courseGra) {
		this.courseGra = courseGra;
	}
	public String getCourseTea() {
		return courseTea;
	}
	public void setCourseTea(String courseTea) {
		this.courseTea = courseTea;
	}
	public String getCourseBz() {
		return courseBz;
	}
	public void setCourseBz(String courseBz) {
		this.courseBz = courseBz;
	}
	
	
}
