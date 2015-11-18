package collections.collectionsgupta.map;


import java.util.Map;
import java.util.TreeMap;

class Flavor2 implements Comparable<Flavor2> {
    String name;

    public Flavor2(String name) {
        this.name = name;
    }

    public Flavor2() {
    }

    @Override
    public int compareTo(Flavor2 o) {
        return this.name.compareTo(o.name);
    }

}


public class TreeMap4 {

    public static void main(String args[]) {
        Map<Flavor2, String> Flavor2Map = new TreeMap<>();
        Flavor2Map.put(new Flavor2("Chocolate"), "Paul");
        Flavor2Map.put(new Flavor2("Vanilla"), "Selvan");
        for (Flavor2 flavor2 : Flavor2Map.keySet())
            System.out.println(flavor2.name);
    }
}





