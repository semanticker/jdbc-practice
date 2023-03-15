package org.example;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static DataSource getDataSource() {

        String DRIVER_CLASS_NAME = "org.h2.Driver";
        String JDBC_URL = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";

        String USER_NAME = "sa";
        String USER_PASSWORD = "";

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(DRIVER_CLASS_NAME);
        hikariDataSource.setJdbcUrl(JDBC_URL);
        hikariDataSource.setUsername(USER_NAME);
        hikariDataSource.setUsername(USER_PASSWORD);

        return hikariDataSource;
    }


    public static Connection getConnection() {
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
}
