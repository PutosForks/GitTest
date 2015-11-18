package collections.collectionsgupta.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetUse {

    public static void main(String[] args) {

        String tongueTwister = "I feel, a feel, a funny feel, a funny feel I feel, "
                + "if you feel the feel  I feel, I feel the feel you feel";
        Set<String> hashset = new HashSet<>();

        for (String s : tongueTwister.split("\\W+")) {
            hashset.add(s);
        }

        System.out.println(hashset);

    }
}
