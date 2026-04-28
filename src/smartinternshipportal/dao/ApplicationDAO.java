package smartinternshipportal.dao;

import java.sql.*;
import java.util.Arrays;

import smartinternshipportal.main.MainApp;
import smartinternshipportal.model.Application;

public class ApplicationDAO {

	public static void getAllApplications() throws Exception {
	    Connection con = DBConnectionDAO.getConnection();

	    String query = "SELECT * FROM Applications";
	    PreparedStatement ps = con.prepareStatement(query);
	    ResultSet rs = ps.executeQuery();

	    while(rs.next()) {
	        String sid = rs.getString("student_id");
	        String jid = rs.getString("job_id");

	        MainApp.Anum++;
	        if(MainApp.Anum >= MainApp.aa.length) {
	        	MainApp.aa = Arrays.copyOf(MainApp.aa, MainApp.aa.length * 2);
	        }

	        MainApp.aa[MainApp.Anum] = new Application(sid, jid);
	    }

	    con.close();
	}

    public static void insertApplication(Application a) throws Exception {
        Connection con = DBConnectionDAO.getConnection();

        String query = "INSERT INTO Applications(student_id, job_id) VALUES(?,?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, a.getStudentId());
        ps.setString(2, a.getJobId());

        ps.executeUpdate();
        con.close();
    }

}