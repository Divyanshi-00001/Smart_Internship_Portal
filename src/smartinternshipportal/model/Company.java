package smartinternshipportal.model;

import java.util.HashSet;

public class Company {
	private String companyId;
	private static int id_no = 1000;
	private String companyName;
	private String email;
	private String password;
	
	public Company(String companyName, String email, String password) {
		id_no++;
		this.companyId=companyName+":"+id_no;
		this.companyName=companyName;
		this.email=email;
		this.password=password;
	}
	
	public void setCompanyId() {
		companyId = companyName+":"+id_no;
	}
	public String getCompanyId() {
		return companyId;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String name) {
		this.companyName = name;
	}
	
	public String getEmail() {
		return email;
	} 
	public void setEmail(String email) {
		this.email = email;
	} 
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	public void show() {
		System.out.println("\n-----------------Job Details-----------------\nCompany Id: "+companyId+"\nCompany Name: "+companyName+"\nCompany Official Email: "+email);
	}
	public String details() {
		return "-----------------Job Details-----------------\nCompany Id: "+companyId+"\nCompany Name: "+companyName+"\nCompany Official Email: "+email+"\n";
	}
}