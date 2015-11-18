package collections.collectionsgupta.set;

import java.util.*;

class ManipulateHashSet {
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("Shreya");
        list.add("Selvan");

        HashSet<String> set = new HashSet<String>();
        set.add("Harry");
        set.addAll(list);

        System.out.println(set.contains("Shreya"));
        System.out.println(set.remove("Selvan"));

        for (String e : set) System.out.println(e);
    }
}