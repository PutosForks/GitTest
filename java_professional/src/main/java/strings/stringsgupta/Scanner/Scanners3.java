package strings.stringsgupta.Scanner;

import java.util.Locale;
import java.util.Scanner;

public class Scanners3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner("ABC 223.2343 Paul 10");

        scanner.useLocale(Locale.US);

        scanner.findInLine("(ABC)+[\\d]+\\.[\\d]+[A-za-z]+[\\d]+");

        System.out.println(scanner.next());
        System.out.println(scanner.nextDouble());
        System.out.println(scanner.next());
        System.out.println(scanner.nextInt());

    }
}
