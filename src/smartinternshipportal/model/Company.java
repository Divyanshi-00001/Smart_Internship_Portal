package smartinternshipportal.model;

import java.util.HashSet;

public class Company {
	private String companyId;
	private static int id_no = 100;
	private String companyName;
	private String email;
	private String password;
	private HashSet<Job> jobs = new HashSet<>();
	
	public Company() {
		id_no++;
	}
	
	public void setCompanyId() {
		companyId = companyName+"Co."+id_no;
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
	public void setPassword() {
		this.password=password;
	}
	
	public HashSet<Job> getJobs() {
		return jobs;
	}
	
	public void addJob(String title, String location, double sal, double minCgpa, HashSet<String> skills) {
		Job obj = new Job();
		obj.setJobId();
		obj.setTitle(title);;
		obj.setLocation(location);
		obj.setSalary(sal);
		obj.setMinCgpa(minCgpa);
		obj.setRequiredSkill(skills);
		jobs.add(obj);
	}
	
	public void show() {
		System.out.println("Company Id: "+companyId+"  "+"Company Name: "+companyName+"  Company Email: "+email);
	}
}