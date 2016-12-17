package csv;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuncListCsv {


    private String systemApiName = null;
    private String nameApi = null;
    private String system = null;
    private String apiType = null;
    private String package_ = null;
    private String subPackage = null;
    private String versionApi = null;
    private String MQClass = null;
    private String definitionVersion = null;
    private String descriptionApi = null;
    private String fbName = null;

    Pattern p = Pattern.compile("[0-9]+");
    Matcher m;

    FuncListCsv() {
        this.systemApiName = null;
        this.nameApi = null;
        this.system = null;
        this.apiType = null;
        this.package_ = null;
        this.subPackage = null;
        this.versionApi = null;
        this.MQClass = null;
        this.definitionVersion = null;
        this.descriptionApi = null;
        this.fbName = null;
    }

    final void set(
            String systemApiName,
            String nameApi,
            String system,
            String apiType,
            String package_,
            String subPackage,
            String versionApi,
            String MQClass,
            String definitionVersion,
            String descriptionApi) {
        this.systemApiName = systemApiName.trim().replaceAll("\\s", "");
        this.nameApi = nameApi.trim().replaceAll("\\s", "");
        this.system = system.trim().replaceAll("\\s", "");
        this.apiType = (apiType == null || apiType.equals("")) ? "SAPI" : apiType.trim().replaceAll("\\s", "");
        this.package_ = package_.trim().replaceAll("\\s", "");
        this.subPackage = subPackage.trim().replaceAll("\\s", "");
        this.versionApi = versionApi.trim().replaceAll("\\s", "");
        this.MQClass = MQClass.trim();
        this.definitionVersion = definitionVersion.trim().replaceAll("\\s", "");
        this.descriptionApi = descriptionApi.trim();

        m = p.matcher(this.package_);

        StringBuilder sb = new StringBuilder();

        while (m.find()) {
            sb.append(m.group());
        }

        this.fbName = sb.toString();

    }

    @Override
    public String toString() {
        return this.systemApiName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.systemApiName);
        hash = 79 * hash + Objects.hashCode(this.system);
        hash = 79 * hash + Objects.hashCode(this.apiType);
        hash = 79 * hash + Objects.hashCode(this.package_);
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
        final FuncListCsv other = (FuncListCsv) obj;
        if (!Objects.equals(this.systemApiName, other.systemApiName)) {
            return false;
        }
        if (!Objects.equals(this.package_, other.package_)) {
            return false;
        }
        if (!Objects.equals(this.subPackage, other.subPackage)) {
            return false;
        }
        if (!Objects.equals(this.definitionVersion, other.definitionVersion)) {
            return false;
        }
        if (!Objects.equals(this.descriptionApi, other.descriptionApi)) {
            return false;
        }
        return true;
    }


    FuncListCsv(
            String systemApiName,
            String NameApi,
            String System,
            String Scheme,
            String Package,
            String subPackage,
            String VersionApi,
            String MQClass,
            String DefinitionVersion,
            String DescriptionApi) {
        set(systemApiName, NameApi, System, Scheme, Package, subPackage, VersionApi, MQClass, DefinitionVersion, DescriptionApi);
    }

    FuncListCsv(String[] params) {
        set(params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8], params[9]);
    }

    FuncList toFuncList() {
        FuncList fl = new FuncList(
                this.systemApiName,
                Integer.parseInt(this.versionApi),
                this.systemApiName,
                this.package_ + "." + this.systemApiName,
                this.subPackage + "." + this.systemApiName,
                this.descriptionApi,
                this.apiType,
                this.fbName,
                null,
                this.MQClass,
                this.definitionVersion);
        return fl;
    }

    public String getFuncListCsv() {
        return systemApiName;
    }

    /**
     * @return the nameApi
     */
    public String getNameApi() {
        return nameApi;
    }

    /**
     * @return the system
     */
    public String getSystem() {
        return system;
    }

    /**
     * @return the Scheme
     */
    public String getApiType() {
        return apiType;
    }

    /**
     * @return the package_
     */
    public String getPackage_() {
        return package_;
    }

    /**
     * @return the subPackage
     */
    public String getSubPackage() {
        return subPackage;
    }

    /**
     * @return the versionApi
     */
    public String getVersionApi() {
        return versionApi;
    }

    /**
     * @return the MQClass
     */
    public String getMQClass() {
        return MQClass;
    }

    /**
     * @return the definitionVersion
     */
    public String getDefinitionVersion() {
        return definitionVersion;
    }

    /**
     * @return the descriptionApi
     */
    public String getDescriptionApi() {
        return descriptionApi;
    }
}
