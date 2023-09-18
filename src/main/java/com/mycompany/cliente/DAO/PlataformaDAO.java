package com.mycompany.cliente.DAO;
import com.mycompany.cliente.Plataforma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlataformaDAO {
    private Connection conexion;

    public PlataformaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarPlataforma(Plataforma plataforma) throws SQLException {
        String sql = "INSERT INTO plataforma(ID_Plataforma, NombrePlataforma) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, plataforma.getId());
            statement.setString(2, plataforma.getPlataforma());
            statement.executeUpdate();
        }
    }
/*
    public void eliminarUsuario(int usuario_id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE ID_Usuario =?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, usuario_id);
            statement.executeUpdate();
        }
    }
    public List<Usuario> obtenerUsuario() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                //usuario.setId(resultSet.getInt("id"));
                usuario.setUsuario(resultSet.getString("NombreUsuario"));
                usuario.setPassword(resultSet.getString("contrasena"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }
    public void actualizarUsuario(Usuario actusuario, int usuario_id) throws SQLException{
        String sql = "UPDATE usuario SET NombreUsuario =?, contrasena=? WHERE ID_Usuario=? ";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, actusuario.getUsuario());
            statement.setString(2, actusuario.getPassword());
            statement.setInt(3, usuario_id);
            statement.executeUpdate();
        }
    }*/

}
