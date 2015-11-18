package collections.collectionsgupta.algorithms;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BinarySearch1 {

    static final Comparator<Integer> INT_COMPARATOR =
            new Comparator<Integer>() {
                public int compare (Integer n1, Integer n2) {
                    return n2.compareTo(n1);
                }
            };
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9999);
        list.add(10);
        list.add(55);
        list.add(28);
        Collections.sort(list, null);
        System.out.println(Collections.binarySearch(list, 55));
        Collections.sort(list,INT_COMPARATOR);
        System.out.println(Collections.binarySearch(list, 55));
    }
}
