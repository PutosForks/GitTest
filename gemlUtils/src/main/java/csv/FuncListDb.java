package csv;

import db.DbConnector;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class FuncListDb {

    public List<FuncList> funcList = new LinkedList<>();

    private static Logger logger;

    static {
        logger = Logger.getLogger(FuncListDb.class);
    }

    public void toDb(List<FuncListCsv> fo) {

        Connection connection;
        String funcListQuery = "insert into api_func_list (fnc_id, fnc_ver,ufo_name, env_name,proc_name, fnc_desc, api_type, fb_name, body_template, mq_class, definition_version) "
                + "  values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DbConnector.connectToDb();
            PreparedStatement ps = connection.prepareStatement(funcListQuery);
            Statement statement = connection.createStatement();

            statement.executeUpdate("delete from api_result_sets");
            logger.info("Deleted API_RESULT_SETS Rowcount: " + statement.getUpdateCount());
            statement.executeUpdate("delete from api_func_params");
            logger.info("Deleted API_FUNC_PARAMS Rowcount: " + statement.getUpdateCount());
            statement.executeUpdate("delete from api_func_list");
            logger.info("Deleted API_FUNC_LIST Rowcount: " + statement.getUpdateCount());

            for (FuncListCsv o : fo) {
                FuncList funclist;
                funclist = o.toFuncList();
                funclist.insertFuncList(ps);
                funcList.add(funclist);
            }

            logger.info("API_FUNC_LIST RowCount: " + funcList.size());

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

}
