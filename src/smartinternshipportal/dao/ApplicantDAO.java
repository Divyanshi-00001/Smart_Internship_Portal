package smartinternshipportal.dao;

import java.sql.*;
import java.util.Arrays;

import smartinternshipportal.main.MainApp;
import smartinternshipportal.model.Student;

public class ApplicantDAO {

	public static void getAllApplicants() throws Exception {

	    Connection con = DBConnectionDAO.getConnection();

	    String query = "SELECT * FROM Applicants";
	    PreparedStatement ps = con.prepareStatement(query);
	    ResultSet rs = ps.executeQuery();

	    while(rs.next()) {
	        String id = rs.getString("student_id");
	        String name = rs.getString("name");
	        String email = rs.getString("email");
	        String pass = rs.getString("password");
	        String qual = rs.getString("qualification");
	        double cgpa = rs.getDouble("cgpa");
	        String resume = rs.getString("resume_path");
	        double salary = rs.getDouble("expected_salary");

	        MainApp.Snum++;
			if(MainApp.Snum>=MainApp.ss.length)
				MainApp.ss = Arrays.copyOf(MainApp.ss,(MainApp.ss.length+MainApp.ss.length));	
			Student s = new Student(name,email,pass,qual,cgpa,resume,salary);
			if (s != null) {
				MainApp.ss[MainApp.Snum] = s;
			} else {
				MainApp.Snum--;
			}
	    }

	    con.close();
	}
	
    public static void insertApplicant(Student s) throws Exception {
        Connection con = DBConnectionDAO.getConnection();

        String query = "INSERT INTO Applicants VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, s.getStudentID());
        ps.setString(2, s.getName());
        ps.setString(3, s.getEmail());
        ps.setString(4, s.getPassword());
        ps.setString(5, s.getQualification());
        ps.setDouble(6, s.getCgpa());
        ps.setString(7, s.getResumePath());
        ps.setDouble(8, s.getSalary());

        ps.executeUpdate();

        con.close();
    }

    public static void updateApplicant(Student s) throws Exception {
        Connection con = DBConnectionDAO.getConnection();

        String query = "UPDATE Applicants SET name=?, email=?, password=?, qualification=?, cgpa=?, resume_path=?, expected_salary=? WHERE student_id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getPassword());
        ps.setString(4, s.getQualification());
        ps.setDouble(5, s.getCgpa());
        ps.setString(6, s.getResumePath());
        ps.setDouble(7, s.getSalary());
        ps.setString(8, s.getStudentID());

        ps.executeUpdate();

        con.close();
    }
}