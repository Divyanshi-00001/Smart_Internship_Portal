package smartinternshipportal.model;
import java.util.HashSet;

public class Job extends Company{
	private String jobId;
	private static int jid_no=1000;
	private String title;
	private String location;
	private double salary;
	private double minCgpa;
	private HashSet<String> requiredSkills = new HashSet<>();
	
	public Job(String companyName, String email, String password, String title, String location, double salary, double cgpa, HashSet<String> skills) {
		super(companyName, email, password);
		jid_no++;
		this.jobId = "Job:"+jid_no;
		this.title=title;
		this.location =location;
		this.salary=salary;
		this.minCgpa=cgpa;
		this.requiredSkills = skills;
		show();
	}
	
	public String getJobId() {
		return jobId;
	} 
	public void setJobId() {
		this.jobId = "Job:"+jid_no;
	} 

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	} 
	
	public String getLocation() {
		return location;
	} 
	public void setLocation(String location) {
		this.location = location;
	} 
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double sal) {
		this.salary = sal;
	}
	
	public double getMinCgpa() {
		return minCgpa;
	} 
	public void setMinCgpa(double cgpa) {
		this.minCgpa = cgpa;
	} 
	
	public HashSet<String> getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkill(HashSet<String> skills) {
		requiredSkills=skills;
	} 
	public void show() {
		super.show();
		System.out.println("Job Id: "+jobId+"\nJob Title: "+title+"\nJob Location: "+location+"\nJob Salary: "+salary+"\nMin. CGPA: "+minCgpa+"\n-------------------------------------------------------\n");
	}
}