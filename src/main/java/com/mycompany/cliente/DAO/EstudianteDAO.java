package com.mycompany.cliente.DAO;

import com.mycompany.cliente.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstudianteDAO {
    private Connection conexion;

    public EstudianteDAO(Connection conexion) {
        this.conexion = conexion;
    }
    public void insertarEstudiante(Estudiante estudiante) throws SQLException {
        String sql = "INSERT INTO estudiante(ID_Estudiante, Carrera, Semestre) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement((sql))) {
            statement.setInt(1, estudiante.getId());
            statement.setString(2, estudiante.getCarrera());
            statement.setInt(3, estudiante.getSemestre());
            statement.executeUpdate();
        }
    }
}
