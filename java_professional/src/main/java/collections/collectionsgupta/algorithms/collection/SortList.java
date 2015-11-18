package collections.collectionsgupta.algorithms.collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {
    public static void main(String... args) {
        Star s1 = new Star("Sun", 7777.77);
        Star s2 = new Star("Sirius", 999999.99);
        Star s3 = new Star("Pilatim", 222.22);
        List<Star> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Collections.sort(list);
        list.add(new Star("Litmier", 4444.44));
        Collections.reverse(list);
        for (Star star : list) System.out.println(star);
    }
}

class Star implements Comparable<Star> {
    String name;
    double mass;

    Star(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public int compareTo(Star other) {
        return (int) (this.mass - other.mass);
    }

    public String toString() {
        return name + ":" + mass;
    }
}


