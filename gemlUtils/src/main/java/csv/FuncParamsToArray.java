package csv;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.log4j.Logger;
import util.FilesCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static settings.Settings.encoding;

public class FuncParamsToArray {

    private static Logger logger;

    static {
        logger = Logger.getLogger(FuncListDb.class);
    }

    private List<FuncParamsCsv> paramsCsv = new ArrayList<>();

    public void toParmsList(String apiFuncParamsSrc, String apiFuncParamsTarg) {

        int i = 0;

        try {
            File apiFuncParamsTarget = new File(apiFuncParamsTarg);
            if (!apiFuncParamsSrc.equals("")) {
                File apiFuncParamsSource = new File(apiFuncParamsSrc);
                FilesCopy fc = new FilesCopy(apiFuncParamsSource, apiFuncParamsTarget);
            }
            CSVReader reader1 = new CSVReader(new InputStreamReader(new FileInputStream(apiFuncParamsTarget), encoding), ';', '"', 1);
            List<String[]> csvArr = reader1.readAll();

            for (Object object : csvArr) {
                String[] row = (String[]) object;
                try {
                    paramsCsv.add(new FuncParamsCsv(row));
                } catch (Exception e) {
                    logger.info(row[0]);
                    System.exit(0);
                }
            }

            logger.info("Func Params " + paramsCsv.size());

        } catch (IOException sqle) {
            logger.error(sqle);
        }
    }

    public List<FuncParamsCsv> getFuncParamsCsv() {
        return paramsCsv;
    }
}
