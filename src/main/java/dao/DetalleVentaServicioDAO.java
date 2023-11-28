package dao;

import entidad.DetalleVentaServicio;
import entidad.Servicio;
import metodofactory.DBAdapter;
import metodofactory.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaServicioDAO {
    private DBAdapter dbAdapter;
    public DetalleVentaServicioDAO(){
       dbAdapter = DBFactory.getDefaultDbAdapter();
    }

    public Boolean insertDetalleVentaServicio(DetalleVentaServicio detalleventaservicio) throws SQLException {
        Connection conexion = dbAdapter.getConexion();
        String sql = "INSERT INTO detalledeventa( ServicioID, Cantidad, Fecha) VALUES (?, ?, ?)";
        Transaccion transaccion = new Transaccion(conexion);
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            transaccion.iniciarTransaccion();
            statement.setInt(2, detalleventaservicio.getServicio().getId());
            statement.setInt(3, detalleventaservicio.getCantidad());
            statement.setString(4, detalleventaservicio.getFecha());
            statement.executeUpdate();
            transaccion.confirmarTransaccion();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conexion != null) {
                    transaccion.revertirTransaccion();
                }
            } finally {
                try {
                    // Cerrar la conexión
                    if (conexion != null) {
                        transaccion.cerrarConexion();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return true;
    }
    public void eliminarDetalleVentaServicio(int detalledeventa_id) throws SQLException {
        Connection conexion = dbAdapter.getConexion();
        String sql = "DELETE FROM detalledeventa WHERE ID_DetalleDeVenta =?";
        Transaccion transaccion = new Transaccion(conexion);
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, detalledeventa_id);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conexion != null) {
                    transaccion.revertirTransaccion();
                }
            } finally {
                try {
                    // Cerrar la conexión
                    if (conexion != null) {
                        transaccion.cerrarConexion();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
    public List<DetalleVentaServicio> obtenerDetalleVentaServicio() throws SQLException {
        Connection conexion = dbAdapter.getConexion();
        List<DetalleVentaServicio> detalleVentaServicios = new ArrayList<>();
        String sql = "SELECT * FROM detalledeVenta";
        Transaccion transaccion = new Transaccion(conexion);
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            transaccion.iniciarTransaccion();
            while (resultSet.next()) {
                DetalleVentaServicio detalleVentaServicio = new DetalleVentaServicio();
                detalleVentaServicio.setId(resultSet.getInt("id_detalledeventa"));
                detalleVentaServicio.setCantidad(resultSet.getInt("cantidad"));
                detalleVentaServicio.setFecha(resultSet.getString("fecha"));
                detalleVentaServicios.add(detalleVentaServicio);

            }
            transaccion.confirmarTransaccion();
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conexion != null) {
                    transaccion.revertirTransaccion();
                }
            } finally {
                try {
                    // Cerrar la conexión
                    if (conexion != null) {
                        transaccion.cerrarConexion();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return detalleVentaServicios;
    }
    public void actualizarDetalleVentaServicio(DetalleVentaServicio actdetalleVentaServicio, int detalleVentaServicio_id) throws SQLException{
        Connection conexion = dbAdapter.getConexion();
        String sql = "UPDATE detalledeventa SET  cantidad=?, fecha=? WHERE id_detalledeventa=? ";
        Transaccion transaccion = new Transaccion(conexion);
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, actdetalleVentaServicio.getCantidad());
            statement.setString(2, actdetalleVentaServicio.getFecha());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conexion != null) {
                    transaccion.revertirTransaccion();
                }
            } finally {
                try {
                    // Cerrar la conexión
                    if (conexion != null) {
                        transaccion.cerrarConexion();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
