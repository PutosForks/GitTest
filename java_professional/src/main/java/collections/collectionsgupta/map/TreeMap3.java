package collections.collectionsgupta.map;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Falvor implements Comparable<Flavor> {
    String name;

    public Falvor(String name) {
        this.name = name;
    }

    public Falvor() {
    }

    @Override
    public int compareTo(Flavor o) {
        return this.name.compareTo(o.name);
    }

}


class MyComparator implements Comparator<Flavor> {
    public int compare(Flavor f1, Flavor f2) {
        return f2.name.compareTo(f1.name);
    }
}


public class TreeMap3 {

    public static void main(String args[]) {
        Map<Flavor, String> flavorMap = new TreeMap<>(new MyComparator());
        flavorMap.put(new Flavor("Chocolate"), "Paul");
        flavorMap.put(new Flavor("Vanilla"), "Selvan");
        for (Flavor flavor : flavorMap.keySet())
            System.out.println(flavor.name);
    }


}
