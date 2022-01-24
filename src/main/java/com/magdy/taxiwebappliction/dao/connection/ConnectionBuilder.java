//package com.magdy.taxiwebappliction.dao.connection;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.logging.Logger;
//
//public class ConnectionBuilder {
//
//
//    private static final Logger logger = Logger.getLogger(ConnectionBuilder.class.getName());
//    private static final String jdbcPasswordD = "12345";
//    private static final String jdbcUsernameD = "postgres";
//    private static final String jdbcURLD = "jdbc:postgresql://localhost:5432/taxi";
//
//    public ConnectionBuilder() {
//
//    }
//
//
//    public static Connection getConnection() {
//        try {
//
//            Class.forName("org.postgresql.Driver");
//            System.out.println(jdbcURLD);
//            Connection connection = DriverManager.getConnection(jdbcURLD, jdbcUsernameD, jdbcPasswordD);
//            logger.info("connected.....");
//            return connection;
//
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new Error("There a Problem.....", e);
//        }
//
//    }
//}
