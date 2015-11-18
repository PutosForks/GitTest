package javaio.CharStreams.Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

    public static void main(String[] files) {
        if (files.length == 0) {
            System.err.print("No input");
            System.exit(-1);
        }

        for (String file : files) {
            try (BufferedReader inputfile = new BufferedReader(new FileReader(file))) {
                int ch = 0;

                while ((ch = inputfile.read()) != -1) {
                    System.out.print((char) ch);
                }

            } catch (FileNotFoundException fnfe) {
                // the passed file is not found â€¦ 
                System.err.printf("Cannot open the given file %s ", file);
            } catch (IOException ioe) {
                // some IO error occurred when reading the file â€¦ 
                System.err.printf("Error when processing file %s¦ skipping it", file);
            }

        }
    }

}
