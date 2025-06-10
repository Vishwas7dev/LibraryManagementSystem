package src.dao;

import java.sql.*;

public class UserDAO {

    public static boolean authenticate(String username, String password) {
        boolean isValid = false;

        try {
            // Load the JDBC driver (assumes SQLite)
            Class.forName("org.sqlite.JDBC");

            // ✅ Absolute path to your DB file
            String dbPath = "C:/Users/vishw/OneDrive/Desktop/library.db"; // Use forward slashes

            // ✅ Connect using the full path
            Connection con = DriverManager.getConnection("jdbc:sqlite:" + dbPath);

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            isValid = rs.next(); // true if a record is found

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isValid;
    }
}
