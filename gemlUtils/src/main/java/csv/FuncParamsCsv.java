package csv;

import java.util.Objects;

public class FuncParamsCsv {

    private String systemApiName = null;
    private String systemParameter = null;
    private String parameterName = null;
    private String directionParameter = null;
    private String parameterDirection = null;
    private String obligatory = null;
    private String parameterResultsetExists = null;
    private String dataType = null;
    private String length = null;
    private String defaultValue = null;
    private String accuracy = null;
    private String valueTypeName = null;
    private String codeListName = null;
    private String descriptionParameter = null;
    private String apiBundle = null;

    public void set(String systemApiName,
                    String systemParameter,
                    String parameterName,
                    String directionParameter,
                    String parameterDirection,
                    String obligatory,
                    String parameterResultsetExists,
                    String dataType,
                    String length,
                    String accuracy,
                    String defaultValue,
                    String valueTypeName,
                    String codeListName,
                    String descriptionParameter,
                    String apiBundle) {
        this.accuracy = accuracy.trim().replaceAll("\\s", "");
        this.apiBundle = apiBundle.trim().replaceAll("\\s", "");
        this.codeListName = codeListName.trim().replaceAll("\\s", "");
        this.dataType = dataType.trim().replaceAll("\\s", "");
        this.descriptionParameter = descriptionParameter.trim();
        this.directionParameter = directionParameter.trim().replaceAll("\\s", "");
        this.length = length.trim().replaceAll("\\s", "");
        this.defaultValue = defaultValue.trim().replaceAll("\\s", "");
        this.obligatory = obligatory.trim().replaceAll("\\s", "");
        this.parameterDirection = parameterDirection.trim().replaceAll("\\s", "");
        this.parameterName = parameterName.trim().replaceAll("\\s", "");
        this.parameterResultsetExists = parameterResultsetExists.trim().replaceAll("\\s", "");
        this.systemApiName = systemApiName.trim().replaceAll("\\s", "");
        this.systemParameter = systemParameter.trim().replaceAll("\\s", "");
        this.valueTypeName = valueTypeName.trim().replaceAll("\\s", "");

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.systemApiName);
        hash = 89 * hash + Objects.hashCode(this.systemParameter);
        hash = 89 * hash + Objects.hashCode(this.parameterName);
        hash = 89 * hash + Objects.hashCode(this.directionParameter);
        hash = 89 * hash + Objects.hashCode(this.parameterDirection);
        hash = 89 * hash + Objects.hashCode(this.obligatory);
        hash = 89 * hash + Objects.hashCode(this.parameterResultsetExists);
        hash = 89 * hash + Objects.hashCode(this.dataType);
        hash = 89 * hash + Objects.hashCode(this.descriptionParameter);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FuncParamsCsv other = (FuncParamsCsv) obj;
        if (!Objects.equals(this.systemApiName, other.systemApiName)) {
            return false;
        }
        if (!Objects.equals(this.systemParameter, other.systemParameter)) {
            return false;
        }
        if (!Objects.equals(this.parameterName, other.parameterName)) {
            return false;
        }
        if (!Objects.equals(this.directionParameter, other.directionParameter)) {
            return false;
        }
        if (!Objects.equals(this.parameterDirection, other.parameterDirection)) {
            return false;
        }
        if (!Objects.equals(this.obligatory, other.obligatory)) {
            return false;
        }
        if (!Objects.equals(this.descriptionParameter, other.descriptionParameter)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.systemApiName;
    }

    public void set(String[] s) {
        set(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11], s[12], s[13], s[14]);
    }

    public FuncParamsCsv(String[] s) {
        set(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11], s[12], s[13], s[14]);
    }

    public FuncParams toFuncParams() {
        FuncParams fp = new FuncParams();

        String tableName = null;
        String columnName = null;

        String[] s = this.systemParameter.split("\\.");

        try {
            tableName = s[0];
            columnName = s[1];
        } catch (IndexOutOfBoundsException ie) {
            tableName = null;
            columnName = null;

        }

        fp.set(
                this.systemApiName,
                "1",
                this.parameterName,
                this.parameterDirection,
                this.obligatory,
                this.directionParameter,
                this.dataType,
                this.length,
                this.accuracy,
                this.defaultValue,
                null, //String rsId (doplnujeme pozdeji)
                this.descriptionParameter,
                this.valueTypeName,
                this.codeListName,
                this.dataType, //String genericType,
                tableName, //String tableName,
                columnName, //String tableName,
                tableName, //String impTableName,
                columnName, //String impColumnName,
                null //flag)
        );

        return fp;
    }

    public ResultSets toResultSets() {
        ResultSets rs = new ResultSets();

        String tableName = null;
        String columnName = null;

        String[] s = this.systemParameter.split("\\.");

        try {
            tableName = s[0];
            columnName = s[1];
        } catch (IndexOutOfBoundsException ie) {
            tableName = null;
            columnName = null;

        }

        rs.set(
                this.systemApiName,
                this.parameterName,
                null, // as dbOrder
                tableName, //String tableName,
                columnName, //String tableName,
                tableName, //String impTableName,
                columnName, //String impColumnName,
                this.dataType,
                this.dataType, // genericType
                this.length,
                this.accuracy,
                this.defaultValue,
                this.valueTypeName, // ufoType
                this.codeListName,
                this.descriptionParameter,
                null, // userRs,
                null, //flag
                this.directionParameter);
        return rs;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getApiBundle() {
        return apiBundle;
    }

    public String getCodeListName() {
        return codeListName;
    }

    public String getDataType() {
        return dataType;
    }

    public String getDescriptionParameter() {
        return descriptionParameter;
    }

    public String getDirectionParameter() {
        return directionParameter;
    }

    public String getLength() {
        return length;
    }

    public String getObligatory() {
        return obligatory;
    }

    public String getParameterDirection() {
        return parameterDirection;
    }

    public String getParameterName() {
        return parameterName;
    }

    public String getParameterResultsetExists() {
        return parameterResultsetExists;
    }

    public String getSystemApiName() {
        return systemApiName;
    }

    public String getSystemParameter() {
        return systemParameter;
    }

    public String getValueTypeName() {
        return valueTypeName;
    }
}
