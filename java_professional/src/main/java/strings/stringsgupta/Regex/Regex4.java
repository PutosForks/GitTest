package strings.stringsgupta.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex4 {

    public static void main(String[] args) {
        Pattern pattern = null;
        Matcher matcher = null;

        pattern = Pattern.compile("\\d");
        matcher = pattern.matcher("A5C7M%");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        pattern = Pattern.compile("\\D");  // non-digits
        matcher = pattern.matcher("A5C7M%");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        pattern = Pattern.compile("[^\\d]");  // non-digits
        matcher = pattern.matcher("A5C7M%");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        pattern = Pattern.compile("[^\\w]");  // Special characters
        matcher = pattern.matcher("A5C7M%");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }

}
