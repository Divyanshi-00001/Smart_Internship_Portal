package smartinternshipportal.main;

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
	
	public StudentModule() {
		
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
