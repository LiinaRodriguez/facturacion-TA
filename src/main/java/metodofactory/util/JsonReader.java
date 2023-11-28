
package metodofactory.util;

import entidad.Credenciales;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    private String dbName;
    public JsonReader(){

    }
   public String getDatabaseName(String inicioJsonPath){
        try (FileReader reader = new FileReader(inicioJsonPath)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);

            if (jsonElement.isJsonObject()) {
                JsonObject inicioDB = jsonElement.getAsJsonObject();

                if(inicioDB != null){
                    Boolean mysql = inicioDB.get("mysql").getAsBoolean();
                    Boolean postgres = inicioDB.get("postgres").getAsBoolean();

                    if (mysql){
                        dbName = "MySQL";
                    } else if (postgres) {
                        dbName = "POSTGRESQL";
                    }else{
                        dbName = null;
                    }
                }
            }else {
                System.out.println("El archivo JSON no se pudo leer.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dbName;
    }
    public Credenciales cargarPropiedadesJson(String Url){
        Credenciales credenciales = new Credenciales();
        try (FileReader reader = new FileReader( Url)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);

            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                if (jsonObject != null) {
                    JsonElement url = jsonObject.get("url");
                    JsonElement usuario = jsonObject.get("usuario");
                    JsonElement password = jsonObject.get("contrasena");

                    credenciales.setUrl(url.getAsString());
                    credenciales.setUsuario(usuario.getAsString());
                    credenciales.setContrasena(password.getAsString());
                } else {
                    System.out.println("La base de datos especificada no está configurada en el archivo JSON.");
                }
            } else {
                System.out.println("El archivo JSON no se pudo leer.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credenciales;
    }
}

