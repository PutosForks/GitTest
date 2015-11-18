package generics.genericsgupta.wildcard;

import java.util.ArrayList;
import java.util.List;

class Gift {
}

class Book extends Gift {
}

class Phone extends Gift {
}

public class WildCard {

    public static void main(String[] args) {
        // List<Gift> wishList = new ArrayList<Book>(); -- won't work
        List<?> wishList = new ArrayList<Book>();
        // wishList.add(new Book()); 
 
        /*
         When you use wildcard to declare your variables or method parameters, 
         you lose the functionality of adding objects to a collection. In this 
         case, using method add will result in compilation failure.
         You can only iterate through Collection using wildcard, not add items
         */

    }
}
