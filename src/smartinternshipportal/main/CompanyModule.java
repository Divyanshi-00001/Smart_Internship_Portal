package smartinternshipportal.main;

import smartinternshipportal.algorithms.CoRecommendationEngine;
import smartinternshipportal.model.*;

import java.util.*;

//class InvalidNameException extends Exception {
//    public InvalidNameException(String msg) 
//    { 
//    	super(msg); 
//    }
//}
//
//class InvalidEmailException extends Exception {
//    public InvalidEmailException(String msg) { 
//    	super(msg); 
//    }
//}
//
//class InvalidPasswordException extends Exception {
//    public InvalidPasswordException(String msg) { 
//    	super(msg); 
//    }
//}

class InvalidTitleException extends Exception {
    public InvalidTitleException(String msg) { 
    	super(msg); 
    }
}

class InvalidLocationException extends Exception {
    public InvalidLocationException(String msg) { 
    	super(msg); 
    }
}
//
//class InvalidSalaryException extends Exception {
//    public InvalidSalaryException(String msg) { 
//    	super(msg); 
//    }
//}
//
//class InvalidCgpaException extends Exception {
//    public InvalidCgpaException(String msg) { 
//    	super(msg); 
//    }
//}

public class CompanyModule {
	
	public static void BeforeCompanyLogin() {
		Scanner sr=new Scanner(System.in);
		System.out.print("Enter Email: ");
	    String cemail = sr.nextLine();

	    System.out.print("Enter Password: ");
	    String cpass = sr.nextLine();

	    Job loggedCompany = CompanyModule.companyLogin(cemail, cpass);

	    if(loggedCompany != null) {
	        System.out.println("Login Successful!");
	        loggedCompany.show();
	    } else {
	        System.out.println("Invalid Credentials!");
	    }
	}
	
	public static void PowersAfterLogin() {
		
	}
	
	public static void SignUpResizeMainArrays() {
		MainApp.Jnum++;
		if(MainApp.Jnum>=MainApp.jj.length)
			MainApp.jj = Arrays.copyOf(MainApp.jj,(MainApp.jj.length+MainApp.jj.length));
		CompanyModule cm = new CompanyModule();
		Job job = cm.CreateJob();
		if (job != null) {
			MainApp.jj[MainApp.Jnum] = job;
		} else {
			MainApp.Jnum--; // rollback
		}
	}
	
	public static void RecommendStudents() {
		Scanner sr = new Scanner(System.in);
		if (MainApp.Snum >= 0 && MainApp.Jnum >= 0) {
			List<Student> studentList = new ArrayList<>();
			for(int i = 0; i <= MainApp.Snum; i++) {
			    if(MainApp.ss[i] != null) {
			        studentList.add(MainApp.ss[i]);
			    }
			}
			System.out.print("Enter Job Id: ");
			String id = sr.nextLine();
			int i;
			for(i = 0; i <= MainApp.Jnum; i++) {
			    if(MainApp.jj[i] != null && id.equals(MainApp.jj[i].getJobId())) {
			        break;
			    }
			}
			if(i > MainApp.Jnum) {
			    System.out.println("Job not found!");
			    return;
			}
			List<Map.Entry<Student, Double>> recommended = CoRecommendationEngine.recommendJobs(MainApp.jj[i], studentList);

	        System.out.println("Recommended Students:");
	        for (Map.Entry<Student, Double> s : recommended) {
	        	System.out.println("Score: "+s.getValue());
	            s.getKey().show();
	        }
	    } else {
	        System.out.println("No data available!");
	    }
	}
	
	public static Job companyLogin(String email, String password) {
	    for(int i = 0; i <= MainApp.Jnum; i++) {
	        if(MainApp.jj[i] != null &&
	           MainApp.jj[i].getEmail().equals(email) &&
	           MainApp.jj[i].getPassword().equals(password)) {
	            return MainApp.jj[i];
	        }
	    }
	    return null;
	}
	
	public Job CreateJob() {
		Scanner sr=new Scanner(System.in);
		try {
			System.out.print("Enter Company Name: ");
			String companyName = sr.nextLine();

			System.out.print("Enter Email: ");
			String email = sr.nextLine();

			System.out.print("Enter Password: ");
			String password = sr.nextLine();

			System.out.print("Enter Job Title: ");
			String title = sr.nextLine();

			System.out.print("Enter Location: ");
			String location = sr.nextLine();

			System.out.print("Enter Salary: ");
			double salary = Double.parseDouble(sr.nextLine());

			System.out.print("Enter Minimum CGPA: ");
			double cgpa = Double.parseDouble(sr.nextLine());
			
			HashSet<String> skills= new HashSet<>();
			while (true) {
			    System.out.print("Enter skills: ");
			    String sk = sr.nextLine();
			    skills.add(sk);

			    System.out.print("Add more skills? (yes/no): ");
			    String choice = sr.nextLine();

			    if (!choice.equalsIgnoreCase("yes")) {
			        break;
			    }
			}
			
			if (companyName.isEmpty())
	            throw new InvalidNameException("Name cannot be empty");
			if (!email.contains("@") || !email.contains("."))
			    throw new InvalidEmailException("Invalid Email");
			if (password.length()<8)
	            throw new InvalidPasswordException("Weak Password");
			if (title.isEmpty())
	            throw new InvalidTitleException("Invalid Title");
			if (location.isEmpty())
				throw new InvalidLocationException("Invalid Location");
			if(salary<0)
				throw new InvalidSalaryException("Invalid Salary");
			if(cgpa<0 || cgpa>10)
				throw new InvalidCgpaException("Invalid Cgpa");
			Job jb = new Job( companyName, email, password, title, location, salary, cgpa, skills);
			return jb;
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
            System.out.println("Try again...\n");
		}
		return null;
	}
}





