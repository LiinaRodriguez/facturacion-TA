package com.mycompany.cliente.DAO;

import com.mycompany.cliente.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ServicioDAO {
    private Connection conexion;
    public ServicioDAO(Connection conexion){
        this.conexion = conexion;
    }

    public void insertServicio(Servicio servicio) throws  SQLException {
        String sql = "INSERT INTO servicio(ID_Servicio, nombreServicio, precio) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, servicio.getId());
            statement.setString(2, servicio.getNombreServicio());
            statement.setString(3, servicio.getPrecioServicio());
            statement.executeUpdate();
        }
    }
    public void eliminarServicio(int servicio_id) throws SQLException {
        String sql = "DELETE FROM servicio WHERE ID_Servicio =?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, servicio_id);
            statement.executeUpdate();
        }
    }
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
    }
    public void actualizarServicio(Servicio actservicio, int servicio_id) throws SQLException{
        String sql = "UPDATE servicio SET NombreServicio =?, Precio=? WHERE ID_SERVICIO=? ";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, actservicio.getNombreServicio());
            statement.setString(2, actservicio.getPrecioServicio());
            statement.setInt(3, servicio_id);
            statement.executeUpdate();
        }
    }
}
