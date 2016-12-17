package api_subscription_generator.grants;

import db.DbConnector;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static settings.Settings.encoding;

public class DbGrants {

    private static Logger logger;

    static {
        logger = Logger.getLogger(DbGrants.class);
    }


    ArrayList<String> list = new ArrayList<>();
    PreparedStatement grantToSchemas = null;
    String query = "  SELECT 'GRANT '||PRIVILEGE||' ON '||table_name ||' to '||grantee||';'  AS RESULT\n"
            + "    FROM DBA_TAB_PRIVS tp\n"
            + "    LEFT JOIN DBA_ROLES ro\n"
            + "      ON ro.ROLE = tp.GRANTEE\n"
            + "    JOIN DBA_OBJECTS ob\n"
            + "      ON ob.OWNER = tp.OWNER\n"
            + "         AND ob.OBJECT_NAME = tp.TABLE_NAME\n"
            + "         AND ob.object_type NOT IN ('PACKAGE BODY',\n"
            + "                                    'TYPE BODY')\n"
            + "   WHERE tp.owner = ?\n"
            + "         AND ro.ROLE IS NULL\n"
            + "   ORDER BY object_name, table_name";


    public void generate(String schemaName) {

        ResultSet rs = null;
        list.clear();
        try {

            list.add("-- Grants for " + schemaName);
            Connection connection = DbConnector.connectToDb();
            grantToSchemas = connection.prepareStatement(query);

            grantToSchemas.setString(1, schemaName);

            rs = grantToSchemas.executeQuery();

            while (rs.next()) {
                String tableName = rs.getString("RESULT");
                list.add(tableName);
            }

            rs.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    public void toFile(String fileName) {

        File file = new File(Files.getName(fileName));

        try {
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
            for (String s : list) {
                w.write(s);
                w.newLine();
            }

            w.close();

        } catch (IOException ex) {
            logger.error(ex);
        }

    }

}
