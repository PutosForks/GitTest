package strings.stringsgupta.Scanner;

import java.util.Scanner;

public class Scanners {

    public static void main(String[] args) {

        Scanner scanner = new Scanner("The new Programmer exam");

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        System.out.println();

        scanner = new Scanner("The1new22Programmer exam6");
        scanner.useDelimiter("[\\d]+");

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        System.out.println();

        scanner = new Scanner("The1new22Programmer exam6");
        scanner.useDelimiter("[\\sA-Za-z]+"); //  "[\\s\\D]+" 

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        scanner = new Scanner("Shreya,20,true");
        scanner.useDelimiter(",");

        System.out.println(scanner.next());    
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextBoolean());

    }
}
