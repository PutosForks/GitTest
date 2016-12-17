package api_subscription_generator.deployment;

import api_subscription_generator.deployment.Enum.EnvironmentsEnum;
import api_subscription_generator.deployment.Enum.ObjectTypeEnum;
import api_subscription_generator.deployment.Enum.SchemaNameEnum;


public class XmlItem {

	private String releaseId;
	private String releaseName;
    private SchemaNameEnum schemaName;
	private String objectName;
    private ObjectTypeEnum objectType;
    private EnvironmentsEnum environment;
    private String filePath;
    private String Scriptcomment;

    /**
     * @return the schemaName
     */
    public SchemaNameEnum getSchemaName() {
        return schemaName;
    }

    /**
     * @param schemaName the schemaName to set
     */
    public void setSchemaName(SchemaNameEnum schemaName) {
        this.schemaName = schemaName;
    }

    /**
     * @return the objectType
     */
    public ObjectTypeEnum getObjectType() {
        return objectType;
    }

    /**
     * @param objectType the objectType to set
     */
    public void setObjectType(ObjectTypeEnum objectType) {
        this.objectType = objectType;
    }

    /**
     * @return the environment
     */
    public EnvironmentsEnum getEnvironment() {
        return environment;
    }

    /**
     * @param environment the environment to set
     */
    public void setEnvironment(EnvironmentsEnum environment) {
        this.environment = environment;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the Scriptcomment
     */
    public String getScriptcomment() {
        return Scriptcomment;
    }

    /**
     * @param Scriptcomment the Scriptcomment to set
     */
    public void setScriptcomment(String Scriptcomment) {
        this.Scriptcomment = Scriptcomment;
    }


	public String getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

	public String getReleaseName() {
		return releaseName;
	}

	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}


	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
}
