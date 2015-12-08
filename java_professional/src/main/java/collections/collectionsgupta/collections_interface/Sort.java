package collections.collectionsgupta.collections_interface;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        Sort.addTo(set);
        Sort.addTo(list);

        // Collections.sort(set);  // You must convert HashSet to TreeSet in order to sort it
        Collections.sort(list);

        System.out.println("Printing set: ");
        for (String s : set) {
            System.out.println(s);
        }


        System.out.println("Printing list: ");
        for (String s : list) {
            System.out.println(s);
        }

    }

    static void addTo(Collection c) {
        c.add("b");
        c.add("c");
        c.add("a");
    }


}
