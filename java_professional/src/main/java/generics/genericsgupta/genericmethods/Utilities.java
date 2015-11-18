package generics.genericsgupta.genericmethods;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static <T> void fill(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, val);
        }
    }
}

class UtilitiesTest {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(200000);

        Utilities.fill(intList, 100);

        System.out.print("List after filled " + intList);

        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");

        // Utilities.fill(strList, 100); // does not work
        Utilities.fill(strList, "abc");

        System.out.print(" \nList after filled " + strList);
    }

}
