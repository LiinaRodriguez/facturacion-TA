package dao;

import entidad.Servicio;
import metodofactory.DBAdapter;
import metodofactory.DBFactory;
import metodofactory.DBType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ServicioDAO {
    private DBAdapter dbAdapter;
    public ServicioDAO(){
        dbAdapter = DBFactory.getDefaultDbAdapter();
    }

    public  ServicioDAO(DBType dbType){
        dbAdapter = DBFactory.getDatabaseAdapter(dbType);
    }
    public Boolean insertServicio(Servicio servicio) throws  SQLException {
        Connection conexion = dbAdapter.getConexion();
        String sql = "INSERT INTO servicio(nombreServicio, precio) VALUES (?, ?)";
        Transaccion transaccion = new Transaccion(conexion);
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, servicio.getNombreServicio());
            statement.setString(2, servicio.getPrecioServicio());
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
                        dbAdapter = null;
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return true;
    }

    public void eliminarServicio(int servicio_id) throws SQLException {
        Connection conexion = dbAdapter.getConexion();
        String sql = "DELETE FROM servicio WHERE ID_Servicio =?";
        Transaccion transaccion = new Transaccion(conexion);
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, servicio_id);
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
    public List<Servicio> obtenerServicio() throws SQLException {
        Connection conexion = dbAdapter.getConexion();
        List<Servicio> servicios = new ArrayList<>();
        String sql = "SELECT * FROM servicio";
        Transaccion transaccion = new Transaccion(conexion);
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
             transaccion.iniciarTransaccion();
            while (resultSet.next()) {
                Servicio servicio = new Servicio();
                servicio.setId(resultSet.getInt("id_servicio"));
                servicio.setNombreServicio(resultSet.getString("NombreServicio"));
                servicio.setPrecioServicio(resultSet.getString("Precio"));
                servicios.add(servicio);
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
        return servicios;
    }
    public void actualizarServicio(Servicio actservicio, int servicio_id) throws SQLException{
        Connection conexion = dbAdapter.getConexion();
        String sql = "UPDATE servicio SET NombreServicio =?, Precio=? WHERE ID_SERVICIO=? ";
        Transaccion transaccion = new Transaccion(conexion);
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, actservicio.getNombreServicio());
            statement.setString(2, actservicio.getPrecioServicio());
            statement.setInt(3, servicio_id);
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
