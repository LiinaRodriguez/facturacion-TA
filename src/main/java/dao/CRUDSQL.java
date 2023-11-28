package dao;

import java.sql.SQLException;
import java.util.List;

public interface CRUDSQL<E> {
    public void insertar(E object)throws SQLException;

    public void eliminar(int id)throws SQLException;

    public List<E> obtenerDatos()throws SQLException;

    public void actualizar(E object, int id)throws SQLException;
}
