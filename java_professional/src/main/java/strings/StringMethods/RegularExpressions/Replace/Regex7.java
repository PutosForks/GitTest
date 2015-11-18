package strings.StringMethods.RegularExpressions.Replace;

import java.util.regex.*;

/*
 validate IP address 4 three digit numbers seperated by dot "." and each number is max 255
 */
public class Regex7 {

    public static void main(String[] args) {

        String ipAddress1 = "255.200.178.057";
        //+[1-5]{1}+[1-5]{1}+[.]+\\d{3}+[.]+\\d{3}+[.]+\\d{3}
        Pattern pattern = Pattern.compile("[0-255]{3}");
        Matcher matcher = pattern.matcher(ipAddress1);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
