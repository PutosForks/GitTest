package strings.stringsgupta.SampleExam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {

    public static void main(String[] args) throws IOException {
        // 5.1
        double num1 = 7.12345678;
        int num2 = (int) 8.12345678;
        System.out.printf("num1=%f, num2=%2d, %b", num1, num2, num2);

        System.out.println("");

        // 5.2
        Pattern pattern = Pattern.compile("\\d\\d");
        Matcher matcher = pattern.matcher("761cars8");
        boolean found = false;
        while (found = matcher.find()) {
            System.out.println(matcher.group());
        }

        System.out.println("");

        //5.4
        Scanner scanner = new Scanner("ThemeXtheirXcarpet77BBtheCC");
        scanner.useDelimiter("t.*e");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        //5.6
        String mgr1 = "Paul & Harry's new office";
        StringBuilder emp = new StringBuilder("Harry");
        System.out.println(mgr1.contains(emp));

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("files/data.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(test1.class.getName()).log(Level.SEVERE, null, ex);
        }
        String line;
        StringTokenizer st;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line, "[,;]"); //line1
            while (st.hasMoreElements()) {
                System.out.println(st.nextElement());
            }
        }
        br.close();
        System.out.println("");

        //5.8
        String eJava = "e Java Guru";

        System.out.println(eJava.matches("u.u"));  // false

        if (eJava.matches("u.u")) {
            String[] tokens = eJava.split("\\Bu");
            for (String token : tokens) {
                System.out.println(token);
            }
        } else {

            System.out.println(eJava.subSequence(3, 4));
            System.out.println(eJava.substring(11));

            // replace "a" with ""  print e Jv Guru
            System.out.println(eJava.replace(
                    eJava.subSequence(3, 4), eJava.substring(11)));
        }

    }

}
