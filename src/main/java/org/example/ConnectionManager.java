package org.example;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class ConnectionManager {
    public static DataSource getDataSource() {

        String DRIVER_CLASS_NAME = "org.h2.Driver";
        String JDBC_URL = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=1";

        String USER_NAME = "sa";
        String USER_PASSWORD = "";

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(DRIVER_CLASS_NAME);
        hikariDataSource.setJdbcUrl(JDBC_URL);
        hikariDataSource.setUsername(USER_NAME);
        hikariDataSource.setUsername(USER_PASSWORD);

        return hikariDataSource;
    }
}
