package dao;
import entidad.UsuarioRegistrado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioRegistradoDAO {
    private Connection conexion;

    public UsuarioRegistradoDAO(Connection conexion){ this.conexion = conexion; }

    public void insertarUsuarioRegistrado(UsuarioRegistrado usuarioRegistrado) throws SQLException{
        String sql = "INSERT INTO usuarioregistrado(ID_UsuarioRegistrado, UsuarioID, PlataformaID) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, usuarioRegistrado.getId());
            statement.setInt(2, usuarioRegistrado.getUsuario().getId());
            statement.setInt(3, usuarioRegistrado.getPlataforma().getId());
            statement.executeUpdate();
        }
    }
}
