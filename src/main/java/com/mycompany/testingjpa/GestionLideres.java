package com.mycompany.testingjpa;

import gestorbd.lideres.lideres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase para manejar operaciones SQL relacionadas con lideres.
 */
public class GestionLideres {

    private MyConnection conexion; // Instancia única de MyConnection para manejar la conexión

    public GestionLideres() {

        this.conexion = new MyConnection(); // Establecer la conexión en el constructor
    }


    // Método para insertar un líder en la base de datos
    public boolean insertarLider(lideres lider) {
        try {
            Connection c = conexion.conectar(); // Obtener la conexión

            String sql = "insert into lider (id, nombre, apellido, fecha_contratacion) values(default,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, lider.getNombre());
            ps.setString(2, lider.getApellido());
            ps.setString(3, lider.getFechaContratacion());

            int conteo = ps.executeUpdate();

            c.close(); // Cerrar la conexión

            return conteo > 0; // Devolver true si se insertó al menos una fila

        } catch (SQLException e) {
            System.out.println("Error al insertar líder: " + e.getMessage());
            return false;
        }
    }
}