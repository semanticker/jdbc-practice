package org.example;

import java.sql.*;

public class UserDao {
    public void create(User user) throws SQLException {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            String sql = "INSERT INTO USERS values (?, ?, ?, ?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (con !=null) {
                con.close();
            }
        }

    }

    private Connection getConnection() {
        String URL = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
        //String URL = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
        String ID = "sa";
        String PW = "";

        try {
            return DriverManager.getConnection(URL, ID, PW);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findByUserId(String userId) throws SQLException {


        Connection con = null;

        PreparedStatement pstmt = null;

        ResultSet rs = null;

        try {
            con = getConnection();

            String sql = "SELECT userId, password, name, email FROM USERS WHERE userid = ?";
            con.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            User user = null;
            if (rs.next()) {
                user = new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }

            return user;

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (con !=null) {
                con.close();
            }
        }

    }
}
