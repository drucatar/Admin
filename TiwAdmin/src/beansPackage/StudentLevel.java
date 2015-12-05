package beansPackage;

public class StudentLevel {

	/*Nickname is both primary and foreign key*/
	private String nickname;
	private String level;
	/**
	 * @param nickname
	 * @param level
	 */
	public StudentLevel(String nickname, String level) {
		super();
		this.nickname = nickname;
		this.level = level;
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
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
}
