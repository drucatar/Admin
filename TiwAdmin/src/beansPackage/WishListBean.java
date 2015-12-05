package beansPackage;

public class WishListBean {

	private int courseID;
	private String nickname;
	/**
	 * @param courseID
	 * @param nickname
	 */
	public WishListBean(int courseID, String nickname) {
		super();
		this.courseID = courseID;
		this.nickname = nickname;
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
	
	
}
