package strings.stringsgupta.Formating;

import java.util.Formatter;

public class Formatting_b {

    public static void main(String[] args) {
        /*
         The general syntax is %[arg_index$][flags][width][.precision]
         */

        // %b  -- can accept any object or primitive value
        String a = null;     // always false
        String b = "Hello";   // always true
        boolean c = false;    // boolean and Boolean are evaluate

        Formatter formatter = new Formatter();
        System.out.println(formatter.format("This %b is %b in %b", a, b, c));

        String d = null;
        
        

        Formatter formatter2 = new Formatter();
        System.out.println(
                formatter2.format("This %b is %b in %b", a, b, c, d));
        /*  - ok, last agruent ignored
         - lack of arguments would result in java.util.MissingFormatArgumentException
         */

        formatter = new Formatter();   // padding
        System.out.println(formatter.format("Name defined %10b.", a));
        formatter = new Formatter();  // truncate
        System.out.println(formatter.format("Name defined %.1b.", a));
        formatter = new Formatter();  // left-justifies
        System.out.println(formatter.format("Name defined %-10b.", a));

        
        
    }
}
