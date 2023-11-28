package dao;

import entidad.DetalleVentaServicio;
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

public class OperacionesBD {
    private DBAdapter dbAdapter;
    public OperacionesBD(){
        dbAdapter = DBFactory.getDefaultDbAdapter();
    }

    public List<DetalleVentaServicio> obtenerUnionOjbeto() throws SQLException{
        Connection conexion = dbAdapter.getConexion();
        List<DetalleVentaServicio> detalleVentaUnionServicios = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM servicio\n" +
                "LEFT JOIN detalledeventa ON servicio.ID_Servicio = detalledeventa.ServicioID\n" +
                "UNION\n" +
                "SELECT *\n" +
                "FROM servicio\n" +
                "RIGHT JOIN detalledeventa ON servicio.ID_Servicio = detalledeventa.ServicioID\n" +
                "WHERE servicio.ID_Servicio IS NULL;\n";
        return getRegistros(conexion, detalleVentaUnionServicios, sql);
    }

    public List<DetalleVentaServicio> obtenerDiferenciaOjbeto() throws SQLException{
        Connection conexion = dbAdapter.getConexion();
        List<DetalleVentaServicio> detalleVentaUnionServicios = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM servicio\n" +
                "LEFT JOIN detalledeventa ON servicio.ID_Servicio = detalledeventa.ServicioID\n" +
                "WHERE detalledeventa.ServicioID IS NULL\n";

        return getRegistros(conexion, detalleVentaUnionServicios, sql);
    }

    private List<DetalleVentaServicio> getRegistros(Connection conexion, List<DetalleVentaServicio> detalleVentaUnionServicios, String sql) throws SQLException {
        Transaccion transaccion = new Transaccion(conexion);
        try(PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            transaccion.iniciarTransaccion();
            while(resultSet.next()){
                Servicio servicio = new Servicio();
                DetalleVentaServicio detalleVentaServicio = new DetalleVentaServicio();
                servicio.setId(resultSet.getInt("id_servicio"));
                servicio.setNombreServicio(resultSet.getString("nombreservicio"));
                servicio.setPrecioServicio(resultSet.getString("precio"));
                detalleVentaServicio.setId(resultSet.getInt("id_detalledeventa"));
                detalleVentaServicio.setCantidad(resultSet.getInt("cantidad"));
                detalleVentaServicio.setFecha(resultSet.getString("fecha"));
                detalleVentaServicio.setServicio(servicio);
                detalleVentaUnionServicios.add(detalleVentaServicio);
            }
            transaccion.confirmarTransaccion();
            return detalleVentaUnionServicios;
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
        return detalleVentaUnionServicios;
    }

   public OperacionesBD(DBType dbType){
        dbAdapter = DBFactory.getDatabaseAdapter(dbType);
   }
}
