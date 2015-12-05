package beansPackage;

public class LessonBean {

	private int ID_course;
	private String title;
	/**
	 * @param iD_course
	 * @param title
	 */
	public LessonBean(int iD_course, String title) {
		ID_course = iD_course;
		this.title = title;
	}
	/**
	 * @return the iD_course
	 */
	public int getID_course() {
		return ID_course;
	}
	/**
	 * @param iD_course the iD_course to set
	 */
	public void setID_course(int iD_course) {
		ID_course = iD_course;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
}
