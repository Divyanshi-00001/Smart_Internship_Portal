package smartinternshipportal.model;
import java.util.HashSet;

public class Job extends Company{
	private String jobId;
	private static int jid_no=1000;
	private String title;
	private String location;
	private double salary;
	private String qualification;
	private double minCgpa;
	private String webLink;
	private HashSet<String> requiredSkills = new HashSet<>();
	
	public Job(String companyName, String email, String password, String title, String location, double salary, String qualification, double cgpa, String webLink, HashSet<String> skills) {
		super(companyName, email, password);
		jid_no++;
		this.jobId = "Job:"+jid_no;
		this.title=title;
		this.location =location;
		this.salary=salary;
		this.qualification=qualification;
		this.minCgpa=cgpa;
		this.webLink=webLink;
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
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification=qualification;
	}
	
	public double getMinCgpa() {
		return minCgpa;
	} 
	public void setMinCgpa(double cgpa) {
		this.minCgpa = cgpa;
	} 
	
	public String getWebLink() {
		return webLink;
	}
	public void setWebLink(String webLink) {
		this.webLink=webLink;
	}
	
	public HashSet<String> getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkill(HashSet<String> skills) {
		requiredSkills=skills;
	} 
	public void show() {
		super.show();
		System.out.println("Job Id: "+jobId+"\nJob Title: "+title+"\nJob Location: "+location+"\nJob Salary: "+salary+"/-"+"\nHighest Qualification Req.: "+qualification+"\nMin. CGPA: "+minCgpa+"\n-------------------------------------------------------\n");
	}
	public String details() {
		return super.details() + "Job Id: "+jobId+"\nJob Title: "+title+"\nJob Location: "+location+"\nJob Salary: "+salary+"/-"+"\nHighest Qualification Req.: "+qualification+"\nMin. CGPA: "+minCgpa+"\n-------------------------------------------------------\n";
	}
}