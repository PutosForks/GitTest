package strings.stringsgupta.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex3Negation {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[^abc]");
        Matcher matcher = pattern.matcher("abcdef");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        pattern = Pattern.compile("^abc");
        matcher = pattern.matcher("abcdef");

        while (matcher.find()) {
            System.out.println(matcher.group());  // abc
        }

        /*
         if you ommit [] then it means starts with 
         */
    }

}
