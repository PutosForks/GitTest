package package_change;

import java.io.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static db.DbConnector.setCredentials;

public class OutLog {

    String line;
    Integer lineNo = 0;
    String apiLine;
    String apiName;
    String logStr = null;
    static Connection connection;
    Map<Integer, String> map_ = new HashMap<>();

    String setLogStr() {

        if (this.apiName != "") {

            try {
                CallableStatement ps = connection.prepareCall("{call getOutParams(?, ?)}");

                ps.setString(1, this.apiName);
                ps.registerOutParameter(2, java.sql.Types.VARCHAR);

                ps.executeUpdate();

                if (ps.getString(2) == null) {
                    this.logStr = this.logStr;
                } else {
                    this.logStr = ps.getString(2);
                }

                ps.close();
            } catch (SQLException ex) {
                System.err.println(ex);

            }

        }

        return logStr;
    }

    void setLine(String line) {
        this.line = line;
    }

    void matchApiName(String l) {
        String s = null;
        Pattern p = Pattern.compile("PROCEDURE .+");
        Matcher m = p.matcher(l.trim());

        Boolean b = false;

        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            b = m.find(0);
            sb.append(m.group());
        }

        if (b) {
            s = sb.toString();
            s = s.substring(9, s.indexOf('(')).trim();
            this.apiName = s;
        } else {
            this.apiName = null;
        }

    }

    public static void main(String[] args) throws IOException, SQLException {

        setCredentials(args[0], args[1], args[2]);
        File file = new File("pck_api9.bdy");

        connection = db.DbConnector.connectToDb();
        int line_ = 0;
        ArrayList<String> arr = new ArrayList();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Windows-1250"));

            Integer lastLine = 0;
            OutLog log = new OutLog();

            do {

                log.lineNo++;
                String rl = (String) reader.readLine();
                log.matchApiName(rl);
                log.setLine(rl);
                log.setLogStr();

                if (log.logStr != null && rl.trim().equalsIgnoreCase("PCK_TIF.API_FINISH;")) {
                    rl = log.logStr;
                    log.logStr = null;
                }

                arr.add(rl);

            } while (!log.line.equals("END PCK_API9;"));

            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);

        } catch (IOException ie) {
            System.err.println(ie);
        }
    }

}
