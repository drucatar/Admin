package beansPackage;

public class StudentBean extends UserBean{

	
	private String interests;
	private String paymentData;
	private String achievements;
	public StudentBean(String nickname, String name, String surname,
			String email, String adress, String password, String description,
			String profileImagePath, char category, int age, String interests,
			String paymentData, String achievements) {
		super(nickname, name, surname, email, adress, password, description,
				profileImagePath, category, age);
		this.interests = interests;
		this.paymentData = paymentData;
		this.achievements = achievements;
	}
	/**
	 * @return the interests
	 */
	public String getInterests() {
		return interests;
	}
	/**
	 * @param interests the interests to set
	 */
	public void setInterests(String interests) {
		this.interests = interests;
	}
	/**
	 * @return the paymentData
	 */
	public String getPaymentData() {
		return paymentData;
	}
	/**
	 * @param paymentData the paymentData to set
	 */
	public void setPaymentData(String paymentData) {
		this.paymentData = paymentData;
	}
	/**
	 * @return the achievements
	 */
	public String getAchievements() {
		return achievements;
	}
	/**
	 * @param achievements the achievements to set
	 */
	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}
	
	


}
