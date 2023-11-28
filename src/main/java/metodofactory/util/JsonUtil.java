package metodofactory.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JsonUtil {
    public static Properties cargarPropiedadesJson(String Url){

        try (FileReader reader = new FileReader( Url)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            Properties properties = new Properties();

            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                if (jsonObject != null) {
                    properties.setProperty("url",jsonObject.get("url").getAsString());
                    properties.setProperty("usuario", jsonObject.get("usuario").getAsString());
                    properties.setProperty("password", jsonObject.get("contrasena").getAsString());
                }
                return properties;
            } else {
                System.out.println("El archivo JSON no se pudo leer.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public  static Properties leerPropiedades(String URL){
        try(FileReader reader = new FileReader(URL)){
            JsonElement jsonElement = JsonParser.parseReader(reader);
            Properties properties = new Properties();

            if (jsonElement.isJsonObject()) {
                JsonObject inicioDB = jsonElement.getAsJsonObject();

                if(inicioDB != null){
                    properties.setProperty("mysql", inicioDB.get("mysql").getAsString());
                    properties.setProperty("postgres", inicioDB.get("postgres").getAsString());
                }

                return properties;
            }else {
                System.out.println("El archivo JSON no se pudo leer.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
