package smartinternshipportal.dao;

import java.sql.*;

import smartinternshipportal.main.MainApp;
import smartinternshipportal.model.Job;

public class JobDAO {

	public static void getAllJobs() throws Exception {

	    Connection con = DBConnectionDAO.getConnection();

	    String query = "SELECT * FROM Jobs";
	    PreparedStatement ps = con.prepareStatement(query);
	    ResultSet rs = ps.executeQuery();

	    while(rs.next()) {
	        String jobId = rs.getString("job_id");
	        String name = rs.getString("company_name");
	        String email = rs.getString("email");
	        String pass = rs.getString("password");
	        String title = rs.getString("title");
	        String loc = rs.getString("location");
	        double sal = rs.getDouble("salary");
	        String qual = rs.getString("qualification");
	        double cgpa = rs.getDouble("min_cgpa");
	        String link = rs.getString("web_link");

	        java.util.HashSet<String> skills = new java.util.HashSet<>();

	        // Fetch skills
	        PreparedStatement ps2 = con.prepareStatement("SELECT skill FROM JobSkills WHERE job_id=?");
	        ps2.setString(1, jobId);

	        ResultSet rs2 = ps2.executeQuery();
	        while(rs2.next()){
	            skills.add(rs2.getString("skill"));
	        }

	        MainApp.Jnum++;
    	    if(MainApp.Jnum >= MainApp.jj.length){
    	        MainApp.jj = java.util.Arrays.copyOf(MainApp.jj, MainApp.jj.length * 2);
    	    }

    	    MainApp.jj[MainApp.Jnum] = new Job( name, email, pass, title, loc, sal, qual, cgpa, link, skills);
	    }

	    con.close();
	}

    public static void insertJob(Job j) throws Exception {
        Connection con = DBConnectionDAO.getConnection();

        String query = "INSERT INTO Jobs VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, j.getJobId());
        ps.setString(2, j.getCompanyName());
        ps.setString(3, j.getEmail());
        ps.setString(4, j.getPassword());
        ps.setString(5, j.getTitle());
        ps.setString(6, j.getLocation());
        ps.setDouble(7, j.getSalary());
        ps.setString(8, j.getQualification());
        ps.setDouble(9, j.getMinCgpa());
        ps.setString(10, j.getWebLink());

        ps.executeUpdate();

        for(String skill : j.getRequiredSkills()){
            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO JobSkills VALUES(?,?)"
            );
            ps2.setString(1, j.getJobId());
            ps2.setString(2, skill);
            ps2.executeUpdate();
        }

        con.close();
    }

    public static void updateJob(Job j) throws Exception {
        Connection con = DBConnectionDAO.getConnection();

        String query = "UPDATE Jobs SET company_name=?, email=?, password=?, title=?, location=?, salary=?, qualification=?, min_cgpa=?, web_link=? WHERE job_id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, j.getCompanyName());
        ps.setString(2, j.getEmail());
        ps.setString(3, j.getPassword());
        ps.setString(4, j.getTitle());
        ps.setString(5, j.getLocation());
        ps.setDouble(6, j.getSalary());
        ps.setString(7, j.getQualification());
        ps.setDouble(8, j.getMinCgpa());
        ps.setString(9, j.getWebLink());
        ps.setString(10, j.getJobId());

        ps.executeUpdate();

        con.close();
    }
}