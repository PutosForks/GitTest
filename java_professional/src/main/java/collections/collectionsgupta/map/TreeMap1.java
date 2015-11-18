package collections.collectionsgupta.map;

import java.util.Map;
import java.util.TreeMap;

enum IceCream2 {STRAWBERRY, CHOCOLATE, WALNUT};



public class TreeMap1 {

    public static void main(String[] args) {

        Map<IceCream2, String> flavorMap = new TreeMap<>();  // natural ordering of enum
        flavorMap.put(IceCream2.CHOCOLATE, "Paul");
        flavorMap.put(IceCream2.STRAWBERRY, "Shreya");
        flavorMap.put(IceCream2.WALNUT, "Adam");
        for (String s : flavorMap.values())
            System.out.println(s);  // Shreya, Paul, Adam
    }

}
