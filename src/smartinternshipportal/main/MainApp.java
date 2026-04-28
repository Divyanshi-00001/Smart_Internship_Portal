package smartinternshipportal.main;

import smartinternshipportal.ui.MainMenuUI;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import smartinternshipportal.dao.JobDAO;
import smartinternshipportal.dao.ApplicantDAO;
import smartinternshipportal.dao.ApplicationDAO;
import smartinternshipportal.model.Admin;
import smartinternshipportal.model.Job;
import smartinternshipportal.model.Application;
import smartinternshipportal.model.Student;
import smartinternshipportal.algorithms.CoRecommendationEngine;
import smartinternshipportal.algorithms.RecommendationEngine;

public class MainApp {
	
	public static Job jj[] = new Job[10];
	public static int Jnum=-1;
	public static Student ss[] = new Student[10];
	public static int Snum=-1;
	public static Application aa[] = new Application[10];
	public static int Anum=-1;
	
	public static void main(String[] args) throws Exception {
		
		ApplicantDAO.getAllApplicants();
		ApplicationDAO.getAllApplications();
		JobDAO.getAllJobs();
		
		new MainMenuUI();
	
		java.util.Scanner sr = new java.util.Scanner(System.in);
		int n;
		while(true) {
			System.out.print("\n----------MENU----------\n\n"+
					"1: Admin Login\n" +
					"2: Student Signup\n" +
					"3: Student Login\n" +
					"4: Company Signup\n" +
					"5: Company Login\n\n" +
					"Enter your Choice: "
					);
			n = sr.nextInt();
			sr.nextLine();
			switch(n) {
				case 1: AdminModule.Authentication();
						break;
				case 2: StudentModule.SignUpResizeMainArrays();
						break;
				case 3: StudentModule.BeforeStudentLogin();
					    break;
				case 4: CompanyModule.SignUpResizeMainArrays();
						break;
				case 5: CompanyModule.BeforeCompanyLogin();
					    break;
				default: System.out.println("\nInvalid Choice !!!... Please try again later...");
			}
			
			System.out.print("\nDo you want to Exit: (Yes/No)");
		    String choice = sr.nextLine();
		    if (choice.equalsIgnoreCase("yes")) {
		        break;
		    }
		}
	}

}
