package csv;

import api_subscription_generator.Api_subscription_generator;
import db.DbConnector;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class FuncParamsDb {

    private static Logger logger;

    static {
        logger = Logger.getLogger(Api_subscription_generator.class);
    }

    private Connection connection;

    public Params[] toDb(List<FuncList> funcListArr, List<FuncParamsCsv> funcParamsArr) {

        FuncParams fp = null;
        ResultSets rs = null;
        int i = 0;
        Params[] p = new Params[funcParamsArr.size()];

        String funcParamsQuery = "INSERT INTO api_func_params (fnc_id, fnc_ver, prm_name, direction, obligatory, db_order, data_type, generic_len, data_accurancy, data_default, rs_id, prm_desc, ufo_type, ufo_listcode, generic_type, table_name, column_name, imp_table_name, imp_column_name, flag) "
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String ResultSetsQuery = " INSERT INTO api_result_sets (rs_id, prm_name, db_order, table_name, column_name, imp_table_name, imp_column_name, data_type, generic_type, generic_len, data_accurancy, data_default, ufo_type, ufo_listcode, prm_desc, user_rs, flag) "
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DbConnector.connectToDb();
            PreparedStatement ps = connection.prepareStatement(funcParamsQuery);
            PreparedStatement ps2 = connection.prepareStatement(ResultSetsQuery);

            for (Iterator<FuncParamsCsv> it = funcParamsArr.iterator(); it.hasNext(); ) {
                FuncParamsCsv param = it.next();
                p[i] = new Params();
                if (param.getParameterResultsetExists().equals("NO")) {

                    fp = param.toFuncParams();

                    for (FuncList funcList : funcListArr) {
                        if (fp.getFncId().equals(funcList.getFncId())) {
                            fp.setFncInfo(funcList.getDefinitionVersion(), funcList.getApiType());
                        }

                    }

                    if (param.getDataType().equals("RESULTSET") || param.getDataType().equals("ROWSET")) {
                        FuncParams.setRsName(fp);

                        if (fp.getDefinitionVersion().equals("1.0") && (fp.getDirection().equals("I") || fp.getDirection().equals("U"))) {
                            FuncParams.setInputSetFnc(fp.getFncId());
                        }

                    }

                    try {
                        fp.insertFuncParms(ps);
                    } catch (SQLException e) {
                        logger.error(fp);
                        logger.error(e);
                    }
                    p[i] = fp;

                } else {

                    rs = param.toResultSets();

                    for (FuncList funcList : funcListArr) {
                        if (rs.getFncId().equals(funcList.getFncId())) {
                            rs.setFncInfo(funcList.getDefinitionVersion(), funcList.getApiType());
                        }

                    }
                    try {
                        rs.insertResultSet(ps2);
                    } catch (SQLException e) {
                        logger.info(rs.getRsId());
                        logger.info(rs.getFncId());
                        logger.info(rs.prmName);
                        logger.error(ps2);
                        logger.error(e);
                    }
                    p[i] = rs;

                }
                i++;
            }

            logger.info("API_PARAMS_LIST RowCount: " + FuncParams.getInsCount());
            logger.info("API_RESULT_SETS RowCount: " + ResultSets.getInsCount());

            CallableStatement call = connection.prepareCall("{call PCK_UTL_API.GEN_TIF_PARAMS}");
            call.executeUpdate();

        } catch (SQLException sqle) {
            logger.error(sqle);
        }

        return p;
    }
}
