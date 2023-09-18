package com.mycompany.cliente.DAO;
import com.mycompany.cliente.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private Connection conexion;
    public PersonaDAO(Connection conexion){
        this.conexion = conexion;
    }

    public void insertPersona(Persona persona) throws  SQLException {
        String sql = "INSERT INTO persona(ID_Persona,nombre, apellido, telefono) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, persona.getId());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellido());
            statement.setString(4, persona.getTelefono());
            statement.executeUpdate();
        }
    }
    public void eliminarPersona(int persona_id) throws SQLException {
        String sql = "DELETE FROM persona WHERE ID_Persona =?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, persona_id);
            statement.executeUpdate();
        }
    }
    public List<Persona> obtenerPersona() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Persona persona = new Persona();
                //usuario.setId(resultSet.getInt("id"));
                persona.setNombre(resultSet.getString("Nombre"));
                persona.setCorreo(resultSet.getString("CorreoElectronico"));
                persona.setApellido(resultSet.getString("Apellido"));
                persona.setTelefono(resultSet.getString("Telefono"));
                //persona.set(resultSet.getString("contrasena"));

                personas.add(persona);
            }
        }
        return personas;
    }
    public void actualizarPersona(Persona actpersona, int persona_id) throws SQLException{
        String sql = "UPDATE persona SET Nombre =?, Apellido=? WHERE ID_Persona=? ";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, actpersona.getNombre());
            statement.setString(2, actpersona.getApellido());
            statement.setInt(3, persona_id);
            statement.executeUpdate();
        }
    }

}
