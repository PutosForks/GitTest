package strings.stringsgupta.Formating;

import java.util.Formatter;

public class Formatting_s {

    public static void main(String[] args) {
        int age = 40;
        String name = "Harry";

        Formatter formatter = new Formatter();  // using indexing
        System.out.println(formatter.format("Name is %2$s, age is %1$s", name, age));
    }
}
