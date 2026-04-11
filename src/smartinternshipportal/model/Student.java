package smartinternshipportal.model;
import java.util.HashSet;
import java.io.*;


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
	private String line;
	
	public Student(String nm, String email, String pw, double cgpa, String resumePath, double sal) {
		id_no++;
		this.studentid="Stud:"+id_no;
		this.name=nm;
		this.email=email;
		this.password=pw;
		this.cgpa=cgpa;
		this.resumePath=resumePath;
		readingFile();
		this.expectedJobSalary=sal;
		show();
	}
	
	public void readingFile() {
		try(BufferedReader br = new BufferedReader(new FileReader(resumePath))) {
			while((line=br.readLine())!=null) {
				String dline[] = line.split(" ");
				for(String word : dline) {
					skills.add(word.toLowerCase().replaceAll("[^a-zA-Z]", ""));
				}
			}
		}
		catch (IOException e) {
			System.out.println("Error in Reading Resume File !!!");
			System.out.println(e.toString());
		}
	}
	
	public String getStudentID() {
		return studentid;
	}
	public void setStudentID() {
		studentid = "Stud:"+id_no;
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
	
	public String getResumePath() {
		return resumePath;
	}
	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
		readingFile();
	}
	
	public double getSalary() {
		return expectedJobSalary;
	}
	public void setSalary(double sal) {
		expectedJobSalary = sal;
	}
	
	public void show() {
		System.out.println("\n---------------------Student Details Successfully Inserted---------------------\nStudent ID: "+studentid+"\nStudent Name: "+name+"\nEmail: "+email+"\nCGPA: "+cgpa+"\nExpected Job Salary: "+expectedJobSalary+"\n-------------------------------------------------------------------\n");
	}
}
