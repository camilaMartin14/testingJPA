package com.mycompany.testingjpa;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Camila
 */
public class Sql {

    public static void main(String[] args) {
        MyConnection cnt = new MyConnection ();
        
        try{
            
            Connection cnx = cnt.conectar();
            if (cnx.isClosed()) {
                System.out.println("No se pudo conectar a la Base de Datos");
            }else{
                System.out.println("Conexion exitosa");
            }
            
            
            cnx.close();
            
        }catch (SQLException ex){
            System.err.println("Error : " + ex.getMessage());
        }
    }
}
