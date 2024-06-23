package com.mycompany.testingjpa;

import gestorbd.lideres.lideres;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public boolean insertarLider (lideres lider){
            MyConnection insertar = new MyConnection();
            insertar.conectar();
        try{
            Connection c = conectar();
            String sql = "insert into lider values(default,?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, lider.getId());
            ps.setString(2, lider.getNombre());
            ps.setString(3, lider.getApellido());
            PreparedStatement pa;
            ps.setString(4, lider.getFechaContratacion());




            int conteo = ps.executeUpdate();
            return conteo > 0;

        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
            return false;
        }
    }
}
