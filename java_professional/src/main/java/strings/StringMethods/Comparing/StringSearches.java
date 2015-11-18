
package strings.StringMethods.Comparing;


public class StringSearches {

    public static void main(String[] args) {
        String s = "Jack Nicholson is the best actor in the best movie";

        System.out.println(s.indexOf('N'));  //  5
        System.out.println(s.indexOf("Nicholson"));  // 5
        System.out.println(s.indexOf('X'));  //  - 1 when not exists

        int fromIndex = 0;
        while (s.indexOf("the", fromIndex) > - 1) {
            fromIndex = s.indexOf("the", fromIndex);
            System.out.println("Index of \"the\" is at: " + fromIndex);
            fromIndex++;
        }

        System.out.println(s.startsWith("Jack")); //true
        System.out.println(s.startsWith("J"));    //true
        System.out.println(s.endsWith("movie"));  //true 
        System.out.println(s.startsWith("N", 5)); //true

    }

}
