package api_subscription_generator.grants;

import db.DbConnector;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import results.XMLforDA;
import settings.Settings;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import static settings.Settings.encoding;

public class RoleGrants {

    private static Logger logger;

    static {
        logger = Logger.getLogger(RoleGrants.class);
    }

    ArrayList<Privs> list = new ArrayList<>();
    PreparedStatement grantToSchemas = null;
    String query = "SELECT 'O' as state, tp.grantee, tp.owner, tp.table_name, ob.object_type, tp.grantor, \n"
            + "         tp.privilege, tp.grantable, tp.hierarchy\n"
            + "    FROM DBA_TAB_PRIVS tp\n"
            + "    LEFT JOIN DBA_ROLES ro\n"
            + "      ON ro.ROLE = tp.GRANTEE\n"
            + "    JOIN DBA_OBJECTS ob\n"
            + "      ON ob.OWNER = tp.OWNER\n"
            + "         AND ob.OBJECT_NAME = tp.TABLE_NAME\n"
            + "         AND ob.object_type NOT IN ('PACKAGE BODY',\n"
            + "                                    'TYPE BODY')\n"
            + "   WHERE tp.owner = ?\n"
            + "         AND ro.ROLE = 'DBREAD'\n"
            + " UNION ALL\n"
            + "SELECT 'N' as state, \n"
            + "       'DBREAD' AS grantee,\n"
            + "       owner AS owner,\n"
            + "       o.OBJECT_NAME AS table_name,\n"
            + "       o.OBJECT_TYPE,\n"
            + "       owner AS grantor,\n"
            + "       'SELECT ' AS privilege,\n"
            + "       'NO' AS grantable,\n"
            + "       'NO' AS hierarchy\n"
            + "  FROM DBA_OBJECTS o\n"
            + " WHERE o.OBJECT_TYPE IN ('TABLE',\n"
            + "                         'VIEW')\n"
            + "       AND o.owner = ?\n"
            + "       AND o.OBJECT_NAME NOT IN\n"
            + "       (SELECT tp.TABLE_NAME\n"
            + "              FROM DBA_TAB_PRIVS tp\n"
            + "             WHERE tp.owner = o.OWNER\n"
            + "                   AND grantee = 'DBREAD')  \n"
            + "  ORDER BY table_name";

    public void generate(String schemaName) {
        ResultSet rs = null;
        list.clear();
        try {

            Connection connection = DbConnector.connectToDb();
            grantToSchemas = connection.prepareStatement(query);

            grantToSchemas.setString(1, schemaName);
            grantToSchemas.setString(2, schemaName);

            rs = grantToSchemas.executeQuery();

            while (rs.next()) {

                Privs pr = new Privs();
                if (rs.isFirst()) {
                    pr.setState("STATE");
                    pr.setGrantee("GRANTEE");
                    pr.setGrantor("GRANTOR");
                    pr.setGrantable("GRANTABLE");
                    pr.setHierarchy("HIERARCHY");
                    pr.setObjectType("OBJECT_TYPE");
                    pr.setOwner("OWNER");
                    pr.setPrivilege("PRIVILEGE");
                    pr.setTableName("TABLE_NAME");
                    list.add(pr);
                    pr = new Privs();

                }
                pr.setState(rs.getString("STATE"));
                pr.setGrantee(rs.getString("GRANTEE"));
                pr.setGrantor(rs.getString("GRANTOR"));
                pr.setGrantable(rs.getString("GRANTABLE"));
                pr.setHierarchy(rs.getString("HIERARCHY"));
                pr.setObjectType(rs.getString("OBJECT_TYPE"));
                pr.setOwner(rs.getString("OWNER"));
                pr.setPrivilege(rs.getString("PRIVILEGE"));
                pr.setTableName(rs.getString("TABLE_NAME"));

                list.add(pr);
            }

            rs.close();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    public void toFile(String fileName) {

        File file = new File(Files.getName(fileName));

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
            for (Privs s : list) {
                w.write(s.toString());
                w.newLine();
            }
            w.close();
        } catch (IOException ex) {
            logger.error(ex);
        }

    }

    public void toXLS(String fileName) {

        try {
            InputStream inp = new FileInputStream(Settings.srcRoles + Settings.pristupovaMatice);
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.createSheet(fileName);
            String currentLine = null;
            int RowNum = 0;

            CellStyle borderStyle = wb.createCellStyle();
            borderStyle.setBorderBottom(CellStyle.BORDER_THIN);
            borderStyle.setBorderLeft(CellStyle.BORDER_THIN);
            borderStyle.setBorderRight(CellStyle.BORDER_THIN);
            borderStyle.setBorderTop(CellStyle.BORDER_THIN);
            borderStyle.setAlignment(CellStyle.ALIGN_LEFT);

            CellStyle yellowStyle = wb.createCellStyle();
            yellowStyle.cloneStyleFrom(borderStyle);
            yellowStyle.setFillPattern(HSSFCellStyle.LEAST_DOTS);
            yellowStyle.setFillForegroundColor(new HSSFColor.YELLOW().getIndex());
            yellowStyle.setFillBackgroundColor(new HSSFColor.YELLOW().getIndex());

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(Settings.srcRoles + fileName + ".csv"), encoding));
            FileOutputStream outputStream = new FileOutputStream(Settings.srcRoles + Settings.pristupovaMatice);

            while ((currentLine = inputStream.readLine()) != null) {

                if (RowNum >= 0) {

                    String str[] = currentLine.split(";");

                    Row currentRow = sheet.createRow(RowNum);
                    Boolean yellow = false;
                    for (int i = 0; i < str.length; i++) {

                        if (i == 0 && str[i].equals("N")) {
                            yellow = true;
                        }

                        if (i > 0) {
                            Cell c = currentRow.createCell(i - 1);
                            c.setCellValue(str[i]);
                            c.setCellStyle(borderStyle);
                            if (yellow) {
                                c.setCellStyle(yellowStyle);
                            }
                        }
                    }

                }
                RowNum++;
            }

            wb.write(outputStream);
            outputStream.close();
            inputStream.close();

        } catch (IOException | InvalidFormatException ex) {
            java.util.logging.Logger.getLogger(XMLforDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
