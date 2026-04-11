package smartinternshipportal.main;

import java.util.Scanner;
import smartinternshipportal.model.Job;
import smartinternshipportal.model.Student;
import smartinternshipportal.model.Admin;
import smartinternshipportal.model.Application;

public class AdminModule {
	
	public static void Authentication() {
		AdminModule am = new AdminModule();
		if(am.CreateAdmin()) {
			am.show();
		}
	}
	
	public boolean CreateAdmin() {
		int id;
		String name;
		String password;
		Scanner sr = new Scanner(System.in);
		try {
			System.out.print("Enter Admin id: ");
			id = Integer.parseInt(sr.nextLine());
			System.out.print("Enter Admin name: ");
			name = sr.nextLine();
			System.out.print("Enter Admin password: ");
			password = sr.nextLine();
			Admin adm = new Admin(id,name,password);
			return adm.Authentication();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		sr.close();
		return false;
	}	
	
	public void show() {
		if(MainApp.Jnum>0) System.out.println("---------Company-Job Details---------");
		else {System.out.println("No company records found !!");}
		for(int i=0;i<MainApp.jj.length;i++) {
			if(MainApp.jj[i] != null) {
				MainApp.jj[i].show();
				System.out.println("-------------------------------------");
			}
		}
		if(MainApp.Jnum>0) System.out.println("-------------------------------------\n");
		if(MainApp.Snum>0) System.out.println("-----------Student Details-----------");
		else {System.out.println("No Student records found !!");}
		for(int i=0;i<MainApp.ss.length;i++) {
			if(MainApp.ss[i] != null) {
				MainApp.ss[i].show();
				System.out.println("-------------------------------------");
			}
		}
		if(MainApp.Snum>-1) System.out.println("-------------------------------------");
		if(MainApp.Anum>-1) System.out.println("-----------Applications-----------");
		else {System.out.println("No Application records found !!");}
		for(int i = 0; i <= MainApp.Anum; i++) {
		    if(MainApp.aa[i] != null) {
		        System.out.println("App ID: " + MainApp.aa[i].getApplicationId());
		        System.out.println("Student ID: " + MainApp.aa[i].getStudentId());
		        System.out.println("Job ID: " + MainApp.aa[i].getJobId());
		        System.out.println("Status: " + MainApp.aa[i].getStatus());
		        System.out.println("-------------------------------------");
		    }
		}
		if(MainApp.Anum>-1) System.out.println("-------------------------------------");
	}
}
