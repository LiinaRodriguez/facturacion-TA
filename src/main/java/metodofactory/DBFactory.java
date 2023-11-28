package metodofactory;

import metodofactory.util.JsonReader;
import metodofactory.implementacion.MySQLAdapter;
import metodofactory.implementacion.PostgresSQLAdapter;

public class DBFactory {
    private static DBAdapter dbAdapter;
    private static final  String DB_DEFAULT_URL = "C:\\Users\\linnr\\OneDrive\\Documentos\\INFO\\DB_FACTORY.json";
    private DBFactory(){}
    public static synchronized DBAdapter getDatabaseAdapter(DBType dbType) {

        if(dbAdapter == null){

            switch (dbType){
                case MySQL:
                    dbAdapter = MySQLAdapter.getInstance();
                    break;
                case POSTGRESQL:
                    dbAdapter = PostgresSQLAdapter.getInstance();
                    break;
                default:
                    throw  new IllegalArgumentException("No soportado");
            }
        }
        return dbAdapter;
    }

    public static synchronized DBAdapter getDefaultDbAdapter() {
        try{
            if(dbAdapter == null){
                JsonReader defaultdb = new JsonReader();
                String DefaultDB =  defaultdb.getDatabaseName(DB_DEFAULT_URL);
                switch (DefaultDB){
                    case "MySQL":
                        dbAdapter = MySQLAdapter.getInstance();
                        break;
                    case "POSTGRESQL":
                        dbAdapter = PostgresSQLAdapter.getInstance();
                        break;
                }
                return dbAdapter;
            }
            return dbAdapter;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    

}
