package generics.genericsgupta.basics;

import java.util.ArrayList;
import java.util.List;

public class ExplicitCasts {

    public static void main(String[] args) {

    List stringList = new ArrayList();
    stringList.add("Test");
    stringList.add(1);  // THIS IS OK

    for (int i = 0; i < stringList.size(); i++) {
        System.out.println((String) stringList.get(i));  // ClassCast Runtime exception
    }
    }
}


class GenericNoCast {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Test");
       // stringList.add(1);  // compilation error


    }
}
