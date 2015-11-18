/*
 build\classes\O8_java_io\CharStreams\Writer\Copy.class
 */
package javaio.ByteStreams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Arrays;

public class FileCheckerMagicNumber {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Only one file");
            System.exit(-1);
        }

        String fileName = args[0];
        byte[] magicNumber = {(byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE};
        try (FileInputStream fis = new FileInputStream(fileName)) {

            byte[] u4buffer = new byte[4];

            if (fis.read(u4buffer) != -1) {

                if (Arrays.equals(magicNumber, u4buffer)) {
                    System.out.printf("The magic number for passed file %s matches that of a .class file", fileName);
                } else {
                    System.out.printf("The magic number for passed file %s does not match that of a .class file", fileName);
                }

            }

        } catch (FileNotFoundException fnfe) {
            // the passed file is not found â€¦ 
            System.err.printf("Cannot open the given file %s ", fileName);
        } catch (IOException ioe) {
            // some IO error occurred when reading the file â€¦ 
            System.err.printf("Error when processing file %s¦ skipping it", fileName);
        }

    }

}
