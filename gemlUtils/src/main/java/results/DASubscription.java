package results;

import api_subscription_generator.Api_subscription_generator;
import au.com.bytecode.opencsv.CSVWriter;
import csv.CompareLists;
import db.DbConnector;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static settings.Settings.encoding;

public class DASubscription {

    Connection con;

    private static Logger logger;

    static {
        logger = Logger.getLogger(Api_subscription_generator.class);
    }

    public void createDaSubscriptions(CompareLists c) {

        Path p = Paths.get("files\\DaSubscription\\");
        String apis = c.getDiffs2String(",");
        if (!apis.equals("")) {
            logger.info("ALTERED APIs are: " + apis);
        }

        String query2 = "select *  from v_api_xls_func where \"System API name\" in (%s) order by rownum";
        String query3 = "select *  from v_api_xls_params where \"System API name\" in (%s) order by rownum";

        ResultSet r;

        try {
            con = DbConnector.connectToDb();
            Statement s = con.createStatement();
            try (CSVWriter w = new CSVWriter(new OutputStreamWriter(new FileOutputStream(p.toAbsolutePath() + "\\v_api_xls_func.csv"), encoding), ';', '"')) {
                query2 = String.format(query2, apis);

                r = s.executeQuery(query2);
                w.writeAll(r, true);
                r.close();
                w.close();

            }

            try (CSVWriter w = new CSVWriter(new OutputStreamWriter(new FileOutputStream(p.toAbsolutePath() + "\\v_api_xls_params.csv"), encoding), ';', '"')) {
                r = s.executeQuery(String.format(query3, apis));
                w.writeAll(r, true);
                r.close();
                w.close();

            }

        } catch (SQLException | IOException ex) {
            logger.error(ex);
        }

    }

}
