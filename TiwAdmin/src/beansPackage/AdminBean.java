package beansPackage;

public class AdminBean {

	private String adminID; 
	private String password;
	/**
	 * @param adminID
	 * @param password
	 */
	public AdminBean(String adminID, String password) {
		super();
		this.adminID = adminID;
		this.password = password;
	}
	/**
	 * @return the adminID
	 */
	public String getAdminID() {
		return adminID;
	}
	/**
	 * @param adminID the adminID to set
	 */
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
