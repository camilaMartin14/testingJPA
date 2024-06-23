package com.mycompany.testingjpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase para manejar la conexión a la BD MySQL.
 */
public class MyConnection {

    // URL de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost/konecta";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Singleton: instancia única de conexión
    private static Connection conexion;

    // Método para obtener la conexión a la base de datos
    public static Connection conectar() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                System.err.println("Error al cargar el driver JDBC: " + ex.getMessage());
                throw new SQLException("Driver JDBC no encontrado", ex);
            } catch (SQLException ex) {
                System.err.println("Error al conectar a la base de datos: " + ex.getMessage());
                throw ex;
            }
        }
        return conexion;
    }

    // Método para cerrar la conexión a la base de datos
    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            } finally {
                conexion = null;
            }
        }
    }
}