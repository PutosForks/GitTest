package collections.collectionsgupta.properties;

import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("Key1", "Value1");
        prop.setProperty("Key1", "Value7");
        System.out.println(prop.get("Key1"));

    }

}
