package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class Transaccion implements AutoCloseable{
    private final Connection connection;
   public Transaccion(Connection conexion){
       this.connection = conexion;
   }

    public void iniciarTransaccion() {
        try {
            System.out.println("Autocommit false");
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
            System.out.println("Cerrando conexion");
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cerrar la conexión");
        }
    }
}
