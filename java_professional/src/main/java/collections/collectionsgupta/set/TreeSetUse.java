package collections.collectionsgupta.set;

import java.util.*;

public class TreeSetUse {

    public static void main(String[] args) {
        String pangram = "the quick brown fox jumps over the lazy dog";

        Set<Character> ts = new TreeSet<>();

        for (char ch : pangram.toCharArray()) {
            ts.add(ch);
        }

        System.out.println(ts);

    }

}
