package com.mycompany.cliente.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection connection;
    public Conexion() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/facturacion_db";
        String db_usuario = "root";
        String db_contrasena = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(jdbcUrl, db_usuario, db_contrasena);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public Connection obtenerConexion() {
        return connection;
    }
    public void iniciarTransaccion() {
        try {
            connection.setAutoCommit(false); // Deshabilita la autoconfirmación para iniciar una transacción
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al iniciar la transacción");
        }
    }
    public void confirmarTransaccion() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al confirmar la transacción");
        }
    }
    public void revertirTransaccion() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al revertir la transacción");
        }
    }
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
