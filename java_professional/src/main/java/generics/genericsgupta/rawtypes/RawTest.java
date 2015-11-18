package generics.genericsgupta.rawtypes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RawTest {

    public static void main(String[] args) {

        List list = new LinkedList();
        list.add("First");
        list.add("Second");
        // list.add(10);    Would cause class cast exception at runtime 

        List<String> strList = list;
        Iterator<String> strIter = strList.iterator();

        while (strIter.hasNext()) {
            System.out.println(strIter.next());
        }

        List<String> list2 = new LinkedList<>();
        list.add("First");
        list.add("Second");
        //list.add(10);    Does not compile

    }
}
