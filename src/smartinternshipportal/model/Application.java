package smartinternshipportal.model;

public class Application {

    private int applicationId;
    private int studentId;
    private int jobId;
    private String status;

    // Default Constructor
    public Application() {}

    // Parameterized Constructor
    public Application(int applicationId, int studentId, int jobId, String status) {
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.jobId = jobId;
        this.status = status;
    }

    // Getters and Setters

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application ID: " + applicationId + ", Student ID: " + studentId + ", Job ID: " + jobId + ", Status: " + status;
    }
}