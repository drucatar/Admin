package beansPackage;

public class DiscountsBean {
	/*ID_prof, ID_Course and discount Number are the primary keys. The first two are also foreign keys.*/
	private int ID_prof;
	private int ID_Course;
	private int discountNumber;
	
	private double quantity;
	private String init_Date;
	private String expiration_Date;
	/**
	 * @param iD_prof
	 * @param iD_Course
	 * @param discountNumber
	 * @param quantity
	 * @param init_Date
	 * @param expiration_Date
	 */
	public DiscountsBean(int iD_prof, int iD_Course, int discountNumber,
			double quantity, String init_Date, String expiration_Date) {
		ID_prof = iD_prof;
		ID_Course = iD_Course;
		this.discountNumber = discountNumber;
		this.quantity = quantity;
		this.init_Date = init_Date;
		this.expiration_Date = expiration_Date;
	}
	/**
	 * @return the iD_prof
	 */
	public int getID_prof() {
		return ID_prof;
	}
	/**
	 * @param iD_prof the iD_prof to set
	 */
	public void setID_prof(int iD_prof) {
		ID_prof = iD_prof;
	}
	/**
	 * @return the iD_Course
	 */
	public int getID_Course() {
		return ID_Course;
	}
	/**
	 * @param iD_Course the iD_Course to set
	 */
	public void setID_Course(int iD_Course) {
		ID_Course = iD_Course;
	}
	/**
	 * @return the discountNumber
	 */
	public int getDiscountNumber() {
		return discountNumber;
	}
	/**
	 * @param discountNumber the discountNumber to set
	 */
	public void setDiscountNumber(int discountNumber) {
		this.discountNumber = discountNumber;
	}
	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the init_Date
	 */
	public String getInit_Date() {
		return init_Date;
	}
	/**
	 * @param init_Date the init_Date to set
	 */
	public void setInit_Date(String init_Date) {
		this.init_Date = init_Date;
	}
	/**
	 * @return the expiration_Date
	 */
	public String getExpiration_Date() {
		return expiration_Date;
	}
	/**
	 * @param expiration_Date the expiration_Date to set
	 */
	public void setExpiration_Date(String expiration_Date) {
		this.expiration_Date = expiration_Date;
	}
	
}
