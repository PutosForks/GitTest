package collections.collectionsgupta.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum IceCream {
    WALNUT, CHOCOLATE

}

public class HashMap2 {
    public static void main(String[] args) {
        HashMap<String, List<IceCream>> iceCreamMap = new HashMap<>();
        List iceCreamList = new ArrayList<>();

        iceCreamList.add(IceCream.WALNUT);
        iceCreamList.add(IceCream.CHOCOLATE);

        iceCreamMap.put("Shreya", iceCreamList);

        if (iceCreamMap.containsKey("Shreya")) System.out.println(iceCreamMap.get("Shreya"));

        if (iceCreamMap.containsKey("Shreya") && iceCreamMap.get("Shreya").contains(IceCream.WALNUT)) System.out.println("I am delicious");



    }


}
