package smartinternshipportal.main;

import smartinternshipportal.algorithms.RecommendationEngine;
import smartinternshipportal.model.*;

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
	
	public static void BeforeStudentLogin() {
		Scanner sr = new Scanner(System.in);
		System.out.print("Enter Email: ");
	    String semail = sr.nextLine();
	    
	    System.out.print("Enter Password: ");
	    String spass = sr.nextLine();
	    
	    Student loggedStudent = studentLogin(semail, spass);
	    
	    if(loggedStudent != null) {
	        System.out.println("Login Successful!");
	        loggedStudent.show();
	    } else {
	        System.out.println("Invalid Credentials!");
	    }
	}
	
	public static void PowersAfterLogin() {
		
	}
	
	public static void SignUpResizeMainArrays() {
		MainApp.Snum++;
		if(MainApp.Snum>=MainApp.ss.length)
			MainApp.ss = Arrays.copyOf(MainApp.ss,(MainApp.ss.length+MainApp.ss.length));
		StudentModule sm = new StudentModule();
		Student st = sm.CreateStudents();
		if (st != null) {
			MainApp.ss[MainApp.Snum] = st;
		} else {
			MainApp.Snum--;
		}
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
			List<Map.Entry<Job, Double>> recommended = RecommendationEngine.recommendJobs(MainApp.ss[i], jobList);

	        System.out.println("Recommended Jobs:");
	        for (Map.Entry<Job, Double> jb : recommended) {
	        	System.out.println("Score: "+jb.getValue());
	            jb.getKey().show();
	        }
	    } else {
	        System.out.println("No data available!");
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
	
	public Student CreateStudents() {
		Scanner sr=new Scanner(System.in);
		try {
			System.out.print("Enter Name: ");
			String name = sr.nextLine();

			System.out.print("Enter Email: ");
			String email = sr.nextLine();

			System.out.print("Enter Password: ");
			String password = sr.nextLine();

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
			if (password.length()<8)
	            throw new InvalidPasswordException("Weak Password");
			if(cgpa>10 || cgpa<0)
				throw new InvalidCgpaException("Invalid Cgpa");
			if (!resumePath.endsWith(".txt"))
			    throw new InvalidFilePathException("Resume must be .txt file");
			if(salary<0)
				throw new InvalidSalaryException("Invalid Salary");
			return new Student(name,email,password,cgpa,resumePath,salary);
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
            System.out.println("Try again...\n");
		}
		return null;
	}
}
