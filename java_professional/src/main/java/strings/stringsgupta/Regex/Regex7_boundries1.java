package strings.stringsgupta.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex7_boundries1 {

    public static void main(String[] args) {

        String s = "the leather in their coat made her seethe";
        Pattern pattern1;
        Matcher matcher1;

        pattern1 = Pattern.compile("\\bthe");
        matcher1 = pattern1.matcher(s);

        System.out.println(s);
        String result;

        while (matcher1.find()) {
            result = matcher1.group() + " " + matcher1.start();
            System.out.println(result);
        }

        pattern1 = Pattern.compile("\\bthe\\B");
        matcher1 = pattern1.matcher(s);

        System.out.println(s);

        while (matcher1.find()) {
            result = matcher1.group() + " " + matcher1.start();
            System.out.println(result);
        }

        pattern1 = Pattern.compile("\\Bthe\\b");
        matcher1 = pattern1.matcher(s);

        System.out.println(s);

        while (matcher1.find()) {
            result = matcher1.group() + " " + matcher1.start();
            System.out.println(result);
        }

    }

}
