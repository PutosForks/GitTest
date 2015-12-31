package javaio.file;

import java.io.File;
import java.io.IOException;

public class FilePaths {

    public static void main(String[] args) throws IOException {

        String[] fileArray = {
                "c://Users//marko//Documents//programming//java//Java//exam//java_professional//src//main//resources",
                "src/main/resources/top/middle",
                "../docs/ExamTopics.docx"
        };

        for (String f : fileArray) {
            displayInfo(f);
        }

    }

    public static void displayInfo(String f) throws IOException {
        File file = new File(f);
        System.out.println("========================================");
        System.out.println("          name:" + file.getName());
        System.out.println("  is directory:" + file.isDirectory());
        System.out.println("        exists:" + file.exists());
        System.out.println("          path:" + file.getPath());
        System.out.println(" absolute file:" + file.getAbsoluteFile());
        System.out.println(" absolute path:" + file.getAbsolutePath());
        System.out.println("canonical file:" + file.getCanonicalFile());
        System.out.println("canonical path:" + file.getCanonicalPath());
    }

}
