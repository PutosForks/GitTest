package collections.collectionsgupta.map;

import java.util.*;

public class HashMap7 {

    public static void main(String[] args) {

        Map<String, String> s = new HashMap<>();
        s.put("calender", "calendar");
        s.put("existance", "existence");

        String sentence = "Buy a calender for the year 2013";

        for (String str : sentence.split("\\W+")) {
            if (s.containsKey(str)) {
                System.out.println(str + " is mispelled .Correct spelling is " + s.get(str));
            }
        }

    }

}
