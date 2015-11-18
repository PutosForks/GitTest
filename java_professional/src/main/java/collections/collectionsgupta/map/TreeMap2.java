package collections.collectionsgupta.map;


import java.util.Map;
import java.util.TreeMap;

class Flavor {
    String name;

    Flavor(String name) {
        this.name = name;
    }


}

class CreateTreeMap {
    public static void main(String args[]) {
        Map<Flavor, String> flavorMap = new TreeMap<>();
        flavorMap.put(new Flavor("Chocolate"), "Paul"); // RuntimeException => not implementing Comparable
    }


}



