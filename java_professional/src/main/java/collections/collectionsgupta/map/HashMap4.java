package collections.collectionsgupta.map;

import java.util.*;



public class HashMap4 {
    public static void main(String[] args) {

        Map<List, String> flavorNameMap = new HashMap<>();
        List<IceCream> iceCreamLst = new ArrayList<>();
        iceCreamLst.add(IceCream.WALNUT);
        iceCreamLst.add(IceCream.CHOCOLATE);

        flavorNameMap.put(iceCreamLst, "Shreya");
        List<IceCream> iceCreamLst2 = new ArrayList<>();
        iceCreamLst2.add(IceCream.WALNUT);
        iceCreamLst2.add(IceCream.CHOCOLATE);
        System.out.println(flavorNameMap.remove(iceCreamLst2));


    }

}
