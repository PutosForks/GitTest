package api_subscription_generator.deployment.Enum;


public class testEnum {

    SchemaNameEnum schemaName;
    static ObjectTypeEnum en;


    public static void main(String[] args) {
        ObjectTypeEnum en = ObjectTypeEnum.translate("vw");

        System.out.println(ObjectTypeEnum.tab.value);
        System.out.println(en);
    }
}
