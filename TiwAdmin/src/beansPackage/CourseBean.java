package beansPackage;

public class CourseBean {
	
	/*ID is the primary key. It "does not" respect Java naming conventions due to language reasons*/
	private String ID;
	private int professorID;
	private int duration;
	private String title;
	private String imagePath;
	private String description;
	private String syllabus;
	private String material;
	private String notification;
	private String specialOfferType;
	private double price;
	private double rating;
	private boolean validated;
	private boolean highlighted;
	
	
	public CourseBean(String iD, int professorID, int duration, String title,
			String imagePath, String description, String syllabus,
			String material, String notification, String specialOfferType,
			double price, double rating, boolean validated, boolean highlighted) {
		this.ID = iD;
		this.professorID = professorID;
		this.duration = duration;
		this.title = title;
		this.imagePath = imagePath;
		this.description = description;
		this.syllabus = syllabus;
		this.material = material;
		this.notification = notification;
		this.specialOfferType = specialOfferType;
		this.price = price;
		this.rating = rating;
		this.validated = validated;
		this.highlighted = highlighted;
	}
	
	
	/*Getters and setters*/
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the professorID
	 */
	public int getProfessorID() {
		return professorID;
	}

	/**
	 * @param professorID the professorID to set
	 */
	public void setProfessorID(int professorID) {
		this.professorID = professorID;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
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

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the syllabus
	 */
	public String getSyllabus() {
		return syllabus;
	}

	/**
	 * @param syllabus the syllabus to set
	 */
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * @return the notification
	 */
	public String getNotification() {
		return notification;
	}

	/**
	 * @param notification the notification to set
	 */
	public void setNotification(String notification) {
		this.notification = notification;
	}

	/**
	 * @return the specialOfferType
	 */
	public String getSpecialOfferType() {
		return specialOfferType;
	}

	/**
	 * @param specialOfferType the specialOfferType to set
	 */
	public void setSpecialOfferType(String specialOfferType) {
		this.specialOfferType = specialOfferType;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return the validated
	 */
	public boolean isValidated() {
		return validated;
	}

	/**
	 * @param validated the validated to set
	 */
	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	/**
	 * @return the highlighted
	 */
	public boolean isHighlighted() {
		return highlighted;
	}

	/**
	 * @param highlighted the highlighted to set
	 */
	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}


	
}
