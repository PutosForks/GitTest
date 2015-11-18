package generics.genericsgupta.boundedwildcard;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildCard {

    public static void wrapGift(List<? super Gift> list) {
        for (Object item : list) {
            System.out.println("GiftWrap - " + item.toString());
        }
    }

    List<? super Gift> myList1 = new ArrayList<Gift>();
    List<? super Gift> myList2 = new ArrayList<Object>();

    public static void main(String[] args) {
        List<? super Gift> bookList = new ArrayList<Gift>();
        bookList.add(new Book("Oracle"));   // can add objects to Lower Bounded wildcard list
        bookList.add(new Phone());
        wrapGift(bookList);

    }

}
