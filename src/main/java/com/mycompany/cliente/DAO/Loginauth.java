package com.mycompany.cliente.DAO;

import com.mycompany.cliente.Login;
import com.mycompany.cliente.Plataforma;
import com.mycompany.cliente.Usuario;
import com.mycompany.cliente.UsuarioRegistrado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Loginauth {
    private Connection conexion;

    public Loginauth(Connection conexion){this.conexion = conexion; }

    public boolean verificarInicioSesion(String usuario, String contrasena, int plataformaID){
        String sql = "SELECT  COUNT(*) FROM usuarioregistrado ur "+
                "INNER JOIN usuario u ON ur.UsuarioID = u.ID_Usuario "+
                "INNER JOIN plataforma p ON ur.PlataformaID = ID_Plataforma "+
                "WHERE u.NombreUsuario = ? AND u.contrasena = ? AND p.ID_Plataforma = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            statement.setInt(3, plataformaID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count == 1; // Si hay un usuario registrado en la plataforma, inicia sesión
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

   public UsuarioRegistrado obtenerUsuarioRegistrado(String usuario, String contrasena, int plataformaID){
        String sql = "SELECT ur.ID_UsuarioRegistrado, ur.UsuarioID, ur.PlataformaID, u.*, p.* FROM usuarioregistrado ur " +
                "INNER JOIN usuario u ON ur.UsuarioID = u.ID_Usuario " +
                "INNER JOIN plataforma p ON ur.PlataformaID = ID_Plataforma " +
                "WHERE u.NombreUsuario = ? AND u.contrasena = ? AND p.ID_Plataforma = ?";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, usuario);
                statement.setString(2, contrasena);
                statement.setInt(3, plataformaID);

                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    UsuarioRegistrado usuarioRegistrado = new UsuarioRegistrado();
                    usuarioRegistrado.setId(resultSet.getInt("ID_UsuarioRegistrado"));

                    //usuario
                    Usuario usuarior = new Usuario();
                    usuarior.setId(resultSet.getInt("ID_Usuario"));
                    usuarior.setUsuario(resultSet.getString("NombreUsuario"));
                    usuarior.setPassword(resultSet.getString("contrasena")); // Agrega otros campos según sea necesario
                    usuarioRegistrado.setUsuario(usuarior);

                    //plataforma
                    Plataforma plataforma = new Plataforma();
                    plataforma.setId(resultSet.getInt("ID_Plataforma"));
                    plataforma.setPlataforma(resultSet.getString("NombrePlataforma"));
                    usuarioRegistrado.setPlataforma(plataforma);

                    return usuarioRegistrado;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }

    public void insertLogin(Login login) throws SQLException{
        String sql = "INSERT INTO login ( UsuarioRegistradoID) VALUES (?)";
        try(PreparedStatement statement = conexion.prepareStatement(sql)){
            statement.setInt(1, login.getUsuarioRegistrado().getId());
            statement.executeUpdate();
        }
    }
}
