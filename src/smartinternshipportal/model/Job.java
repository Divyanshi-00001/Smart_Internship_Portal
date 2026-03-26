package smartinternshipportal.model;
import java.util.HashSet;

public class Job {
	private String jobId;
	private static int jid_no=100;
	private String title;
	private String location;
	private double salary;
	private double minCgpa;
	private HashSet<String> requiredSkills = new HashSet<>();
	
	public Job() {
		jid_no++;
	}
	
	public String getJobId() {
		return jobId;
	} 
	public void setJobId() {
		this.jobId = "Job"+jid_no;
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
		this.salary = salary;
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
		System.out.println("  Job Id: "+jobId+"  Job Title: "+title+"  Job Location: "+location+"  Job Salary: "+salary+"  Min. CGPA: "+minCgpa);
	}
}