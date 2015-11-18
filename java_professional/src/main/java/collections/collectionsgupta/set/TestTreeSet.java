package collections.collectionsgupta.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;


public class TestTreeSet {
    public static void main(String args[]) {
        String[] myNames = {"Shreya", "Harry", "Paul", "Shreya", "Selvan"};
        TreeSet<String> treeSetNames = new
                TreeSet<String>(Arrays.asList(myNames));  // no dupliates, so only one "Shreya" is there
        Iterator it = treeSetNames.descendingIterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
