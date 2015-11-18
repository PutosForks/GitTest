package collections.collectionsgupta.list;

import java.util.ArrayList;

public class RemoveArrayListElements {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer age1 = 20;
        Integer age2 = 20;
        list.add(age1);
        list.add(age2);
        System.out.print(list.size() + ":");
        age1 = 30;
        list.remove(age1);
        System.out.print(list.size());
    }
}
