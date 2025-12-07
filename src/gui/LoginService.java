package gui;

import java.sql.*;

public class LoginService {

    private final String url = "jdbc:mysql://localhost:3306/university";
    private final String user = "root";
    private final String pass = "";

    /**
     * Validates a user's login credentials against the students table.
     * Returns true if valid, false otherwise.
     */
    public boolean validateUser(String regNo, String password) {
        String sql = "SELECT * FROM students WHERE regNo = ? AND password = ?";

        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, regNo);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // True if a matching record exists
            }

        } catch (SQLException e) {
            // Log error to console for beginner simplicity
            System.err.println("Database error: " + e.getMessage());
            return false;
        }
    }
}