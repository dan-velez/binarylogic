package com.blit.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionUtil {
    
    @SuppressWarnings("deprecation")
    public static Connection getConnection () throws SQLException {
        /**
         * Traditionally, the driver manager had to be made aware of the dialect
         * Driver. This is no longer necessary usually, but will encounter it.
         */

        System.out.println("MySQL Driver.");

         try {
            // Register Driver.
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
         } catch (Exception e) {
            e.printStackTrace();
         }

         // Register Credentials.
         String location = "jdbc:mysql://localhost:3306/demos";
         String username = "root";
         String password = "password";

         return DriverManager.getConnection(location, username, password);
    }
}
