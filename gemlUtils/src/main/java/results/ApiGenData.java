package results;

import csv.CompareLists;
import org.apache.log4j.Logger;
import util.FilesCopy;

import java.io.*;
import java.sql.*;

import static settings.Settings.encoding;

public class ApiGenData {

    private static Logger logger;

    static {
        logger = Logger.getLogger(ApiGenData.class);
    }

    Connection con;

    void WriteApiService(BufferedWriter w) throws IOException, SQLException {
        String lastService = null;
        String serviceQuery = null;
        String paramQuery = null;

        String query = "      SELECT par.api_service AS API_SERVICE_ID,\n"
                + "           par.ID AS PARAM_ID,\n"
                + "           ser.NAME AS API_NAME,\n"
                + "           ser.PACKAGE,\n"
                + "           ser.name AS API_PROCEDURE,\n"
                + "           par.ENAME,\n"
                + "           par.TYPE,\n"
                + "           par.FORMAT,\n"
                + "           par.DEFAULT_VALUE,\n"
                + "           par.DIRECTION,\n"
                + "           par.DATA_TYPE\n"
                + "      FROM api_service ser\n"
                + "     INNER JOIN api_param par\n"
                + "        ON par.api_service = ser.id\n"
                + "     ORDER BY par.api_service ASC, par.ID ASC";

        Statement s = con.createStatement();
        ResultSet r = s.executeQuery(query);
        w.write("DELETE FROM api_param;");
        w.newLine();
        w.write("DELETE FROM api_service;");
        w.newLine();

        while (r.next()) {

            if (!r.getString(1).equals(lastService)) {
                String str = "INSERT INTO api_service (ID, NAME, PACKAGE, PROCEDURE) VALUES (%d, \'%s\', \'%s\', \'%s\');";
                str = String.format(str, r.getInt(1), r.getString(3), r.getString(4), r.getString(5));
                w.write(str);
                w.newLine();
            }

            paramQuery = "INSERT INTO api_param (ID, API_SERVICE, ENAME, TYPE, FORMAT, DEFAULT_VALUE, DIRECTION, DATA_TYPE)\n"
                    + "VALUES(%s, %s, \'%s\', \'%s\', \'%s\', \'%s\', \'%s\', \'%s\');";
            serviceQuery = String.format(paramQuery, r.getInt(2), r.getInt(1), r.getString(6), r.getString(7),
                    r.getString(8) != null ? r.getString(8) : "",
                    r.getString(9) != null ? r.getString(9) : "",
                    r.getString(10), r.getString(11));
            w.write(serviceQuery);
            w.newLine();
            lastService = r.getString(1);

        }
    }

    public void ResultToFiles() {
        try {
            this.con = db.DbConnector.connectToDb();
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("files/GENApiData.sql"), encoding));

            WriteApiService(w);
            w.close();
            this.con.close();

            File sourceFile = new File("files/GENApiData.sql");
            File targetFile = new File("../../dev/data/GENApiData.sql");

            new FilesCopy(sourceFile, targetFile);
            logger.info(targetFile + " created!");

        } catch (SQLException | IOException ex) {
            logger.error(ex);
        }

    }

    public void importDefinitions(CompareLists c) {

        String apis = c.getDiffs2String("|").replace("\'", "").trim();

        if (c.diffs.size() != 0) {
            try {
                con = db.DbConnector.connectToDb();
                CallableStatement call = con.prepareCall("{call api.importDefinitionServices(?)}");
                call.setString(1, apis);
                call.executeUpdate();
            } catch (SQLException ex) {
                logger.error(ex);
            }
        }

    }

    public void writeApiGenTable(CompareLists c) {
        String apis = c.getDiffs2String("|").replace("\'", "").trim();

        try {
            this.con = db.DbConnector.connectToDb();
            CallableStatement call = con.prepareCall("{call pck_utl_api.generate_rowset_API(?)}");
            call.setString(1, apis);
            call.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

}
