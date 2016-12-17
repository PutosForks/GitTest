package csv;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncList {

    protected static int insCount = 0;
    private String fncId = null;
    private Integer fncVer = null;
    private String ufoName = null;
    private String envName = null;
    private String procName = null;
    private String fncDesc = null;
    private String apiType = null;
    private String fbName = null;
    private String bodyTemplate = null;
    private String mqClass = null;
    private String definitionVersion = null;

    FuncList() {
    }

    FuncList(String fncId,
             Integer fncVer,
             String ufoName,
             String envName,
             String procName,
             String fncDesc,
             String apiType,
             String fbName,
             String BodyTemplate,
             String mqClass,
             String definitionVersion) {
        set(fncId, fncVer, ufoName, envName, procName, fncDesc, apiType, fbName, BodyTemplate, mqClass, definitionVersion);
    }

    final void set(String fncId,
                   Integer fncVer,
                   String ufoName,
                   String envName,
                   String procName,
                   String fncDesc,
                   String apiType,
                   String fbName,
                   String BodyTemplate,
                   String mqClass,
                   String definitionVersion) {

        this.fncId = fncId;
        this.fncVer = fncVer;
        this.ufoName = ufoName;
        this.envName = envName;
        this.procName = procName;
        this.fncDesc = fncDesc;
        this.apiType = apiType;
        this.fbName = fbName;
        this.bodyTemplate = BodyTemplate;
        this.mqClass = mqClass;
        this.definitionVersion = definitionVersion;
    }

    protected void insertFuncList(PreparedStatement ps) throws SQLException {
        ps.setString(1, this.fncId);
        ps.setInt(2, this.fncVer);
        ps.setString(3, this.ufoName);
        ps.setString(4, this.envName);
        ps.setString(5, this.procName);
        ps.setString(6, this.fncDesc);
        ps.setString(7, this.apiType);
        ps.setString(8, this.fbName);
        ps.setString(9, this.bodyTemplate);
        ps.setString(10, this.mqClass);
        ps.setString(11, this.definitionVersion);

        ps.executeUpdate();
        insCount++;

    }

    @Override
    public String toString() {
        return this.fncId + ";"
                + this.fncVer + ";"
                + this.ufoName + ";"
                + this.envName + ";"
                + this.procName + ";"
                + this.fncDesc + ";"
                + this.apiType + ";"
                + this.fbName + ";"
                + this.bodyTemplate + ";"
                + this.mqClass + ";"
                + this.definitionVersion;
    }

    /**
     * @return the fncId
     */
    public String getFncId() {
        return fncId;
    }

    /**
     * @return the fncVer
     */
    public Integer getFncVer() {
        return fncVer;
    }

    /**
     * @return the ufoName
     */
    public String getUfoName() {
        return ufoName;
    }

    /**
     * @return the envName
     */
    public String getEnvName() {
        return envName;
    }

    /**
     * @return the procName
     */
    public String getProcName() {
        return procName;
    }

    /**
     * @return the fncDesc
     */
    public String getFncDesc() {
        return fncDesc;
    }

    /**
     * @return the apiType
     */
    public String getApiType() {
        return apiType;
    }

    /**
     * @return the fbName
     */
    public String getFbName() {
        return fbName;
    }

    /**
     * @return the BodyTemplate
     */
    public String getBodyTemplate() {
        return bodyTemplate;
    }

    /**
     * @return the mqClass
     */
    public String getMqClass() {
        return mqClass;
    }

    /**
     * @return the definitionVersion
     */
    public String getDefinitionVersion() {
        return definitionVersion;
    }

    public static int getInsCount() {
        return insCount;
    }
}
