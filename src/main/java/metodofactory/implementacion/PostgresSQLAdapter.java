package metodofactory.implementacion;

import entidad.Credenciales;
import metodofactory.util.JsonReader;
import metodofactory.DBAdapter;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresSQLAdapter implements DBAdapter {
    private static final String postgresqlJsonPath = "C:\\Users\\linnr\\OneDrive\\Documentos\\INFO\\DB_POSTGRESQL.json";
    private static PostgresSQLAdapter instance;

    static {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConexion() {
        try {
            JsonReader postgresql = new JsonReader();
            Credenciales postgresqlprop = postgresql.cargarPropiedadesJson(postgresqlJsonPath);
            String Url = postgresqlprop.getUrl();
            String usuario = postgresqlprop.getUsuario();
            String contrasena = postgresqlprop.getContrasena();
            Connection connection = DriverManager
                    .getConnection(Url, usuario, contrasena);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static synchronized PostgresSQLAdapter getInstance(){
        if (instance == null) {
            instance = new PostgresSQLAdapter();
        }
        return instance;
    }
}
