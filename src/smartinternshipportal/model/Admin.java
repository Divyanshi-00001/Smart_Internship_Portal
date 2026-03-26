package smartinternshipportal.model;

public class Admin {
	private int adminIdIO;
	private String usernameIO;
	private String passwordIO;
	private int adminId;
	private String username;
	private String password;
	
	public Admin() {
		this.adminId = 10501;
		this.username = "user123";
		this.password = "admin123";
	}
	
	public void getId(int id) {
		this.adminIdIO = id;
	}
	public void getName(String name) {
		this.usernameIO = name;
	}
	public void getPassword(String id) {
		this.passwordIO = id;
	}
	
	public boolean Authentication() {
		if((adminId == adminIdIO) && (usernameIO.equals(username)) && (passwordIO.equals(password))) {
			return true;
		} 
		else {
			return false;
		}
	}
	
}
