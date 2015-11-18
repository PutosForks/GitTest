package collections.collectionsgupta.list;

import java.util.*;

public class ArrayListUse {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>(10);
        strList.add("abc");
        strList.add("def");

        for (String s : strList) {
            System.out.println(s);
        }

        List<String> strList2 = new ArrayList<>();

        strList2.addAll(strList);

        System.out.println(strList2);

        strList2.remove(0);

        System.out.println(strList2);

        strList2.addAll(strList);

        System.out.println(strList2);  // duplicate "def"

        System.out.println("Iterator");
        System.out.println("--------------");
        Iterator<String> it = strList2.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
