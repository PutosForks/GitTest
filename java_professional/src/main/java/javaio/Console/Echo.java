package javaio.Console;

import java.io.Console;

public class Echo {

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("Cannot retive console object");
            System.exit(-1);
        }

        console.printf(console.readLine());

    }

}
