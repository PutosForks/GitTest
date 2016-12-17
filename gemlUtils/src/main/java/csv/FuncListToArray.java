package csv;

import api_subscription_generator.Api_subscription_generator;
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

public class FuncListToArray {

    private static Logger logger;

    static {
        logger = Logger.getLogger(Api_subscription_generator.class);
    }

    private List<FuncListCsv> funcListCsv = new ArrayList<>();

    public void toFuncList(String apiFuncSrc, String apiFuncTarg) {

        try {
            File apiFuncTarget = new File(apiFuncTarg);
            if (!apiFuncSrc.equals("")) {
                File apiFuncSource = new File(apiFuncSrc);
                new FilesCopy(apiFuncSource, apiFuncTarget);
            }

            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(apiFuncTarget), encoding), ';', '"', 1);
            List<String[]> FuncListArr = reader.readAll();

            for (Object object : FuncListArr) {
                String[] Row = (String[]) object;
                funcListCsv.add(new FuncListCsv(Row));
            }

        } catch (IOException e) {
            logger.error(e);
        }

    }

    public List<FuncListCsv> getFuncListCSV() {
        return funcListCsv;
    }

}
