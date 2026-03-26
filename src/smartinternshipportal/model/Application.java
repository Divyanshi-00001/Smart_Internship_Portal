package smartinternshipportal.model;

public class Application {
	private String applicationId;
	private static int id_no=100;
	private int studentId;
	private int jobId;
	private String status;
	
	public Application() {
		id_no++;
	}
	
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId() {
		applicationId="Application"+id_no;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int id) {
		studentId = id;
	}
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int id) {
		jobId = id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String st) {
		// Pending, Accepted & Rejected.
		status = st;
	}
}
