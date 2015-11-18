package strings.stringsgupta.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[fdn]ine");
        Matcher matcher = pattern.matcher("I am fine to dine at nine");

        while (matcher.find()) {
            System.out.printf("%s %s %s %s", matcher.group(),
                    matcher.start(),
                    matcher.end(), "\n");

            // end is always + 1 
        }

    }

}
