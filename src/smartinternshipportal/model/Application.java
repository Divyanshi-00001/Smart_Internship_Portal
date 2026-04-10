package smartinternshipportal.model;

public class Application {
	private String applicationId;
	private static int id_no=1000;
	private String studentId;
	private String jobId;
	private boolean status=false;
	
	public Application(String studentId, String jobId) {
		id_no++;
		applicationId="App:"+id_no;
		status=true;
		this.studentId=studentId;
		this.jobId=jobId;
	}
	
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId() {
		applicationId="App:"+id_no;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String id) {
		studentId = id;
	}
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String id) {
		jobId = id;
	}
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean st) {
		status = st;
	}
}
