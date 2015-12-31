package javaio.ByteStreams.inout;

import javaio.file.ResourceDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        File path = new File(ResourceDir.getResourceDir(), "data/Hello.txt");

        String contents = "Hello planet";
        OutputStream out = new FileOutputStream(path);
        out.write(contents.getBytes());
        out.close();
    }
}
