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
	        PowersAfterLogin(loggedCompany);
	    } else {
	        System.out.println("Invalid Credentials!");
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
	
	public static void PowersAfterLogin(Job job) {
	    Scanner sc = new Scanner(System.in);
	    int choice;

	    do {
	        System.out.println("\n1. View Job");
	        System.out.println("2. Recommend Students");
	        System.out.println("3. Update Job Details");
	        System.out.println("4. Logout");
	        System.out.print("Enter choice: ");

	        choice = Integer.parseInt(sc.nextLine());

	        switch(choice) {
	            case 1:
	                job.show();
	                break;

	            case 2:
	                RecommendStudents();
	                break;

	            case 3:
	                updateJob(job);
	                break;

	            case 4:
	                System.out.println("Logged out successfully!");
	                break;

	            default:
	                System.out.println("Invalid choice!");
	        }
	    } while(choice != 4);
	}
	
	public static void updateJob(Job job) {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n--- Update Job Details ---");
	    System.out.println("1. Update Company Name");
	    System.out.println("2. Update Email");
	    System.out.println("3. Update Password");
	    System.out.println("4. Update Job Title");
	    System.out.println("5. Update Location");
	    System.out.println("6. Update Salary");
	    System.out.println("7. Update CGPA");
	    System.out.println("8. Update Skills");

	    System.out.print("Enter choice: ");
	    int choice = Integer.parseInt(sc.nextLine());

	    try {
	        switch(choice) {

	            case 1:
	                System.out.print("Enter new company name: ");
	                String name = sc.nextLine();

	                if(name.isEmpty())
	                    throw new InvalidNameException("Name cannot be empty");

	                if(!confirm(sc)) return;

	                job.setCompanyName(name);
	                break;

	            case 2:
	                System.out.print("Enter new email: ");
	                String email = sc.nextLine().trim();

	                if (!email.contains("@") || !email.contains("."))
	                    throw new InvalidEmailException("Invalid Email");

	                // 🔴 Duplicate email check
	                for(int i = 0; i <= MainApp.Jnum; i++) {
	                    if(MainApp.jj[i] != null &&
	                       MainApp.jj[i].getEmail().equals(email) &&
	                       MainApp.jj[i] != job) {

	                        throw new InvalidEmailException("Email already exists!");
	                    }
	                }

	                if(!confirm(sc)) return;

	                job.setEmail(email);
	                break;

	            case 3:
	                System.out.print("Enter new password: ");
	                String pass = sc.nextLine();

	                if(pass.length() < 8)
	                    throw new InvalidPasswordException("Weak Password");

	                if(!confirm(sc)) return;

	                job.setPassword(pass);
	                break;

	            case 4:
	                System.out.print("Enter new job title: ");
	                String title = sc.nextLine();

	                if(title.isEmpty())
	                    throw new InvalidTitleException("Invalid Title");

	                if(!confirm(sc)) return;

	                job.setTitle(title);
	                break;

	            case 5:
	                System.out.print("Enter new location: ");
	                String loc = sc.nextLine();

	                if(loc.isEmpty())
	                    throw new InvalidLocationException("Invalid Location");

	                if(!confirm(sc)) return;

	                job.setLocation(loc);
	                break;

	            case 6:
	                System.out.print("Enter new salary: ");
	                double sal = Double.parseDouble(sc.nextLine());

	                if(sal < 0)
	                    throw new InvalidSalaryException("Invalid Salary");

	                if(!confirm(sc)) return;

	                job.setSalary(sal);
	                break;

	            case 7:
	                System.out.print("Enter new CGPA: ");
	                double cgpa = Double.parseDouble(sc.nextLine());

	                if(cgpa < 0 || cgpa > 10)
	                    throw new InvalidCgpaException("Invalid CGPA");

	                if(!confirm(sc)) return;

	                job.setMinCgpa(cgpa);
	                break;

	            case 8:
	                HashSet<String> skills = new HashSet<>();

	                while(true) {
	                    System.out.print("Enter skill: ");
	                    skills.add(sc.nextLine().toLowerCase());

	                    System.out.print("Add more? (yes/no): ");
	                    if(!sc.nextLine().equalsIgnoreCase("yes")) break;
	                }

	                if(!confirm(sc)) return;

	                job.setRequiredSkill(skills);
	                break;

	            default:
	                System.out.println("Invalid choice!");
	                return;
	        }

	        System.out.println("Updated successfully!");
	        job.show();

	    } catch(Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
	
	public static boolean confirm(Scanner sc) {
	    System.out.print("Are you sure? (yes/no): ");
	    String confirm = sc.nextLine().trim().toLowerCase();

	    if(!confirm.equals("yes")) {
	        System.out.println("Update cancelled.");
	        return false;
	    }
	    return true;
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
	
}





