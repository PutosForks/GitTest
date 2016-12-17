package csv;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FuncParams extends Params {

    private static int insCount = 0;
    public static int counter = 0;
    final static private Deque<String> rsName = new ArrayDeque<>();
    final static private Deque<String> isInputSetFnc = new ArrayDeque<>();
    final static private List<String> fncName = new ArrayList<>();

    static String getRsName() {
        return rsName.getLast();
    }

    static void setInputSetFnc(String FuncId) {
        isInputSetFnc.add(FuncId);
    }

    public static String getInputSetFnc() {
        try {
            return isInputSetFnc.getLast();
        } catch (Exception e) {
            return "";
        }

    }

    static void setRsName(FuncParams fp) {
        int cnt = 0;

        for (String s : fncName) {
            if (s.equals(fp.getFncId())) {
                cnt++;
            }
        }

        if (cnt >= 1 && fp.getDefinitionVersion().equals("2.0")) {
            cnt++;
        }

        String cntStr = (cnt == 0) ? "" : "" + (cnt);

        fncName.add(fp.getFncId());

        if (fp.getDefinitionVersion().equals("2.0")) {
            rsName.add(fp.getFncId() + "_TAB" + cntStr);
        } else {
            rsName.add("RSU_" + cntStr + fp.getFncId());
        }

        fp.setRsId(rsName.getLast());
    }

    public static int getInsCount() {
        return insCount;
    }

    private String fncVer = null;
    private String obligatory = null;

    public void set(
            String fncId,
            String fncVer,
            String prmName,
            String direction,
            String obligatory,
            String dbOrder,
            String dataType,
            String genericLen,
            String dataAccurancy,
            String dataDefault,
            String rsId,
            String prmDesc,
            String ufoType,
            String ufoListcode,
            String genericType,
            String tableName,
            String columnName,
            String impTableName,
            String impColumnName,
            String flag) {

        super.set(fncId,
                rsId,
                prmName,
                null, // dbOrder
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

        this.fncVer = fncVer;
        this.obligatory = obligatory;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder(super.toString());
        str.append("FncVer ").append(getFncVer()).append(";");
        str.append("Direction ").append(getDirection()).append(";");
        str.append("Obligatory ").append(getObligatory());

        return str.toString();

    }

    protected void insertFuncParms(PreparedStatement ps) throws SQLException {
        ps.setString(1, getFncId());
        ps.setString(2, getFncVer());
        ps.setString(3, getPrmName());
        ps.setString(4, getDirection());
        ps.setString(5, getObligatory());
        ps.setInt(6, Integer.parseInt(getDbOrder()));
        ps.setString(7, getDataType());
        ps.setString(8, getGenericLen());
        ps.setString(9, getDataAccurancy());
        ps.setString(10, getDataDefault());
        ps.setString(11, getRsId());
        ps.setString(12, getPrmDesc());
        ps.setString(13, getUfoType());
        ps.setString(14, getUfoListcode());
        ps.setString(15, getGenericType());
        ps.setString(16, getTableName());
        ps.setString(17, getColumnName());
        ps.setString(18, getImpTableName());
        ps.setString(19, getImpColumnName());
        ps.setString(20, getFlag());

        ps.executeUpdate();
        insCount++;

    }

    @Override
    public String getDbOrder() {

        if (ResultSets.RsFncId != null) {
            counter = counter + 2;
            ResultSets.RsFncId = null;
        }

        if (prevFncId != null && getFncId().equals(prevFncId)) {
            counter++;
        } else {
            prevFncId = getFncId();
            counter = 1;
        }

        return "" + counter;
    }

    @Override
    public String getDirection() {
        switch (super.getDirection()) {
            case "IN":
                return "I";
            case "OUT":
                return "O";
            case "INOUT":
                return "U";
            default:
                return null;
        }
    }

    public String getObligatory() {

        switch (this.obligatory) {
            case "YES":
                return "Y";
            case "NO":
                return "N";
            default:
                return this.obligatory;
        }
    }

    @Override
    public String getDataType() {
        String DataType = super.getDataType();
        return DataType;
    }

//    @Override
//    public String getGenericLen() {
//        String genericLen = super.getGenericLen();

//        if ((getFbName().equals("EAPI") || getFbName().equals("RAPI")) && getDataType().equals("INTEGER") && genericLen.equals("0")) {
//            genericLen = null;
//        }
//
//        if (getFbName().equals("EAPI") && getDataType().equals("DATE")) {
//            genericLen = "7";
//        }
//
//        if (getFbName().equals("SAPI") && getDataType().equals("VARCHAR")) {
//            genericLen = null;
//        }
//
//        return genericLen;
//    }

    public String getFncVer() {
        return fncVer;
    }

    @Override
    public String getGenericType() {
        String genericType = super.getGenericType();

        if (getFbName().equals("RAPI")) {
            switch (genericType) {
                case "LONG":
                    genericType = "INTEGER";
                    break;
                case "ROWSET":
                    genericType = "RESULTSET";
                    break;
                case "VARCHAR":
                    genericType = "STRING";
                    break;
            }
        }

        if (getFbName().equals("UAPI") || getFbName().equals("SAPI")) {
            switch (genericType) {
                case "INTEGER":
                    genericType = "LONG";
                    break;
                case "FLOAT":
                case "NUMBER":
                    genericType = "DOUBLE";
                    break;
                case "VARCHAR":
                case "CHAR":
                case "CLOB":
                    genericType = "STRING";
                    break;
            }
        }

        if (getFbName().equals("EAPI")) {
            if (genericType.equals("VARCHAR") || genericType.equals("CHAR") || genericType.equals("CLOB")) {
                genericType = "STRING";
            } else if (genericType.equals("DATE") && getUfoType().equals("HDatumCas")) {
                genericType = "DATETIME";
            } else if (genericType.equals("NUMBER") && getUfoType().equals("HCislo")
                    && getGenericLen().equals("") && getDataAccurancy().equals("0")) {
                genericType = "INTEGER";
            } else if (genericType.equals("NUMBER") && getUfoType().equals("HCislo")) {
                genericType = "FLOAT";
            }
        }

        return genericType;
    }

}
