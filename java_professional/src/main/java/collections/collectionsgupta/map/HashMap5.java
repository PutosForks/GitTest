package collections.collectionsgupta.map;

import java.util.HashMap;


public class HashMap5 {
    public static void main(String[] args) {

        HashMap<Integer, String> sourceMap = new HashMap<>();
        sourceMap.put(1, "Shreya");
        sourceMap.put(2, "Edgar");


        HashMap<Integer, String> targetMap = new HashMap<>();
        targetMap.put(1, "Shreya");

            targetMap.putAll(sourceMap);

        for (Integer key : targetMap.keySet())
        System.out.println(targetMap.get(key));








    }
}
