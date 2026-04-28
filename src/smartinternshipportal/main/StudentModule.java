package smartinternshipportal.main;

import smartinternshipportal.algorithms.RecommendationEngine;
import smartinternshipportal.model.*;
import smartinternshipportal.dao.ApplicantDAO;

import java.util.*;

class InvalidNameException extends Exception {
    public InvalidNameException(String msg) 
    { 
    	super(msg); 
    }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String msg) { 
    	super(msg); 
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String msg) { 
    	super(msg); 
    }
}

class InvalidQualificationException extends Exception {
	public InvalidQualificationException(String msg) {
		super(msg);
	}
}

class InvalidCgpaException extends Exception {
    public InvalidCgpaException(String msg) { 
    	super(msg); 
    }
}

class InvalidFilePathException extends Exception {
    public InvalidFilePathException(String msg) { 
    	super(msg); 
    }
}

class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String msg) { 
    	super(msg); 
    }
}

public class StudentModule {
	
	public static boolean StudentSignUp(String nm, String email, String pw, String qualification, double cgpa, String resumePath, double sal) {	
		try {
			if (nm.isEmpty())
	            throw new InvalidNameException("Name cannot be empty");
			if (!email.contains("@") || !email.contains(".") || email.contains(" "))
			    throw new InvalidEmailException("Invalid Email");
			for(int i = 0; i <= MainApp.Snum; i++) {
		        if(MainApp.ss[i] != null &&
		           MainApp.ss[i].getEmail().equals(email)) {
		        	throw new InvalidEmailException("This Email is Already Registered.");
		        }
		    }
			if (pw.length()<8)
	            throw new InvalidPasswordException("Weak Password");
			if (qualification.isEmpty())
				throw new InvalidQualificationException("Invalid Insert of Qualification");
			if(cgpa>10 || cgpa<0)
				throw new InvalidCgpaException("Invalid Cgpa");
			if (!resumePath.endsWith(".txt"))
			    throw new InvalidFilePathException("Resume must be .txt file");
			if(sal<0)
				throw new InvalidSalaryException("Invalid Salary");
			MainApp.Snum++;
			if(MainApp.Snum>=MainApp.ss.length)
				MainApp.ss = Arrays.copyOf(MainApp.ss,(MainApp.ss.length+MainApp.ss.length));	
			Student st = new Student(nm,email,pw,qualification,cgpa,resumePath,sal);
			if (st != null) {
				MainApp.ss[MainApp.Snum] = st;
				ApplicantDAO.insertApplicant(st);
				return true;
			} else {
				MainApp.Snum--;
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
            System.out.println("Try again...\n");
		}
		return false;
	}
	
	public static void SignUpResizeMainArrays() {
		try {
			MainApp.Snum++;
			if(MainApp.Snum>=MainApp.ss.length)
				MainApp.ss = Arrays.copyOf(MainApp.ss,(MainApp.ss.length+MainApp.ss.length));
			StudentModule sm = new StudentModule();
			Student st = sm.CreateStudents();
			if (st != null) {
				ApplicantDAO.insertApplicant(st);
				MainApp.ss[MainApp.Snum] = st;
			} else {
				MainApp.Snum--;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	} 
	
	public Student CreateStudents() {
		Scanner sr=new Scanner(System.in);
		try {
			System.out.print("Enter Name: ");
			String name = sr.nextLine();

			System.out.print("Enter Email: ");
			String email = sr.nextLine();

			System.out.print("Enter Password: ");
			String password = sr.nextLine();
			
			System.out.print("Enter Qualification: ");
			String qualification = sr.nextLine();

			System.out.print("Enter CGPA: ");
			double cgpa = Double.parseDouble(sr.nextLine());

			System.out.print("Enter Resume Path: ");
			String resumePath = sr.nextLine();

			System.out.print("Enter Expected Salary: ");
			double salary = Double.parseDouble(sr.nextLine());
			
			if (name.isEmpty())
	            throw new InvalidNameException("Name cannot be empty");
			if (!email.contains("@") || !email.contains("."))
			    throw new InvalidEmailException("Invalid Email");
			for(int i = 0; i <= MainApp.Snum; i++) {
		        if(MainApp.ss[i] != null &&
		           MainApp.ss[i].getEmail().equals(email)) {
		        	throw new InvalidEmailException("This Email is Already Registered.");
		        }
		    }
			if (password.length()<8)
	            throw new InvalidPasswordException("Weak Password");
			if (qualification.isEmpty())
				throw new InvalidQualificationException("Invalid Insert of Qualification");
			if(cgpa>10 || cgpa<0)
				throw new InvalidCgpaException("Invalid Cgpa");
			if (!resumePath.endsWith(".txt"))
			    throw new InvalidFilePathException("Resume must be .txt file");
			if(salary<0)
				throw new InvalidSalaryException("Invalid Salary");
			return new Student(name,email,password,qualification,cgpa,resumePath,salary);
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
            System.out.println("Try again...\n");
		}
		return null;
	}
	
	public static void BeforeStudentLogin() throws Exception {
		Scanner sr = new Scanner(System.in);
		System.out.print("Enter Email: ");
	    String semail = sr.nextLine();
	    
	    System.out.print("Enter Password: ");
	    String spass = sr.nextLine();
	    
	    Student loggedStudent = studentLogin(semail, spass);
	    
	    if(loggedStudent != null) {
	        System.out.println("Login Successful!");
	        loggedStudent.show();
	        PowersAfterLogin(loggedStudent);
	    } else {
	        System.out.println("Invalid Credentials!");
	    }
	}
	
	public static Student studentLogin(String email, String password) {
	    for(int i = 0; i <= MainApp.Snum; i++) {
	        if(MainApp.ss[i] != null &&
	           MainApp.ss[i].getEmail().equals(email) &&
	           MainApp.ss[i].getPassword().equals(password)) {
	           return MainApp.ss[i];
	        }
	    }
	    return null;
	}
	
	public static void PowersAfterLogin(Student loggedStudent) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int choice;

	    do {
	        System.out.println("\n1. View Profile");
	        System.out.println("2. Get Job Recommendations");
	        System.out.println("3. Apply for Job");
	        System.out.println("4. Update Credentials");
	        System.out.println("5. Logout");
	        System.out.print("Enter choice: ");

	        choice = Integer.parseInt(sc.nextLine());

	        switch(choice) {
	            case 1:
	                loggedStudent.show();
	                break;

	            case 2:
	                RecommendJobs();
	                break;
	                
	            case 3:
	            	ApplicationModule.ApplicationsWorking();
				    break;

	            case 4:
	                updateCredentials(loggedStudent);
	                break;

	            case 5:
	                System.out.println("Logged out successfully!");
	                break;

	            default:
	                System.out.println("Invalid choice!");
	        }
	    } while(choice != 5);
	}
	
	public static void RecommendJobs() {
		Scanner sr = new Scanner(System.in);
		if (MainApp.Snum >= 0 && MainApp.Jnum >= 0) {
			List<Job> jobList = new ArrayList<>();
			for(int i = 0; i <= MainApp.Jnum; i++) {
			    if(MainApp.jj[i] != null) {
			        jobList.add(MainApp.jj[i]);
			    }
			}
			System.out.print("Enter Student Id: ");
			String id = sr.nextLine();
			int i;
			for(i = 0; i <= MainApp.Snum; i++) {
			    if(MainApp.ss[i] != null && id.equals(MainApp.ss[i].getStudentID())) {
			        break;
			    }
			}
			if(i > MainApp.Snum) {
			    System.out.println("Student not found!");
			    return;
			}
			HashSet<String> nonMatchedSkills = new HashSet<>();
			List<Map.Entry<Job, Double>> recommended = RecommendationEngine.recommendJobs(MainApp.ss[i], jobList, nonMatchedSkills);

			int count = 0;
	        System.out.println("\nRecommended Jobs:\n");
	        for (Map.Entry<Job, Double> jb : recommended) {
	        	count++;
	        	if(count>100) break;
	        	System.out.println("Score: "+jb.getValue());
	            jb.getKey().show();
	        }
	        
	        System.out.println("List of Not Matched Skills(Recommendation for Learning.):");
	        for(String skill : nonMatchedSkills) {
	        	count++;
	        	if(count>200)break;
	        	System.out.println(skill);
	        }
	    } else {
	        System.out.println("No data available!");
	    }
	}
	
	public static String[] RecommendJobsUI(String id) {
		if (MainApp.Snum >= 0 && MainApp.Jnum >= 0) {
			List<Job> jobList = new ArrayList<>();
			for(int i = 0; i <= MainApp.Jnum; i++) {
			    if(MainApp.jj[i] != null) {
			        jobList.add(MainApp.jj[i]);
			    }
			}
			int i;
			for(i = 0; i <= MainApp.Snum; i++) {
			    if(MainApp.ss[i] != null && id.equals(MainApp.ss[i].getStudentID())) {
			        break;
			    }
			}
			if(i > MainApp.Snum) {
			    return new String[]{"Student not found!","Student not found!"};
			}
			
			HashSet<String> nonMatchedSkills = new HashSet<>();
			List<Map.Entry<Job, Double>> recommended = RecommendationEngine.recommendJobs(MainApp.ss[i], jobList, nonMatchedSkills);

			String jobs="";
			String skills="";
			
			int count = 0;
			jobs += "Recommended Jobs:\n\n";
	        for (Map.Entry<Job, Double> jb : recommended) {
	        	count++;
	        	if(count>100) break;
	        	jobs += "Score: "+jb.getValue() + "\n" + jb.getKey().details() + "\n";
	        }
	        
	        skills += "List of Not Matched Skills(Recommendation for Learning.):" + "\n\n";
	        for(String skill : nonMatchedSkills) {
	        	count++;
	        	if(count>200)break;
	        	skills += skill + "\n";
	        }
	        return new String[]{jobs, skills};

	    } else {
	        return new String[]{"No data available!","No data available!"};
	    }
	}
	
	public static void updateCredentials(Student student) {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n--- Update Credentials ---");
	    System.out.println("1. Update Name");
	    System.out.println("2. Update Email");
	    System.out.println("3. Update Password");
	    System.out.println("4. Update Qualification");
	    System.out.println("5. Update CGPA");
	    System.out.println("6. Update Resume");
	    System.out.println("7. Update Expected Salary");
	    System.out.print("Enter choice: ");

	    int choice = Integer.parseInt(sc.nextLine());

	    try {
	        switch(choice) {
		        case 1:
		            System.out.print("Enter new name: ");
		            String name = sc.nextLine();
	
		            if(name.isEmpty())
		                throw new InvalidNameException("Name cannot be empty");
	
		            System.out.print("Are you sure you want to update? (yes/no): ");
		            String confirm1 = sc.nextLine().trim().toLowerCase();
	
		            if(!confirm1.equals("yes")) {
		                System.out.println("Update cancelled.");
		                return;
		            }
	
		            student.setName(name);
		            break;

		        case 2:
		            System.out.print("Enter new email: ");
		            String email = sc.nextLine().trim();

		            if (!email.contains("@") || !email.contains("."))
		                throw new InvalidEmailException("Invalid Email");

		            // 🔴 Check duplicate email
		            for(int i = 0; i <= MainApp.Snum; i++) {
		                if(MainApp.ss[i] != null &&
		                   MainApp.ss[i].getEmail().equals(email) &&
		                   MainApp.ss[i] != student) {   // exclude current user

		                    throw new InvalidEmailException("Email already exists!");
		                }
		            }

		            System.out.print("Are you sure you want to update? (yes/no): ");
		            String confirm2 = sc.nextLine().trim().toLowerCase();

		            if(!confirm2.equals("yes")) {
		                System.out.println("Update cancelled.");
		                return;
		            }

		            student.setEmail(email);
		            break;

	            case 3:
	                System.out.print("Enter new password: ");
	                String password = sc.nextLine();
	                if(password.length() < 8)
	                    throw new InvalidPasswordException("Weak Password");
	                System.out.print("Are you sure you want to update? (yes/no): ");
		            String confirm3 = sc.nextLine().trim().toLowerCase();
	
		            if(!confirm3.equals("yes")) {
		                System.out.println("Update cancelled.");
		                return;
		            }
	                student.setPassword(password);
	                break;
	                
	            case 4:
		            System.out.print("Enter new Highest Qualification: ");
		            String qualification = sc.nextLine();
	
		            if(qualification.isEmpty())
		                throw new InvalidQualificationException("Qualification cannot be empty");
	
		            System.out.print("Are you sure you want to update? (yes/no): ");
		            String confirm4 = sc.nextLine().trim().toLowerCase();
	
		            if(!confirm4.equals("yes")) {
		                System.out.println("Update cancelled.");
		                return;
		            }
	
		            student.setQualification(qualification);
		            break;


	            case 5:
	                System.out.print("Enter new CGPA: ");
	                double cgpa = Double.parseDouble(sc.nextLine());
	                if(cgpa < 0 || cgpa > 10)
	                    throw new InvalidCgpaException("Invalid CGPA");
	                System.out.print("Are you sure you want to update? (yes/no): ");
		            String confirm5 = sc.nextLine().trim().toLowerCase();
	
		            if(!confirm5.equals("yes")) {
		                System.out.println("Update cancelled.");
		                return;
		            }
	                student.setCgpa(cgpa);
	                break;

	            case 6:
	                System.out.print("Enter new resume path: ");
	                String path = sc.nextLine();

	                if (!path.endsWith(".txt"))
	                    throw new InvalidFilePathException("Resume must be .txt file");
	                
	                System.out.print("Are you sure you want to update? (yes/no): ");
		            String confirm6 = sc.nextLine().trim().toLowerCase();
	
		            if(!confirm6.equals("yes")) {
		                System.out.println("Update cancelled.");
		                return;
		            }

	                java.io.File f = new java.io.File(path);
	                if (!f.exists())
	                    throw new InvalidFilePathException("File does not exist");

	                student.setResumePath(path);
	                student.getSkills().clear();   // clear old skills
	                student.readingFile();         // reload skills
	                break;

	            case 7:
	                System.out.print("Enter new expected salary: ");
	                double salary = Double.parseDouble(sc.nextLine());
	                if(salary < 0)
	                    throw new InvalidSalaryException("Invalid Salary");
	                System.out.print("Are you sure you want to update? (yes/no): ");
		            String confirm7 = sc.nextLine().trim().toLowerCase();
	
		            if(!confirm7.equals("yes")) {
		                System.out.println("Update cancelled.");
		                return;
		            }
	                student.setSalary(salary);
	                break;

	            default:
	                System.out.println("Invalid choice!");
	                return;
	        }

	        ApplicantDAO.updateApplicant(student);
	        System.out.println("Details updated successfully!");
	        student.show();

	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
}
