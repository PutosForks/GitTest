package collections.collectionsgupta.map;

import java.util.HashMap;

public class HashMap3 {
    public static void main(String[] args) {



  HashMap<Integer, String> dupliacteKeyMap = new HashMap<>();
        dupliacteKeyMap.put(1, "Marko");
        dupliacteKeyMap.put(1, "Dominik");

        System.out.println(dupliacteKeyMap.get(1));

        dupliacteKeyMap.put(null, "Monika");

        System.out.println(dupliacteKeyMap.get(null));

        System.out.println(dupliacteKeyMap.remove(2));   // returns null, since the key does not exist
        System.out.println(dupliacteKeyMap.remove(1));  // returns Dominik

    }
}
