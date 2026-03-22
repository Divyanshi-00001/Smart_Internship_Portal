package smartinternshipportal.model;

import java.util.HashSet;

public class Job {

    private int jobId;
    private int companyId;
    private String title;
    private String location;
    private double minCgpa;
    private HashSet<String> requiredSkills = new HashSet<>();

    public Job(int jobId, int companyId, String title, String location, double minCgpa) {
        this.jobId = jobId;
        this.companyId = companyId;
        this.title = title;
        this.location = location;
        this.minCgpa = minCgpa;
    }

    public int getJobId() {
        return jobId;
    }

    public HashSet<String> getRequiredSkills() {
        return requiredSkills;
    }

    public void addRequiredSkill(String skill) {
        requiredSkills.add(skill);
    }

    public double getMinCgpa() {
        return minCgpa;
    }

    @Override
    public String toString() {
        return "Job ID: " + jobId + ", Title: " + title + ", Location: " + location + ", Min CGPA: " + minCgpa;
    }
}