
package strings.StringMethods.Comparing;


public class RegionMatches {

    public static void main(String[] args) {
        String chat = "Tarzan: Hi Jane, wanna ride an elephant? \nJane: No Thanks! I'm not interested.";
        String matchString = "Jane: No Thanks!";

        int startIndex = chat.indexOf("\n");

        System.out.println("Jane's answer starts at: " + startIndex);

        if (startIndex > -1) {
            boolean b = chat.regionMatches(startIndex + 1, matchString, 0, matchString.length());
            System.out.println(b);
        }

    }

}
