package api_subscription_generator.grants;

import settings.Settings;


public class Files {

    public static String mode;

    public static String getName(String fileName) {
        if (mode.equals("g")) {
            return Settings.srcGrants + "\\" + fileName.toLowerCase() + "_grant.sql";
        } else {
            return Settings.srcRoles + "\\" + fileName.toLowerCase() + ".csv";
        }
    }

    public static String getDest(String fileName) {
        return Settings.destFiles + "\\" + fileName.toLowerCase() + "\\grant\\" + fileName.toLowerCase() + "_grant.sql";
    }


}
