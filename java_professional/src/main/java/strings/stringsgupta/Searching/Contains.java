package strings.stringsgupta.Searching;

public class Contains {

    public static void main(String[] args) {
        /*
         can be passed StringBuilder and String
         */

        String sentence = "paint the cup and the plate";
        StringBuilder sb = new StringBuilder("the");
        String s = "and";

        System.out.println(sentence.contains(s));   // true
        System.out.println(sentence.contains(sb));   // true

    }
}
