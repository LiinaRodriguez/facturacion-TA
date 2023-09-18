package com.mycompany.cliente.DAO;

import com.mycompany.cliente.DetalleVentaServicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaServicioDAO {
    private Connection conexion;
    public DetalleVentaServicioDAO(Connection conexion){
        this.conexion = conexion;
    }

    public void insertDetalleVentaServicio(DetalleVentaServicio detalleventaservicio) throws SQLException {
        String sql = "INSERT INTO detalledeventa(ID_DetalleDeVenta, ServicioID, Cantidad, Fecha) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, detalleventaservicio.getId());
            statement.setInt(2, detalleventaservicio.getServicio().getId());
            statement.setInt(3, detalleventaservicio.getCantidad());
            statement.setString(4, detalleventaservicio.getFecha());
            statement.executeUpdate();
        }
    }
    public void eliminarDetalleVentaServicio(int detalledeventa_id) throws SQLException {
        String sql = "DELETE FROM detalledeventa WHERE ID_DetalleDeVenta =?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, detalledeventa_id);
            statement.executeUpdate();
        }
    }
    /*
    public List<Servicio> obtenerServicio() throws SQLException {
        List<Servicio> servicios = new ArrayList<>();
        String sql = "SELECT * FROM servicio";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Servicio servicio = new Servicio();
                servicio.setNombreServicio(resultSet.getString("NombreServicio"));
                servicio.setPrecioServicio(resultSet.getString("Precio"));
                servicios.add(servicio);
            }
        }
        return servicios;
    }*/
}
