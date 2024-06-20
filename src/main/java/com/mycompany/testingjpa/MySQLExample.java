package com.mycompany.testingjpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *hola
 * @author Camila
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLExample {
    public static void main(String[] args) throws SQLException {
        // JDBC URL, username and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/database_name";
        String user = "username";
        String password = "password";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get a connection to database
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to MySQL database has been established!");

            // Do something with the connection...

        } catch (ClassNotFoundException e) {
            System.err.println("Could not load JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }
}
