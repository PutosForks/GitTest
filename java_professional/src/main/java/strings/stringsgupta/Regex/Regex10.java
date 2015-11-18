package strings.stringsgupta.Regex;

/**
 * Created by 502413934 on 21.9.2015.
 */
public class Regex10 {
    public static void main(String[] args) {
        String str = "Big bag";

        System.out.println(str.matches("[B|b].g\\s\\w+"));

    }

}
