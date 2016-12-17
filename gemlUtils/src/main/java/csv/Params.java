package csv;

public class Params {

    private String fncId = null;
    private String rsId = null;
    public String prmName = null;
    private String dbOrder = null;
    private String tableName = null;
    private String columnName = null;
    private String impTableName = null;
    private String fbName = null;
    private String impColumnName = null;
    private String dataType = null;
    private String genericType = null;
    private String genericLen = null;
    private String dataAccurancy = null;
    private String dataDefault = null;
    private String ufoType = null;
    private String ufoListcode = null;
    private String prmDesc = null;
    private String flag = null;
    private String definitionVersion = null;
    private String direction = null;

    static String prevFncId;
    //  public static int counter = 0;

//       public Params() {
//        this.fncId = null;
//        this.rsId = null;
//        this.prmName = null;
//        this.dbOrder = null;
//        this.tableName = null;
//        this.columnName = null;
//        this.impTableName = null;
//        this.impColumnName = null;
//        this.dataType = null;
//        this.genericType = null;
//        this.genericLen = null;
//        this.dataAccurancy = null;
//        this.dataDefault = null;
//        this.ufoType = null;
//        this.ufoListcode = null;
//        this.prmDesc = null;
//        this.flag = null;
//        this.direction = null;
//    }


    public void set(String fncId,
                    String rsId,
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
                    String flag,
                    String direction) {
        this.fncId = fncId;
        this.rsId = rsId;
        this.prmName = prmName;
        this.dbOrder = dbOrder;
        this.tableName = tableName;
        this.columnName = columnName;
        this.impTableName = impTableName;
        this.impColumnName = impColumnName;
        this.dataType = dataType;
        this.genericType = genericType;
        this.genericLen = genericLen;
        this.dataAccurancy = dataAccurancy;
        this.dataDefault = dataDefault;
        this.ufoType = ufoType;
        this.ufoListcode = ufoListcode;
        this.prmDesc = prmDesc;
        this.flag = flag;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "FncId " + getFncId() + ";"
                + "PrmName " + getPrmName() + ";"
                + "DbOrder" + getDbOrder() + ";"
                + "DataType " + getDataType() + ";"
                + "GenericLen " + getGenericLen() + ";"
                + "DataAccurancy " + getDataAccurancy() + ";"
                + "DataDefault " + getDataDefault() + ";"
                + "RsId " + getRsId() + ";"
                + "PrmDesc " + getPrmDesc() + ";"
                + "UfoType " + getUfoType() + ";"
                + "UfoListcode " + getUfoListcode() + ";"
                + "GenericType " + getGenericType() + ";"
                + "TableName " + getTableName() + ";"
                + "ColumnName " + getColumnName() + ";"
                + "ImpTableName " + getImpTableName() + ";"
                + "ImpColumnName " + getImpColumnName() + ";"
                + "Flag " + getFlag();

    }

    public void setRsId(String rsId) {
        this.rsId = rsId;
    }

    public void setFncInfo(String definitionVersion, String fbName) {
        this.definitionVersion = definitionVersion;
        this.fbName = fbName;
    }

    public String getDefinitionVersion() {
        return definitionVersion;
    }

    public String getFncId() {
        return fncId;
    }

    public String getRsId() {
        return rsId;
    }

    public String getPrmName() {
        return prmName;
    }

    public String getDbOrder() {
        return dbOrder;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getImpTableName() {
        return impTableName;
    }

    public String getImpColumnName() {
        return impColumnName;
    }

    public String getDataType() {
        return dataType;
    }

    public String getGenericType() {
        return genericType;
    }

    public String getGenericLen() {
        return genericLen;
    }

    public String getDataAccurancy() {
        return dataAccurancy;
    }

    public String getDataDefault() {
        return dataDefault;
    }

    public String getUfoType() {
        return ufoType;
    }

    public String getUfoListcode() {
        return ufoListcode;
    }

    public String getPrmDesc() {
        return prmDesc;
    }

    public String getFlag() {
        return flag;
    }

    public String getFbName() {
        return fbName;
    }

    public String getDirection() {
        return direction;
    }
}
