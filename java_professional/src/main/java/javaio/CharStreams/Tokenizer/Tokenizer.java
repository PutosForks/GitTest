package javaio.CharStreams.Tokenizer;

import java.io.*;
import java.util.*;

public class Tokenizer {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Arguments not provided");
        }

        String fileName = args[0];
        Set<String> words = new TreeSet<>();

        try (Scanner tokenizingScanner = new Scanner(new FileReader(fileName))) {
            tokenizingScanner.useDelimiter("\\W");

            while (tokenizingScanner.hasNext()) {
                String word = tokenizingScanner.next();
                if (!word.equals("")) {
                    words.add(word.toLowerCase());
                }
            }

            for (String w : words) {
                System.out.println(w);
            }

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }

    }
}
