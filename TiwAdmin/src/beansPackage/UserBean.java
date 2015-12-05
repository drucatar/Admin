package beansPackage;

/**
 *
 * @author Rob
 */
public class UserBean {

  // nickname is the primary key of the users
  private String nickname;

  private String name;

  private String surname;
  
  private String email;
  
  private String adress;
  
  private String description;
  
  private String password;
  
  private String profileImagePath;
    //This variable is used for differencing between student(0), professor (1) and admin (2)
  private char category;
  
  private int age;

  // Creates new DataBean
 
  public UserBean(String nickname, String name,String surname,String email,String adress,
		  String password,String description, String profileImagePath,char category, int age) {
    this.nickname = nickname;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.adress = adress;
    this.password = password;
    this.description = description;
    this.profileImagePath=profileImagePath;
    this.category=category;
    this.age=age;
    
    
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
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the surname
 */
public String getSurname() {
	return surname;
}

/**
 * @param surname the surname to set
 */
public void setSurname(String surname) {
	this.surname = surname;
}

/**
 * @return the email
 */
public String getEmail() {
	return email;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}

/**
 * @return the adress
 */
public String getAdress() {
	return adress;
}

/**
 * @param adress the adress to set
 */
public void setAdress(String adress) {
	this.adress = adress;
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
 * @return the profileimagepath
 */
public String getProfileImagePath() {
	return profileImagePath;
}

/**
 * @param profileimagepath the profileimagepath to set
 */
public void setProfileImagePath(String profileImagePath) {
	this.profileImagePath = profileImagePath;
}

/**
 * @return the category
 */
public char getCategory() {
	return category;
}

/**
 * @param category the category to set
 */
public void setCategory(char category) {
	this.category = category;
}

/**
 * @return the age
 */
public int getAge() {
	return age;
}

/**
 * @param age the age to set
 */
public void setAge(int age) {
	this.age = age;
}

    
}
