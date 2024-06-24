package com.mycompany.testingjpa;

import gestorbd.lideres.Lider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase para manejar operaciones SQL relacionadas con lideres.
 */
public class GestionLideres {

    private ConexionConBD conexion; // Instancia única de ConexionConBD para manejar la conexión

    public GestionLideres() {

        this.conexion = new ConexionConBD(); // Establecer la conexión en el constructor
    }


    // Método para insertar un líder en la base de datos
    public boolean insertarLider(Lider lider) {
        try {
            Connection c = conexion.conectar(); // Obtener la conexión

            String sql = "insert into Lider (id, nombre, apellido, fecha_contratacion) values(default,?,?,?)";
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
