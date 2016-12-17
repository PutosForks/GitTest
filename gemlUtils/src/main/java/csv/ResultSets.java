package csv;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;

public class ResultSets extends Params {

    public static int insCount = 0;
    private String userRs = null;
    final static private Deque<String> LastRs = new ArrayDeque<>();
    private static String previousRsid;
    public static int counter = 0;
    public static String RsFncId = null;

    public void set(
            String FncId,
            String prmName,
            String dbOrder,
            String tableName,
            String columnName,
            String impTableName,
            String impColumnName,
            String dataType,
            String genericType,
            String genericLen,
            String dataAccurancy,
            String dataDefault,
            String ufoType,
            String ufoListcode,
            String prmDesc,
            String userRs,
            String flag,
            String direction) {

        super.set(FncId,
                null,
                prmName,
                dbOrder,
                tableName,
                columnName,
                impTableName,
                impColumnName,
                dataType,
                genericType,
                genericLen,
                dataAccurancy,
                dataDefault,
                ufoType,
                ufoListcode,
                prmDesc,
                flag,
                direction);

        this.setUserRs(userRs);

    }

    public void insertResultSet(PreparedStatement ps) throws SQLException {

        ps.setString(1, getRsId());
        ps.setString(2, getPrmName());
        ps.setInt(3, Integer.parseInt(getDbOrder()));  // DbOrder
        ps.setString(4, getTableName());
        ps.setString(5, getColumnName());
        ps.setString(6, getImpTableName());
        ps.setString(7, getImpColumnName());
        ps.setString(8, getDataType());
        ps.setString(9, getGenericType()); // ps.setString(9, this.genericType);
        ps.setString(10, getGenericLen());
        ps.setString(11, getDataAccurancy());
        ps.setString(12, getDataDefault());
        ps.setString(13, getUfoType());
        ps.setString(14, getUfoListcode());
        ps.setString(15, getPrmDesc());
        ps.setString(16, "0");
        ps.setString(17, getFlag());

        ps.executeUpdate();
        insCount++;

    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder(super.toString());
        str.append("UserRs ").append(getUserRs()).append(";");

        return str.toString();
    }

    public String getUserRs() {
        return userRs;
    }

    public void setUserRs(String userRs) {
        this.userRs = userRs;
    }

    public static int getInsCount() {
        return insCount;
    }

    @Override
    public String getRsId() {
        return FuncParams.getRsName();
    }

    public static String getLastRs() {
        try {
            return LastRs.getLast();
        } catch (Exception e) {
            return "";
        }
    }

    public String getDbOrder() {
        Integer ReturnValue;

        if (FuncParams.getInputSetFnc().equals(getFncId()) && getDefinitionVersion().equals("1.0")) {

            if (!getLastRs().equals(getRsId())) {

                if (getDefinitionVersion().equals("1.0")) {
                    RsFncId = getFncId();
                }

                LastRs.add(getRsId());
                ReturnValue = FuncParams.counter;

            } else {
                ReturnValue = ++FuncParams.counter;
            }
        } else {
            if (!getLastRs().equals(getRsId())) {
                counter = 1;
                LastRs.add(getRsId());
                ReturnValue = counter;

            } else {
                ReturnValue = ++counter;

            }
        }

        return "" + ReturnValue;

    }

    @Override
    public String getGenericType() {
        String genericType = super.getGenericType();

        if (getFbName().equals("RAPI")) {
            if (genericType.equals("LONG")) {
                genericType = "INTEGER";
            } else if (genericType.equals("VARCHAR") || genericType.equals("CHAR") || genericType.equals("CLOB")) {
                genericType = "STRING";
            } else if (genericType.equals("DATE") && super.getUfoType().equals("HDatumCas")) {
                genericType = "DATETIME";
            } else if (genericType.equals("NUMBER") && super.getUfoType().equals("HCislo")
                    && getGenericLen().equals("") && getDataAccurancy().equals("0")) {
                genericType = "INTEGER";
            } else if (genericType.equals("NUMBER") && super.getUfoType().equals("HCislo")) {
                genericType = "FLOAT";
            }
        }

        if (getFbName().equals("UAPI") || getFbName().equals("SAPI")) {
            if (genericType.equals("INTEGER")) {
                genericType = "LONG";
            } else if (genericType.equals("FLOAT") || genericType.equals("NUMBER")) {
                genericType = "DOUBLE";
            } else if (genericType.equals("VARCHAR") || genericType.equals("CHAR") || genericType.equals("CLOB")) {
                genericType = "STRING";
            } else if (genericType.equals("DATE") && getDataAccurancy().equals("1")) {
                genericType = "DATETIME";
            }
        }

        return genericType;

    }

    public String getUfoType() {

        String UfoType = super.getUfoType();
        if (getFbName().equals("RAPI")
                && (super.getUfoType().equals("HDatum")
                || super.getUfoType().equals("HDatumCas")
                || super.getUfoType().equals("HRetezec")
                || super.getUfoType().equals("HCele")
                || super.getUfoType().equals("HCislo"))) {

            UfoType = null;
        }

        return UfoType;

    }

}
