package strings.stringsgupta.Formating;

import java.util.Formatter;

public class Formatting_c {

    public static void main(String[] args) {

        // %c accepts only Character and char  -- output is Unicode
        Formatter formatter = new Formatter();
        System.out.println(formatter.format("Char %c", new Character('\u007b')));

    }
}
