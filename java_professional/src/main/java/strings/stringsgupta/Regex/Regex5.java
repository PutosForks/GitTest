package strings.stringsgupta.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex5 {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[^\\w]+");
        Matcher matcher = pattern.matcher("A b$9? AC_ ");

        String result = matcher.replaceAll("<>");
        System.out.println(result);  // A<>b<>9<>AC_<>

    }

}
