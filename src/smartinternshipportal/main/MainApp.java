package smartinternshipportal.main;

import smartinternshipportal.model.Student;
import smartinternshipportal.model.Job;
import smartinternshipportal.algorithms.RecommendationEngine;
// import java.util.ArrayList;
// import java.util.List;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        // Create Student
        Student student = new Student();
        student.setStudentId(1);
        student.setName("Divyanshi");
        student.setCgpa(8.5);
        
        student.addSkill("Java");
        student.addSkill("DSA");
        student.addSkill("MySQL");

        // Create Jobs
        List<Job> jobs = new ArrayList<>();

        Job job1 = new Job(1, 101, "Java Developer", "Delhi", 7.0);
        job1.addRequiredSkill("Java");
        job1.addRequiredSkill("Spring");
        job1.addRequiredSkill("MySQL");

        Job job2 = new Job(2, 102, "Data Analyst", "Mumbai", 6.5);
        job2.addRequiredSkill("Python");
        job2.addRequiredSkill("SQL");

        Job job3 = new Job(3, 103, "Backend Developer", "Bangalore", 7.5);
        job3.addRequiredSkill("Java");
        job3.addRequiredSkill("DSA");

        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);

        // Get Recommendations
        List<Job> recommendedJobs = RecommendationEngine.recommendJobs(student, jobs);

        // Print Results
        System.out.println("Recommended Jobs:");

        for (Job job : recommendedJobs) {
            System.out.println(job);
        }
    }
}