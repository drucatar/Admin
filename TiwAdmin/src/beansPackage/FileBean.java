package beansPackage;

public class FileBean {

	private String lessontitle;
	private int courseID;
	private int fileID;
	private char type;
	
	
	/**
	 * @param lessontitle
	 * @param courseID
	 * @param fileID
	 * @param type
	 */
	public FileBean(String lessontitle, int courseID, int fileID, char type) {
		super();
		this.lessontitle = lessontitle;
		this.courseID = courseID;
		this.fileID = fileID;
		this.type = type;
	}
	
	
	/**
	 * @return the lessontitle
	 */
	public String getLessontitle() {
		return lessontitle;
	}
	/**
	 * @param lessontitle the lessontitle to set
	 */
	public void setLessontitle(String lessontitle) {
		this.lessontitle = lessontitle;
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
	 * @return the fileID
	 */
	public int getFileID() {
		return fileID;
	}
	/**
	 * @param fileID the fileID to set
	 */
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.type = type;
	}
	
	
}
