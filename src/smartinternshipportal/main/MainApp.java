package smartinternshipportal.main;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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
	
	public static void main(String[] args) throws Exception {
	
		java.util.Scanner sr = new java.util.Scanner(System.in);
		int n;
		while(true) {
			System.out.print("\n----------MENU----------\n\n"+
					"1: Admin Login\n" +
					"2: Student Signup\n" +
					"3: Student Login\n" +
					"4: Company Signup\n" +
					"5: Company Login\n" +
					"6: Recommend Jobs\n" +
					"7: Recommend Students\n" +
					"8: Apply for Job\n\n"+
					"Enter your Choice: "
					);
			n = sr.nextInt();
			sr.nextLine();
			switch(n) {
				case 1: AdminModule am = new AdminModule();
						if(am.CreateAdmin()) {
							if(Jnum>0) System.out.println("---------Company-Job Details---------");
							else {System.out.println("No company records found !!");}
							for(int i=0;i<jj.length;i++) {
								if(jj[i] != null) {
									jj[i].show();
									System.out.println("-------------------------------------");
								}
							}
							if(Jnum>0) System.out.println("-------------------------------------\n");
							if(Snum>0) System.out.println("-----------Student Details-----------");
							else {System.out.println("No Student records found !!");}
							for(int i=0;i<ss.length;i++) {
								if(ss[i] != null) {
									ss[i].show();
									System.out.println("-------------------------------------");
								}
							}
							if(Snum>-1) System.out.println("-------------------------------------");
							if(Anum>-1) System.out.println("-----------Applications-----------");
							else {System.out.println("No Application records found !!");}
							for(int i = 0; i <= Anum; i++) {
							    if(aa[i] != null) {
							        System.out.println("App ID: " + aa[i].getApplicationId());
							        System.out.println("Student ID: " + aa[i].getStudentId());
							        System.out.println("Job ID: " + aa[i].getJobId());
							        System.out.println("Status: " + aa[i].getStatus());
							        System.out.println("-------------------------------------");
							    }
							}
							if(Anum>-1) System.out.println("-------------------------------------");
						}
						break;
				case 2: Snum++;
						if(Snum>=ss.length)
							ss = Arrays.copyOf(ss,(ss.length+ss.length));
						StudentModule sm = new StudentModule();
						Student st = sm.CreateStudents();
						if (st != null) {
						    ss[Snum] = st;
						} else {
						    Snum--;
						}
						break;
				case 3: System.out.print("Enter Email: ");
					    String semail = sr.nextLine();
	
					    System.out.print("Enter Password: ");
					    String spass = sr.nextLine();
	
					    Student loggedStudent = studentLogin(semail, spass);
	
					    if(loggedStudent != null) {
					        System.out.println("✅ Login Successful!");
					        loggedStudent.show();
					    } else {
					        System.out.println("❌ Invalid Credentials!");
					    }
					    break;
				case 4: Jnum++;
						if(Jnum>=jj.length)
							jj = Arrays.copyOf(jj,(jj.length+jj.length));
						CompanyModule cm = new CompanyModule();
						Job job = cm.CreateJob();
						if (job != null) {
						    jj[Jnum] = job;
						} else {
						    Jnum--; // rollback
						}
						break;
				case 5: System.out.print("Enter Email: ");
					    String cemail = sr.nextLine();
	
					    System.out.print("Enter Password: ");
					    String cpass = sr.nextLine();
	
					    Job loggedCompany = companyLogin(cemail, cpass);
	
					    if(loggedCompany != null) {
					        System.out.println("✅ Login Successful!");
					        loggedCompany.show();
					    } else {
					        System.out.println("❌ Invalid Credentials!");
					    }
					    break;
				case 6: if (Snum >= 0 && Jnum >= 0) {
							List<Job> jobList = new ArrayList<>();
							for(int i = 0; i <= Jnum; i++) {
							    if(jj[i] != null) {
							        jobList.add(jj[i]);
							    }
							}
							System.out.print("Enter Student Id: ");
							String id = sr.nextLine();
							int i;
							for(i = 0; i <= Snum; i++) {
							    if(ss[i] != null && id.equals(ss[i].getStudentID())) {
							        break;
							    }
							}
							if(i > Snum) {
							    System.out.println("Student not found!");
							    break;
							}
					        List<Job> recommended = RecommendationEngine.recommendJobs(ss[i], jobList);
	
					        System.out.println("Recommended Jobs:");
					        for (Job jb : recommended) {
					            jb.show();
					        }
					    } else {
					        System.out.println("No data available!");
					    }
					    break;
				case 7: if (Snum >= 0 && Jnum >= 0) {
							List<Student> studentList = new ArrayList<>();
							for(int i = 0; i <= Snum; i++) {
							    if(ss[i] != null) {
							        studentList.add(ss[i]);
							    }
							}
							System.out.print("Enter Job Id: ");
							String id = sr.nextLine();
							int i;
							for(i = 0; i <= Jnum; i++) {
							    if(jj[i] != null && id.equals(jj[i].getJobId())) {
							        break;
							    }
							}
							if(i > Jnum) {
							    System.out.println("Job not found!");
							    break;
							}
					        List<Student> recommended = CoRecommendationEngine.recommendJobs(jj[i], studentList);
	
					        System.out.println("Recommended Students:");
					        for (Student s : recommended) {
					            s.show();
					        }
					    } else {
					        System.out.println("No data available!");
					    }
					    break;
				case 8: if (Snum >= 0 && Jnum >= 0) {
	
					        System.out.println("---------Available Jobs---------");
					        for(int i = 0; i <= Jnum; i++) {
					            if(jj[i] != null) {
					                jj[i].show();
					                System.out.println("-------------------------------------");
					            }
					        }
	
					        System.out.print("Enter Student ID: ");
					        String sid = sr.nextLine();
	
					        System.out.print("Enter Job ID: ");
					        String jid = sr.nextLine();
	
					        // Check student exists
					        boolean studentFound = false;
					        for(int i = 0; i <= Snum; i++) {
					            if(ss[i] != null && sid.equals(ss[i].getStudentID())) {
					                studentFound = true;
					                break;
					            }
					        }
	
					        // Check job exists
					        boolean jobFound = false;
					        for(int i = 0; i <= Jnum; i++) {
					            if(jj[i] != null && jid.equals(jj[i].getJobId())) {
					                jobFound = true;
					                break;
					            }
					        }
	
					        if(!studentFound) {
					            System.out.println("Invalid Student ID!");
					            break;
					        }
	
					        if(!jobFound) {
					            System.out.println("Invalid Job ID!");
					            break;
					        }
	
					        // Resize array if needed
					        Anum++;
					        if(Anum >= aa.length) {
					            aa = Arrays.copyOf(aa, aa.length * 2);
					        }
	
					        aa[Anum] = new Application(sid, jid);
	
					        System.out.println("✅ Application submitted successfully!");
					        System.out.println("Application ID: " + aa[Anum].getApplicationId());
	
					    } else {
					        System.out.println("No students or jobs available!");
					    }
					    break;
				default: System.out.println("Invalid Choice !!! Please try again later...");
			}
			
			System.out.print("\nDo you want to Exit: (Yes/No)");
		    String choice = sr.nextLine();
		    if (choice.equalsIgnoreCase("yes")) {
		        break;
		    }
		}
	}

}
