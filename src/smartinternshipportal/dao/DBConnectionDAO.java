package smartinternshipportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/RecommendationDB";
    private static final String USER = "anshi";
    private static final String PASS = "1234";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}