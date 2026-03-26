package smartinternshipportal.model;
import java.util.HashSet;

public class Student {
	// Fields
	private String studentid;
	private static int id_no=100;
	private String name;
	private String email;
	private String password;
	private double cgpa;
	private HashSet<String> skills = new HashSet<>();
	private String resumePath;
	private double expectedJobSalary;
	
	public Student() {
		id_no++;
	}
	
	public String getStudentID() {
		return studentid;
	}
	public void setStudentID(int id) {
		studentid = "Student"+id_no;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String nm) {
		name = nm;
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
	public void setPassword(String pw) {
		password = pw;
	}
	
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
	public HashSet<String> getSkills() {
		return skills;
	}
	public void addSkill(HashSet<String> skills) {
		this.skills=skills;	
	}
	
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}
	
	public double getSalary() {
		return expectedJobSalary;
	}
	public void setSalary(double sal) {
		expectedJobSalary = sal;
	}
}
