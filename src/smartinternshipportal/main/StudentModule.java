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
	
	public static void PowersAfterLogin(Student loggedStudent) {
	    Scanner sc = new Scanner(System.in);
	    int choice;

	    do {
	        System.out.println("\n1. View Profile");
	        System.out.println("2. Get Job Recommendations");
	        System.out.println("3. Update Credentials");
	        System.out.println("4. Logout");
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
	                updateCredentials(loggedStudent);
	                break;

	            case 4:
	                System.out.println("Logged out successfully!");
	                break;

	            default:
	                System.out.println("Invalid choice!");
	        }
	    } while(choice != 4);
	}
	
	public static void updateCredentials(Student student) {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("\n--- Update Credentials ---");
	    System.out.println("1. Update Name");
	    System.out.println("2. Update Email");
	    System.out.println("3. Update Password");
	    System.out.println("4. Update CGPA");
	    System.out.println("5. Update Resume");
	    System.out.println("6. Update Expected Salary");
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
	                student.setPassword(password);
	                break;

	            case 4:
	                System.out.print("Enter new CGPA: ");
	                double cgpa = Double.parseDouble(sc.nextLine());
	                if(cgpa < 0 || cgpa > 10)
	                    throw new InvalidCgpaException("Invalid CGPA");
	                student.setCgpa(cgpa);
	                break;

	            case 5:
	                System.out.print("Enter new resume path: ");
	                String path = sc.nextLine();

	                if (!path.endsWith(".txt"))
	                    throw new InvalidFilePathException("Resume must be .txt file");

	                java.io.File f = new java.io.File(path);
	                if (!f.exists())
	                    throw new InvalidFilePathException("File does not exist");

	                student.setResumePath(path);
	                student.getSkills().clear();   // clear old skills
	                student.readingFile();         // reload skills
	                break;

	            case 6:
	                System.out.print("Enter new expected salary: ");
	                double salary = Double.parseDouble(sc.nextLine());
	                if(salary < 0)
	                    throw new InvalidSalaryException("Invalid Salary");
	                student.setSalary(salary);
	                break;

	            default:
	                System.out.println("Invalid choice!");
	                return;
	        }

	        System.out.println("Details updated successfully!");
	        student.show();

	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
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
}
