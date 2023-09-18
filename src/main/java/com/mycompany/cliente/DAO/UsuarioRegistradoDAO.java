package com.mycompany.cliente.DAO;
import com.mycompany.cliente.Usuario;
import com.mycompany.cliente.UsuarioRegistrado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRegistradoDAO {
    private Connection conexion;

    public UsuarioRegistradoDAO(Connection conexion){ this.conexion = conexion; }

    public void insertarUsuarioRegistrado(UsuarioRegistrado usuarioRegistrado) throws SQLException{
        String sql = "INSERT INTO usuario(ID_UsuarioRegistrado, UsuarioID, PlataformaID) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, usuarioRegistrado.getId());
            statement.setInt(2, usuarioRegistrado.getUsuario().getId());
            statement.setInt(3, usuarioRegistrado.getPlataforma().getId());
            statement.executeUpdate();
        }
    }
}
