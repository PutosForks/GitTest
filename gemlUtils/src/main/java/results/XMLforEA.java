package results;

import api_subscription_generator.Api_subscription_generator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import util.FilesCopy;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static settings.Settings.encoding;

public class XMLforEA {

    private static org.apache.log4j.Logger logger;
    List apis = new LinkedList();

    private String type;
    private String paramName;
    private String direction;
    private String obligation;
    private String resultSetParam;
    private String dataType;
    private String description;

    static {
        logger = org.apache.log4j.Logger.getLogger(Api_subscription_generator.class);
    }

    public XMLforEA() {
        String quote = "\'";

        try {
            File f1 = new File("files\\templates\\eaexcelimporter_v3.xls");
            File f2 = new File("files\\DaSubscription\\eaexcelimporter_v3.xls");

            new FilesCopy(f1, f2);

            InputStream inp = new FileInputStream("files\\DaSubscription\\eaexcelimporter_v3.xls");
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(6);
            String currentLine = null;
            int RowNum = 0;

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files\\DaSubscription\\v_api_xls_params.csv"), encoding));

            while ((currentLine = br.readLine()) != null) {

                if (RowNum > 0) {

                    paramName = null;
                    direction = null;
                    obligation = null;
                    resultSetParam = null;
                    dataType = null;
                    description = null;

                    String str[] = currentLine.split(";");
                    Row currentRow = sheet.createRow(RowNum);

                    if (!apis.contains(str[1])) {
                        apis.add(str[1]);
                        currentRow.createCell(0).setCellValue("Class");
                        currentRow.createCell(1).setCellValue(str[1].replace("\"", ""));
                        currentRow.createCell(2).setCellValue("API");
                        currentRow.createCell(3).setCellValue("Popis API");
                        currentRow.createCell(4).setCellValue("null");
                        currentRow.createCell(5).setCellValue("null");
                        currentRow.createCell(5).setCellValue("null");
                        RowNum++;
                        currentRow = sheet.createRow(RowNum);
                    }

                    paramName = str[3].replace("\"", "");
                    direction = str[7].replace("\"", "");
                    obligation = str[8].replace("\"", "");
                    resultSetParam = str[9].replace("\"", "");
                    dataType = str[10].replace("\"", "");

                    try {
                        description = str[18].replace("\"", "");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // do nothing
                    }

                    // determine type
                    if (dataType.equals("ROWSET") || dataType.equals("RESULTSET")) {
                        type = "AttributeRs";
                        dataType = "ROWSET";
                    } else if (resultSetParam.equals("YES")) {
                        type = "AttributeRsItem";
                    } else {
                        type = "Attribute";
                    }
                    currentRow.createCell(0).setCellValue(type);
                    currentRow.createCell(1).setCellValue(paramName);
                    currentRow.createCell(2).setCellValue("null");
                    currentRow.createCell(3).setCellValue(description);
                    currentRow.createCell(4).setCellValue(dataType.toUpperCase());
                    currentRow.createCell(5).setCellValue("null");
                    currentRow.createCell(6).setCellValue(obligation);
                }
                RowNum++;
            }

            FileOutputStream fileOut = new FileOutputStream("files\\DaSubscription\\eaexcelimporter_v3.xls");

            wb.write(fileOut);
            fileOut.close();
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(XMLforEA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        XMLforEA a = new XMLforEA();
    }

}
