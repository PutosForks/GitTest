package generics.genericsgupta.boundedwildcard;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildCard3 {

    public static void printList(List<? extends Number> list) {
        for (Object o : list) {
            System.out.println("[" + o + "]");
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();

        intList.add(1);
        intList.add(2);

        doubleList.add(10.5);
        doubleList.add(20.3);

        UpperBoundedWildCard3.printList(intList);
        UpperBoundedWildCard3.printList(doubleList);

    }

}
