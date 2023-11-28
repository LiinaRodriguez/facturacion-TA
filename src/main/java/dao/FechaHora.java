package dao;

import metodofactory.DBAdapter;
import metodofactory.DBFactory;
import metodofactory.DBType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class FechaHora {
    private DBAdapter dbAdapter;
    public FechaHora(){
        dbAdapter = DBFactory.getDefaultDbAdapter();
    }
    public FechaHora(DBType dbType){dbAdapter = DBFactory.getDatabaseAdapter(dbType);}
    public void getFechaHora() throws SQLException {
        Connection conexion = dbAdapter.getConexion();
        String sql = "SELECT NOW() as fechahora";
        Transaccion transaccion = new Transaccion(conexion);
        try(PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            transaccion.iniciarTransaccion();
            if(resultSet.next()){
                java.sql.Timestamp timestamp = resultSet.getTimestamp("fechaHora");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                System.out.println("Fecha: " + dateFormat.format(timestamp));
                System.out.println("Hora: " + timeFormat.format(timestamp));
            }
            transaccion.confirmarTransaccion();
        } catch (SQLException e) {
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
