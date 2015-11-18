package javaio.CharStreams.Reader;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/*
 right under project JavaProfessional created folder files and placed files in it
 call:

 files\file1.txt
 files\file2.txt
 */
public class FileReaderTest {

    public static void main(String[] files) {
        if (files.length == 0) {
            System.err.println("pass the name of files");
            System.exit(-1);
        }

        for (String file : files) {
            // try-with-resources will automatically release FileReaderTest object  
            try (FileReader inputfile = new FileReader(file)) {
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
