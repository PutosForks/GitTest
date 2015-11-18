package strings.stringsgupta.Formating;

import java.util.Formatter;
import java.util.Locale;

public class Formatting_f {

    /*
     By default, %f prints six digits after the decimal. 
     It also rounds off the last digit.
     */
    public static void main(String[] args) {
        Formatter formatter = new Formatter();  //[12,123450]
        System.out.println(formatter.format("Amt [%f]", 12.12345));

        formatter = new Formatter();  //[12.123450]
        System.out.println(formatter.format(Locale.ENGLISH, "Amt [%f]", 12.12345));

        formatter = new Formatter(); // width 12 (zero padded) //[00012,123450]
        System.out.println(formatter.format("Amt [%012f]", 12.12345));

        formatter = new Formatter(); // width 10, left-justified [12,123450 ]
        System.out.println(formatter.format("Amt [%-10f]", 12.12345));

        formatter = new Formatter(); // [     12,12]
        System.out.println(formatter.format("Amt [%10.2f]", 12.12345));

        formatter = new Formatter(); // [12,12]
        System.out.println(formatter.format("Amt [%.2f]", 12.12345));

        formatter = new Formatter();//[123 456 789,123450]
        System.out.println(formatter.format("Amt [%,f]", 123456789.12345));

    }

}
