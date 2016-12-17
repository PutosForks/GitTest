package results;

import api_subscription_generator.Api_subscription_generator;
import csv.CompareLists;
import csv.FuncParamsCsv;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import util.FilesCopy;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static settings.Settings.encoding;

public class XMLforDA {

    private static org.apache.log4j.Logger logger;

    static {
        logger = org.apache.log4j.Logger.getLogger(Api_subscription_generator.class);
    }

    public XMLforDA(CompareLists c1, CompareLists c2) {

        String quote = "\'";
        Set<FuncParamsCsv> funsParams = new HashSet<>();

        funsParams.addAll(c2.getHc());

        try {
            File f1 = new File("files\\templates\\API_predpisy.xls");
            File f2 = new File("files\\DaSubscription\\API_predpisy.xls");

            new FilesCopy(f1, f2);

            InputStream inp = new FileInputStream("files\\DaSubscription\\API_predpisy.xls");
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            String currentLine = null;
            int RowNum = 0;

            CellStyle my_style = wb.createCellStyle();
            my_style.setFillPattern(HSSFCellStyle.LEAST_DOTS);
            my_style.setFillForegroundColor(new HSSFColor.YELLOW().getIndex());
            my_style.setFillBackgroundColor(new HSSFColor.YELLOW().getIndex());

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files\\DaSubscription\\v_api_xls_func.csv"), encoding));

            while ((currentLine = br.readLine()) != null) {

                if (RowNum > 0) {

                    String str[] = currentLine.split("\";\"");

                    Row currentRow = sheet.createRow(RowNum);
                    for (int i = 0; i < str.length; i++) {

                        currentRow.createCell(i).setCellValue(str[i].replace("\"", ""));

                        if (c1.getDiffsFunc().contains(str[0].replace("\"", ""))) {
                            Cell c = currentRow.getCell(i);
                            c.setCellStyle(my_style);
                        }

                    }
                }
                RowNum++;
            }

            FileOutputStream fileOut = new FileOutputStream("files\\DaSubscription\\API_predpisy.xls");

            wb.write(fileOut);
            fileOut.close();

            sheet = wb.getSheetAt(1);
            currentLine = null;
            RowNum = 0;

            BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("files\\DaSubscription\\v_api_xls_params.csv"), encoding));

            while ((currentLine = br2.readLine()) != null) {

                if (RowNum > 0) {
                    String str[] = currentLine.split("\";\"");
                    Row currentRow = sheet.createRow(RowNum);
                    for (int i = 0; i < str.length; i++) {
                        currentRow.createCell(i).setCellValue(str[i].replace("\"", ""));

                        for (Iterator<FuncParamsCsv> it = funsParams.iterator(); it.hasNext(); ) {
                            FuncParamsCsv fp = it.next();

                            try {
                                if (fp.getSystemApiName().equalsIgnoreCase(str[1].replace("\"", ""))
                                        && fp.getParameterName().equalsIgnoreCase(str[3].replace("\"", ""))) {
                                    Cell c = currentRow.getCell(i);
                                    c.setCellStyle(my_style);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(XMLforDA.class.getName()).log(Level.SEVERE, null, currentLine);
                                Logger.getLogger(XMLforDA.class.getName()).log(Level.SEVERE, null, ex);
                                System.exit(0);
                            }
                        }
                    }
                }
                RowNum++;
            }

            fileOut = new FileOutputStream("files\\DaSubscription\\API_predpisy.xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(XMLforDA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
