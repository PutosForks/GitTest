package results;

import api_subscription_generator.Api_subscription_generator;
import org.apache.log4j.Logger;
import util.FilesCopy;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static settings.Settings.encoding;

public final class ResultToFiles {

    private static Logger logger;

    static {
        logger = Logger.getLogger(Api_subscription_generator.class);
    }

    Connection con;

    String Intro = "DELETE FROM api_func_params p;\n"
            + "DELETE FROM api_result_sets r;\n"
            + "DELETE FROM api_func_list f;\n"
            + "\n"
            + "-- insert into api_func_list\n";
    String FuncList = "select 'insert into api_func_list(fnc_id,fnc_ver,ufo_name,env_name,proc_name,fnc_desc,api_type,fb_name,body_template,mq_class, definition_version) values('''||fnc_id||''','''||fnc_ver||''','''||ufo_name||''','''||env_name||''','''||proc_name||''','''||fnc_desc||''','''||api_type||''','''||fb_name||''','''||body_template||''','''||mq_class||''','''||definition_version||''');' from api_func_list order by fnc_id";
    String ParamsList = "select 'insert into api_func_params(fnc_id,fnc_ver,prm_name,direction,obligatory,db_order,data_type,generic_len,data_accurancy,data_default,rs_id,prm_desc,ufo_type,ufo_listcode,generic_type,table_name,column_name,imp_table_name,imp_column_name,flag) values('''||fnc_id||''','''||fnc_ver||''','''||prm_name||''','''||direction||''','''||obligatory||''','''||db_order||''','''||data_type||''','''||generic_len||''','''||data_accurancy||''','''||data_default||''','''||rs_id||''','''||prm_desc||''','''||ufo_type||''','''||ufo_listcode||''','''||generic_type||''','''||table_name||''','''||column_name||''','''||imp_table_name||''','''||imp_column_name||''','''||flag||''');' from api_func_params order by fnc_id, prm_name";
    String ResultSetList = "select 'insert into api_result_sets(rs_id,prm_name,db_order,table_name,column_name,imp_table_name,imp_column_name,data_type,generic_type,generic_len,data_accurancy,data_default,ufo_type,ufo_listcode,prm_desc,user_rs,flag) values('''||rs_id||''','''||prm_name||''','''||db_order||''','''||table_name||''','''||column_name||''','''||imp_table_name||''','''||imp_column_name||''','''||data_type||''','''||generic_type||''','''||generic_len||''','''||data_accurancy||''','''||data_default||''','''||ufo_type||''','''||ufo_listcode||''','''||prm_desc||''','''||user_rs||''','''||flag||''');' from api_result_sets order by rs_id, prm_name";

    void WriteResult(BufferedWriter w, String query) throws IOException, SQLException {
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery(query);
        while (r.next()) {
            w.write(r.getString(1));
            w.newLine();
        }
    }

    public ResultToFiles() {
        try {
            this.con = db.DbConnector.connectToDb();
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("files/api_tif_def.sql"), encoding));

            w.write(Intro);
            WriteResult(w, FuncList);
            WriteResult(w, ParamsList);
            WriteResult(w, ResultSetList);

            w.close();

            File sourceFile = new File("files/api_tif_def.sql");
            File targetFile = new File("../../dev/data/api_tif_def.sql");

            new FilesCopy(sourceFile, targetFile);

        } catch (SQLException | IOException ex) {
            logger.error(ex);
        }
    }

    public static void main(String[] args) {
        ResultToFiles rs = new ResultToFiles();
    }

}
