package com.magdy.taxiwebappliction.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionBuilder {


    private static final Logger logger = Logger.getLogger(ConnectionBuilder.class.getName());

    private static String jdbcURL = "jdbc:postgresql://localhost:5432/taxi?useSSL=false";
    private static String jdbcUsername = "postgres";
    private static String jdbcPassword = "12345";



    public static Connection getConnection() {


        try {
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            logger.info("connected.....");
            return connection;

        } catch (SQLException e) {
            throw new Error("There a Problem.....", e);
        }

    }
}
