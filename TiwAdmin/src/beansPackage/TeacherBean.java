package beansPackage;

public class TeacherBean extends UserBean {
	
	/**
	 * @param nickname
	 * @param paypal
	 * @param income
	 */
	private String paypalEmail;
	private double income;
	/**
	 * @param nickname
	 * @param name
	 * @param surname
	 * @param email
	 * @param adress
	 * @param password
	 * @param description
	 * @param profileimagepath
	 * @param category
	 * @param age
	 * @param paypalEmail
	 * @param income
	 */
	public TeacherBean(String nickname, String name, String surname,
			String email, String adress, String password, String description,
			String profileImagePath, char category, int age,
			String paypalEmail, double income) {
		super(nickname, name, surname, email, adress, password, description,
				profileImagePath, category, age);
		this.paypalEmail = paypalEmail;
		this.income = income;
	}
	/**
	 * @return the paypalEmail
	 */
	public String getPaypalEmail() {
		return paypalEmail;
	}
	/**
	 * @param paypalEmail the paypalEmail to set
	 */
	public void setPaypalEmail(String paypalEmail) {
		this.paypalEmail = paypalEmail;
	}
	/**
	 * @return the income
	 */
	public double getIncome() {
		return income;
	}
	/**
	 * @param income the income to set
	 */
	public void setIncome(double income) {
		this.income = income;
	}
	
	
	
}
	