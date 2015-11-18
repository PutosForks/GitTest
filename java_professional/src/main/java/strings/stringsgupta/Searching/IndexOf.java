package strings.stringsgupta.Searching;

public class IndexOf {

    public static void main(String[] args) {

        String sentence = "paint the cup and the plate";
        System.out.println(sentence.indexOf("t")); // 4
        System.out.println(sentence.indexOf('a', 100)); // -1
        System.out.println(sentence.indexOf("t", 15)); // 18
        System.out.println(sentence.indexOf("the"));  // 6

        System.out.println(sentence.lastIndexOf('t')); // 25

    }

}
