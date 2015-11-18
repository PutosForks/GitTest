package collections.collectionsgupta.list;

import java.util.ArrayList;
import java.util.ListIterator;

class ManipulateArrayList {
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Harry");
        list.add("Selvan");
        list.add("Harry");
        list.add(0, "Paul");   // shifts other elements to right
        list.remove("Harry");
        String oldValue = list.set(0, "Shreya");  // replaces the first value, retriving the value => oldValue = Paul
        list.get(1);
        System.out.println("list contains Harry : " +
                list.contains("Harry"));


        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
