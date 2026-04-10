package smartinternshipportal.main;

import java.util.Scanner;
import smartinternshipportal.model.Admin;

public class AdminModule {
	
	public boolean CreateAdmin() {
		int id;
		String name;
		String password;
		Scanner sr = new Scanner(System.in);
		try {
			System.out.print("Enter Admin id: ");
			id = Integer.parseInt(sr.nextLine());
			System.out.print("Enter Admin name: ");
			name = sr.nextLine();
			System.out.print("Enter Admin password: ");
			password = sr.nextLine();
			Admin adm = new Admin(id,name,password);
			return adm.Authentication();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		sr.close();
		return false;
	}	
}
