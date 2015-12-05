package beansPackage;

public class StudentCourses {

	private int courseID;
	private String nickname;
	private int percentage;
	/**
	 * @param courseID
	 * @param nickname
	 * @param percentage
	 */
	public StudentCourses(int courseID, String nickname, int percentage) {
		super();
		this.courseID = courseID;
		this.nickname = nickname;
		this.percentage = percentage;
	}
	/**
	 * @return the courseID
	 */
	public int getCourseID() {
		return courseID;
	}
	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the percentage
	 */
	public int getpercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setpercentage(int percentage) {
		this.percentage = percentage;
	}
	
	
}
