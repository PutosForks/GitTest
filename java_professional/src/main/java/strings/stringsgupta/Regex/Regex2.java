package strings.stringsgupta.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("s.n");
        Matcher matcher;

        matcher = pattern.matcher("sun");
        System.out.println(matcher.find(0)); //true
        System.out.println(matcher.group()); //sun

        matcher = pattern.matcher("sin");
        System.out.println(matcher.find(0)); //true
        System.out.println(matcher.group()); //sin

        matcher = pattern.matcher("soon");
        System.out.println(matcher.find(0)); //false
        System.out.println(matcher.group()); //IllegalStateException

    }
}
