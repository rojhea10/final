/**
 * 
 */
package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Rojhe
 *
 */
public class insert {

private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/final";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "*******";
    private User user; // Store user object
    
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


    public static void in(User user) {

         Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            con = getDBConnection();
            con.setAutoCommit(false);
            
            String qry = "INSERT INTO Employment_Application (full_name, email, address, position, gender, salary, start_Date, phone, education, relative, authorized, comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = con.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
            int counter = 1;
             
             // Set parameters for employment application
             try {
                pstmt.setString(counter++, user.getFullname());
             } catch (SQLException e) {
                System.out.println("Error setting full name: " + e.getMessage());
             }
             try {
                pstmt.setString(counter++, user.getEmail());
             } catch (SQLException e) {
                System.out.println("Error setting email: " + e.getMessage());
             }
                try {
                    pstmt.setString(counter++, user.getAddress());
                } catch (SQLException e) {
                    System.out.println("Error setting address: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getPosition());
                } catch (SQLException e) {
                    System.out.println("Error setting position: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getGender());
                } catch (SQLException e) {
                    System.out.println("Error setting gender: " + e.getMessage());
                }
                try {
                    pstmt.setDouble(counter++, user.getSalary());
                } catch (SQLException e) {
                    System.out.println("Error setting salary: " + e.getMessage());
                }   
                try {
                    pstmt.setString(counter++, user.getStartDate().toString());
                } catch (SQLException e) {
                    System.out.println("Error setting start date: " + e.getMessage());
                }
                try {
                    pstmt.setInt(counter++, user.getPhone());
                } catch (SQLException e) {
                    System.out.println("Error setting phone: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getEducation());
                } catch (SQLException e) {
                    System.out.println("Error setting education: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getRelatives());
                } catch (SQLException e) {
                    System.out.println("Error setting relatives: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getAuthorized());
                } catch (SQLException e) {
                    System.out.println("Error setting authorized: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getComments());
                } catch (SQLException e) {
                    System.out.println("Error setting comments: " + e.getMessage());
                }

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            
            con.commit();
            System.out.println("employment Application Transaction committed successfully");
            
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Generated ID: " + rs.getInt(1));
            }
            
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        
            if (con != null) {
                try {
                    con.rollback();
                    System.out.println("Transaction rolled back");
                } catch (SQLException e1) {
                    e1.getMessage();
                }
            }
        }
        //insert into Applicant table
        try {
            con = getDBConnection();
            con.setAutoCommit(false);
            
            String qry1 = "INSERT INTO Applicant (full_name, email, phone, address, gender, education) VALUES (?, ?, ?, ?, ?, ?)";
        
            pstmt = con.prepareStatement(qry1, Statement.RETURN_GENERATED_KEYS);
            int counter = 1;
                // Set parameters for applicant
                try {
                    pstmt.setString(counter++, user.getFullname());
                } catch (SQLException e) {
                    System.out.println("Error setting full name: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getEmail());
                } catch (SQLException e) {
                    System.out.println("Error setting email: " + e.getMessage());
                }
                try {
                    pstmt.setInt(counter++, user.getPhone());
                } catch (SQLException e) {
                    System.out.println("Error setting phone: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getAddress());
                } catch (SQLException e) {
                    System.out.println("Error setting address: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getGender());
                } catch (SQLException e) {
                    System.out.println("Error setting gender: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getEducation());
                } catch (SQLException e) {
                    System.out.println("Error setting education: " + e.getMessage());
                }
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            con.commit();
            System.out.println("Applicant table Transaction committed successfully");
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Generated ID: " + rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            if (con != null) {
                try {
                    con.rollback();
                    System.out.println("Transaction rolled back");
                } catch (SQLException e1) {
                    e1.getMessage();
                }
            }
        }

        //insert into Employment table
        try {
            con = getDBConnection();
            con.setAutoCommit(false);
            
            String qry2 = "INSERT INTO Employment (position, salary, start_Date, phone, relative, authorized, comments) VALUES (?, ?, ?, ?, ?, ?, ?)";        

            pstmt = con.prepareStatement(qry2, Statement.RETURN_GENERATED_KEYS);
            int counter = 1;

                // Set parameters for employment
                try {
                    pstmt.setString(counter++, user.getPosition());
                } catch (SQLException e) {
                    System.out.println("Error setting position: " + e.getMessage());
                }
                try {
                    pstmt.setDouble(counter++, user.getSalary());
                } catch (SQLException e) {
                    System.out.println("Error setting salary: " + e.getMessage());
                }   
                try {
                    pstmt.setString(counter++, user.getStartDate().toString());
                } catch (SQLException e) {
                    System.out.println("Error setting start date: " + e.getMessage());
                }
                try {
                    pstmt.setInt(counter++, user.getPhone());
                } catch (SQLException e) {
                    System.out.println("Error setting phone: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getRelatives());
                } catch (SQLException e) {
                    System.out.println("Error setting relatives: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getAuthorized());
                } catch (SQLException e) {
                    System.out.println("Error setting authorized: " + e.getMessage());
                }
                try {
                    pstmt.setString(counter++, user.getComments());
                } catch (SQLException e) {
                    System.out.println("Error setting comments: " + e.getMessage());
                }
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            con.commit();
            System.out.println("Employment table Transaction committed successfully");
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Generated ID: " + rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            
            if (con != null) {
                try {
                    con.rollback();
                    System.out.println("Transaction rolled back");
                } catch (SQLException e1) {
                    e1.getMessage();
                }
            }
        }
            
         finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Connection closed");
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
        }

    }
}
