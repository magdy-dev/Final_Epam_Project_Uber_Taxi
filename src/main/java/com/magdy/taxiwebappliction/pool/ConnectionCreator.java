package com.magdy.taxiwebappliction.pool;


import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private static final String jdbcURL="jdbc:postgresql://localhost:5432/taxi";
    private static final String jdbcUsername = "postgres";
    private static final String jdbcPassword = "12345";


    public static Connection getConnection() {


        try {
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("connected.....");
            return connection;

        } catch (SQLException e) {
            throw new Error("There a Problem.....", e);

        }

    }


}
