package beansPackage;

public class InvitedProfessorsBean {

	/*Both primary and foreigh keys*/
	private int ID_course;
	private int ID_professor;
	/**
	 * @param iD_course
	 * @param iD_professor
	 */
	public InvitedProfessorsBean(int iD_course, int iD_professor) {
		ID_course = iD_course;
		ID_professor = iD_professor;
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
	 * @return the iD_professor
	 */
	public int getID_professor() {
		return ID_professor;
	}
	/**
	 * @param iD_professor the iD_professor to set
	 */
	public void setID_professor(int iD_professor) {
		ID_professor = iD_professor;
	}
	
	
}
