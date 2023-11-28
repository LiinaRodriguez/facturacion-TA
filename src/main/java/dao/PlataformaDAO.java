package dao;
import entidad.Plataforma;
import metodofactory.DBAdapter;
import metodofactory.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlataformaDAO implements CRUDSQL<Plataforma>{
   
    private DBAdapter dbAdapter;

    public PlataformaDAO() {
        dbAdapter = DBFactory.getDefaultDbAdapter();
    }

    @Override
    public void insertar(Plataforma plataforma) throws SQLException {
        Connection conexion = dbAdapter.getConexion();
        String sql = "INSERT INTO plataforma(ID_Plataforma, NombrePlataforma) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, plataforma.getId());
            statement.setString(2, plataforma.getPlataforma());
            statement.executeUpdate();
        }
    }

     @Override
     public void eliminar(int plataforma_id) throws SQLException {
         Connection conexion = dbAdapter.getConexion();
         String sql = "DELETE FROM plataforma WHERE ID_Plataforma =?";
         try (PreparedStatement statement = conexion.prepareStatement(sql)) {
             statement.setInt(1, plataforma_id);
             statement.executeUpdate();
         }
     }

     @Override
    public void actualizar(Plataforma actplataforma, int plataforma_id) throws SQLException {
        Connection conexion = dbAdapter.getConexion();
        String sql = "UPDATE plataforma SET NombrePlataforma =? WHERE ID_Plataforma=? ";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, actplataforma.getPlataforma());
            statement.setInt(2, plataforma_id);
            statement.executeUpdate();
        }
    }
     @Override
    public List<Plataforma> obtenerDatos() throws SQLException {
        Connection conexion = dbAdapter.getConexion();
        List<Plataforma> plataformas = new ArrayList<>();
        String sql = "SELECT * FROM plataforma";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Plataforma plataforma = new Plataforma();
                plataforma.setId(resultSet.getInt("ID_Plataforma"));
                plataforma.setPlataforma(resultSet.getString("NombrePlataforma"));
                plataformas.add(plataforma);
            }
            return plataformas;
        }

    }

 
}
