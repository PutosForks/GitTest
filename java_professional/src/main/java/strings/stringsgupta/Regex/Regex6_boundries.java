

package strings.stringsgupta.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex6_boundries {
    public static void main(String[] args) {
        
        String s = "Some people\ngo away\ntoday";
        
        Pattern pattern1 = Pattern.compile("[.]");
        Matcher matcher1 = pattern1.matcher(s);
        
        System.out.println(s);
        
        while (matcher1.find()) {
            System.out.println(matcher1.start());
        }
        
        
        
        
    }
}
