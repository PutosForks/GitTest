package strings.stringsgupta.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex9_quantifiers {

    public static void main(String[] args) {

        String s = "All colours are beautiful colors";
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("colo[u]?r"); // 0 or 1
        matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        s = "August is sometimes writen as Aug";

        pattern = Pattern.compile("Aug[a-z]*"); // 0 or more times
        matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        pattern = Pattern.compile("Aug(ust)?"); // 0 or 1
        matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        /*
         Search for text starting and ending with letter
         and containing 0 or more digits in between
         */
        s = "b234a A6Z a2z4 abc";

        pattern = Pattern.compile("[A-Za-z]+[\\d]*[A-Za-z]+\\b");
        matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        /*
         Limit previous search to letters  1-5
         */
        s = "b234a A6Z a2z4 abc";
        pattern = Pattern.compile("[A-Za-z]+[1-5]*[A-Za-z]+\\b");
        matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
