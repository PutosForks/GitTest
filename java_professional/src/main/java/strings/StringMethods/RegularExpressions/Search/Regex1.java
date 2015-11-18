package strings.StringMethods.RegularExpressions.Search;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex1 {

    public static void main(String[] args) {
        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, "
                + "Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. "
                + "Maggi Myer, Post bag no 52, Big bank post office, , Big bank "
                + "city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";

        // get the instance of Pattern class by giving it regex (matches word caracters incl. numeric).
        Pattern pattern = Pattern.compile("\\w+");
        // get an instance of Matcher class
        Matcher matcher = pattern.matcher(str);

        // method "finds" retuns true as long as it finds the matching String
        // method "group" returns result as a String
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }

}
