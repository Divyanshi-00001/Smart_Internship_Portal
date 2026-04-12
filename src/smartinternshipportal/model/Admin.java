package smartinternshipportal.model;

public class Admin {
	private int adminIdIO;
	private String usernameIO;
	private String passwordIO;
	private int adminId;
	private String username;
	private String password;
	
	public Admin(int id, String name, String pw) {
		this.adminId = 10501;
		this.username = "user123";
		this.password = "admin123";
		this.adminIdIO = id;
		this.usernameIO = name;
		this.passwordIO = pw;
	}
	
	public void getId(int id) {
		this.adminIdIO = id;
	}
	public void getName(String name) {
		this.usernameIO = name;
	}
	public void getPassword(String pw) {
		this.passwordIO = pw;
	}
	
	public boolean Authentication() {
		if((adminId == adminIdIO) && (usernameIO.equals(username)) && (passwordIO.equals(password))) {
			System.out.println("Authentiacation is Successful...\n");
			return true;
		} 
		else {
			System.out.println("Admin is not Authorized! Authentication Failed!! \n");
			return false;
		}
	}
}
