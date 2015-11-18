package strings.stringsgupta.Formating;

import java.util.Formatter;

public class Formatting_d {

    public static void main(String[] args) {
        Formatter formatter = new Formatter(); // [12345]
        System.out.println(formatter.format("Acct ID [%d]", 12345));

        formatter = new Formatter();  // [0000012345] width (zero-padded)
        System.out.println(formatter.format("Acct ID [%010d]", 12345));

        formatter = new Formatter(); //negative numbers wnclosed () (123 456 789)
        System.out.println(formatter.format("Acct ID %(,d", -123456789));

    }
}
