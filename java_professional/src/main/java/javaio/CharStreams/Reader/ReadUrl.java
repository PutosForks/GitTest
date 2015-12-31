package javaio.CharStreams.Reader;

import java.io.*;
import java.net.URL;

public class ReadUrl {
    public static void main(String[] args) throws IOException{

        URL url = new URL("http://www.gutenberg.org/cache/epub/2265/pg2265.txt");
        InputStream is = url.openStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        String line = r.readLine();
        while ((r.readLine() != null)) {
            System.out.println(line);
            line = r.readLine();
        }

        System.out.println(line);



    }
}
