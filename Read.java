package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Read  {


  private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/final";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "*******";
    private User user; 

    public static boolean userExists(int phone) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            con = getDBConnection();
            String query = "SELECT COUNT(*) FROM Employment_Application WHERE Phone = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, phone);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                exists = rs.getInt(1) > 0; // Check if count is greater than 0
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
            
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return exists;



    }

    public static Connection getDBConnection() {
        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return null; // Return null if driver not found
        }      

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            System.out.println("Connection Successful");
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
            return null; // Return null if connection fails
        }
    }

    public static void readData() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
          con = getDBConnection();
            con.setAutoCommit(false);

            String qry = "Select * From week9_labwork_rojhea";

            pstmt = con.prepareStatement(qry);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("First Name: " + rs.getString("First_Name"));
                System.out.println("Last Name: " + rs.getString("Last_Name"));
                System.out.println("Email: " + rs.getString("Email"));
                System.out.println("Website: " + rs.getString("Website"));
                System.out.println("Position: " + rs.getString("Position"));
                System.out.println("Salary: " + rs.getDouble("Salary"));
                System.out.println("Start Date: " + rs.getString("Start_Date"));
                System.out.println("Phone: " + rs.getInt("Phone"));
                System.out.println("Fax: " + rs.getInt("Fax"));
                System.out.println("Relocate: " + rs.getString("Relocate"));
                System.out.println("Previous Company: " + rs.getString("Prev_company"));
                System.out.println("Comments: " + rs.getString("Comments"));
                System.out.println("-----------------------------");
            }
            
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace(); // Print full stack trace for debugging
        
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}
}