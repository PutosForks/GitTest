package javaio.CharStreams.Writer;

import java.io.*;

public class CopyByLine {

    public static void main(String[] files) {
        if (files.length != 2) {
            System.err.println("inocrect. Correct is: srcFile destFile");
        }

        String srcFile = files[0];
        String destFile = files[1];

        try (BufferedReader inputfile = new BufferedReader(new FileReader(srcFile));
             BufferedWriter outputFile = new BufferedWriter(new FileWriter(destFile))) {

            String chars;

            while ((chars = inputfile.readLine()) != null) {
                outputFile.write(chars);
            }

        } catch (FileNotFoundException fnfe) {
            // the passed file is not found â€¦
            System.err.printf("Cannot open the given file %s ", srcFile);
            System.err.printf("Cannot open the given file %s ", destFile);
        } catch (IOException ioe) {
            // some IO error occurred when reading the file â€¦
            System.err.printf("Error when processing file %s¦ skipping it", srcFile);
            System.err.printf("Error when processing file %s¦ skipping it", destFile);
        }

    }
}
