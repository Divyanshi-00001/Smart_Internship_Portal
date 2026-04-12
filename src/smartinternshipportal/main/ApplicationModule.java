package smartinternshipportal.main;

import java.util.Arrays;
import java.util.Scanner;

import smartinternshipportal.model.Application;

public class ApplicationModule {
	public static void ApplicationsWorking() {
		Scanner sr = new Scanner(System.in);
		if (MainApp.Snum >= 0 && MainApp.Jnum >= 0) {
			
//	        System.out.println("---------Available Jobs---------");
//	        for(int i = 0; i <= MainApp.Jnum; i++) {
//	            if(MainApp.jj[i] != null) {
//	            	MainApp.jj[i].show();
//	            }
//	        }

	        System.out.print("Enter Student ID: ");
	        String sid = sr.nextLine();

	        System.out.print("Enter Job ID: ");
	        String jid = sr.nextLine();

	        // Check student exists
	        boolean studentFound = false;
	        for(int i = 0; i <= MainApp.Snum; i++) {
	            if(MainApp.ss[i] != null && sid.equals(MainApp.ss[i].getStudentID())) {
	                studentFound = true;
	                break;
	            }
	        }

	        // Check job exists
	        String ApplyLink = "";
	        boolean jobFound = false;
	        for(int i = 0; i <= MainApp.Jnum; i++) {
	            if(MainApp.jj[i] != null && jid.equals(MainApp.jj[i].getJobId())) {
	            	ApplyLink = MainApp.jj[i].getWebLink();
	                jobFound = true;
	                break;
	            }
	        }

	        if(!studentFound) {
	            System.out.println("Invalid Student ID!");
	            return;
	        }

	        if(!jobFound) {
	            System.out.println("Invalid Job ID!");
	            return;
	        }
	        
	        for (int i = 0; i <= MainApp.Anum; i++) {
	            if (MainApp.aa[i] != null &&
	                MainApp.aa[i].getStudentId().equals(sid) &&
	                MainApp.aa[i].getJobId().equals(jid)) {

	                System.out.println("Already applied for this job!");
	                return;
	            }
	        }

	        // Resize array if needed
	        MainApp.Anum++;
	        if(MainApp.Anum >= MainApp.aa.length) {
	        	MainApp.aa = Arrays.copyOf(MainApp.aa, MainApp.aa.length * 2);
	        }

	        MainApp.aa[MainApp.Anum] = new Application(sid, jid);

	        System.out.println("\nApplication submitted successfully!!!\n");
	        System.out.println("Apply on: "+ApplyLink);
	        System.out.println("Application ID: " + MainApp.aa[MainApp.Anum].getApplicationId());

	    } else {
	        System.out.println("No students or jobs available!");
	    }
	}
}
