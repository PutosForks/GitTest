package javaio;

import java.io.*;
import java.util.*;

public class Remis {

    public static void main(String[] args) {
        
        String arg = args[0];
        
        try (BufferedReader br = new BufferedReader(new FileReader(arg));
                PrintWriter p = new PrintWriter(System.out)) {
            int t;
            t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                int sum = num1 + num2;
                p.println((num1 > num2 ? num1 : num2) + " " + sum);
            }
        } catch (Exception ie) {
            System.err.println(ie);
        }
    }
}
