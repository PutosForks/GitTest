package strings.stringsgupta.Scanner;

import java.util.Scanner;

public class Scanners2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner("1 2 4 The new 55 Programmer 44 exam");
        scanner.useDelimiter("[\\s\\D]+");
        int total = 0;
        while (scanner.hasNextInt()) {
            total += scanner.nextInt();

        }
        System.out.println(total);  // (1+2+4+55+44): = 106

        scanner = new Scanner ("ABC 223.2343 Paul 10");
        scanner.findInLine("(ABC)+[\\d]+\\.[\\d]+[A-za-z]+[\\d]+");
        
        
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.nextInt());
    }

}
