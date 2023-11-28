package metodofactory.implementacion;

import entidad.Credenciales;
import metodofactory.util.JsonReader;
import metodofactory.DBAdapter;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLAdapter implements DBAdapter {
    private static final String mysqslJsonPath = "C:\\Users\\linnr\\OneDrive\\Documentos\\INFO\\DBMySQL.json";
    private static MySQLAdapter instance;

    static {
        try{
            new com.mysql.cj.jdbc.Driver();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConexion(){
        try{
            JsonReader mysql = new JsonReader();
            Credenciales mysqlprop = mysql.cargarPropiedadesJson(mysqslJsonPath);
            String Url = mysqlprop.getUrl();
            String usuario = mysqlprop.getUsuario();
            String contrasena = mysqlprop.getContrasena();
            Connection connection = DriverManager
                    .getConnection(Url, usuario, contrasena);
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }

    public static synchronized MySQLAdapter getInstance(){
        if (instance == null) {
            instance = new MySQLAdapter();
        }
        return instance;
    }

}
