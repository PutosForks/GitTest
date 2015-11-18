package strings.StringMethods.RegularExpressions.Replace;

import java.util.regex.*;

/*
  replace telephone numbers (10 digits) with format XXX-XXXXXXX
*/

public class Regex6 {

    public static void main(String[] args) {
        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, "
                + "Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. "
                + "Maggi Myer, Post bag no 52, Big bank post office, , Big bank "
                + "city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";

        Pattern pattern = Pattern.compile("(\\s)(\\d{3})(\\d{7})(\\b)");
        Matcher matcher = pattern.matcher(str);
        
        String newStr = matcher.replaceAll("$1$2-$3$4");
        
        System.out.println(newStr);
        
        
        
        
    }
}
