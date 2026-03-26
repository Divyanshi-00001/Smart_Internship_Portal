package smartinternshipportal.main;

import smartinternshipportal.model.*;
import smartinternshipportal.algorithms.*;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Role:");
        System.out.println("a → Admin");
        System.out.println("b → Student + Recommendation Demo");

        char choice = sc.next().charAt(0);

        switch (choice) {

            // ================= ADMIN LOGIN =================
            case 'a':
                Admin admin = new Admin();

                System.out.println("Enter Admin ID:");
                int id = sc.nextInt();

                System.out.println("Enter Username:");
                String username = sc.next();

                System.out.println("Enter Password:");
                String password = sc.next();

                admin.getId(id);
                admin.getName(username);
                admin.getPassword(password); // (your code uses this incorrectly but kept same)

                if (admin.Authentication()) {
                    System.out.println("✅ Admin Login Successful");
                } else {
                    System.out.println("❌ Invalid Credentials");
                }
                break;

            // ================= STUDENT + RECOMMENDATION =================
            case 'b':

                // ---------- CREATE STUDENT ----------
                Student stu = new Student();
                stu.setStudentID(1);

                System.out.println("Enter Student Name:");
                stu.setName(sc.next());

                System.out.println("Enter CGPA:");
                stu.setCgpa(sc.nextDouble());

                System.out.println("Enter Expected Salary:");
                stu.setSalary(sc.nextDouble());

                // Skills input
                System.out.println("Enter number of skills:");
                int n = sc.nextInt();
                HashSet<String> stuSkills = new HashSet<>();

                System.out.println("Enter skills:");
                for (int i = 0; i < n; i++) {
                    stuSkills.add(sc.next());
                }
                stu.addSkill(stuSkills);

                // ---------- CREATE COMPANY ----------
                Company company = new Company();

                System.out.println("Enter Company Name:");
                company.setCompanyName(sc.next());
                company.setCompanyId();

                // ---------- ADD JOB ----------
                System.out.println("Enter Job Title:");
                String title = sc.next();

                System.out.println("Enter Job Location:");
                String location = sc.next();

                System.out.println("Enter Job Salary:");
                double salary = sc.nextDouble();

                System.out.println("Enter Minimum CGPA:");
                double minCgpa = sc.nextDouble();

                System.out.println("Enter number of required skills:");
                int m = sc.nextInt();
                HashSet<String> jobSkills = new HashSet<>();

                System.out.println("Enter required skills:");
                for (int i = 0; i < m; i++) {
                    jobSkills.add(sc.next());
                }

                company.addJob(title, location, salary, minCgpa, jobSkills);

                // ---------- STORE COMPANY ----------
                HashSet<Company> companies = new HashSet<>();
                companies.add(company);

                // ---------- RUN RECOMMENDATION ----------
                RecommendationEngine engine = new RecommendationEngine();

                System.out.println("\n🔍 RECOMMENDED JOBS:\n");
                engine.recommend(companies, stu);

                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}