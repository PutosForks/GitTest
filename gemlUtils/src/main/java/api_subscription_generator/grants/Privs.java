package api_subscription_generator.grants;


public class Privs {

    private String state;
    private String grantee;
    private String owner;
    private String tableName;
    private String objectType;
    private String grantor;
    private String privilege;
    private String grantable;
    private String hierarchy;
    private String d = ";";

    @Override
    public String toString() {
        return state + d + grantee + d + owner + d + objectType + d + tableName + d + grantor + d + privilege + d + grantable + d + hierarchy;
    }


    public String getGrantee() {
        return grantee;
    }


    public String getTableName() {
        return tableName;
    }


    public String getObjectType() {
        return objectType;
    }


    public String getGrantor() {
        return grantor;
    }

    public String getPrivilege() {
        return privilege;
    }

    public String getGrantable() {
        return grantable;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    /**
     * @param grantee the grantee to set
     */
    public void setGrantee(String grantee) {
        this.grantee = grantee;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @param objectType the objectType to set
     */
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    /**
     * @param grantor the grantor to set
     */
    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    /**
     * @param privilege the privilege to set
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    /**
     * @param grantable the grantable to set
     */
    public void setGrantable(String grantable) {
        this.grantable = grantable;
    }

    /**
     * @param hierarchy the hierarchy to set
     */
    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }


}
