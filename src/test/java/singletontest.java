import metodofactory.DBAdapter;
import metodofactory.DBFactory;
import metodofactory.DBType;
import metodofactory.implementacion.MySQLAdapter;
import metodofactory.implementacion.PostgresSQLAdapter;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class singletontest {
    @Test
    public void testSingletonMySQL() {
        // Comparar dos instancias de MySQL
        MySQLAdapter instancia1 = MySQLAdapter.getInstance();
        MySQLAdapter instancia2 = MySQLAdapter.getInstance();

        assertSame(instancia1, instancia2);
    }

    @Test
    public void testSingletonPOSTGRESQL(){
        PostgresSQLAdapter instancia1 = PostgresSQLAdapter.getInstance();
        PostgresSQLAdapter instancia2 = PostgresSQLAdapter.getInstance();

        assertSame(instancia1, instancia2);
    }

    @Test
    public void DBFactoryDefault(){
        DBAdapter dbAdapter1 = DBFactory.getDefaultDbAdapter();
        DBAdapter dbAdapter2 = DBFactory.getDefaultDbAdapter();

        assertSame(dbAdapter1, dbAdapter2);
    }

    @Test
    public void DBFactory(){

        DBAdapter dbAdapter1 = DBFactory.getDatabaseAdapter(DBType.MySQL);
        DBAdapter dbAdapter2 = DBFactory.getDatabaseAdapter(DBType.POSTGRESQL);

        assertSame(dbAdapter1, dbAdapter2);
    }
}
