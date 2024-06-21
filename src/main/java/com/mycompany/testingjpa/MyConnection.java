package com.mycompany.testingjpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Camila
 */
public class MyConnection {
    
    public Connection conectar () throws SQLException{
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
       
            String url = "jdbc:mysql://localhost/konecta";
            String user = "root";
            String password = "";
        
            Connection conexion = DriverManager.getConnection(url, user, password);
        
            return conexion;
        
        } catch (ClassNotFoundException ex) {
            System.err.println("Error -> " + ex.getMessage());
        }catch (SQLException ex){
            System.err.println("Error -> " + ex.getMessage());
        }
        return null;
    }
}