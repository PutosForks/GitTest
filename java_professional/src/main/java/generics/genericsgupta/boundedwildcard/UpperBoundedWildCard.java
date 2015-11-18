package generics.genericsgupta.boundedwildcard;

import java.util.ArrayList;
import java.util.List;

class Gift {
}

class Book extends Gift {

    String book;

    Book() {
        book = null;
    }

    Book(String book) {
        this.book = book;
    }

    public String toString() {
        return this.book;
    }

}

class Phone extends Gift {

    public String toString() {
        return "A phone";
    }
}

public class UpperBoundedWildCard {

    public static void wrapGift(List<? extends Gift> list) {
        for (Object item : list) {
            System.out.println("GiftWrap - " + item.toString());
        }
    }

    List<? extends Gift> myList1 = new ArrayList<Gift>();
    List<? extends Gift> myList2 = new ArrayList<Book>();
    List<? extends Gift> myList3 = new ArrayList<Phone>();

    public static void main(String[] args) {
        List<? extends Gift> bookList = new ArrayList<Book>();
        //bookList.add(new Book("Oracle"));

        /*
         Cannot add objects to upper bounded wildcard 
         */
        List<Book> booklist2 = new ArrayList<>();
        booklist2.add(new Book("Oracle"));
        booklist2.add(new Book("Java"));
        /* can iterate through it*/

        wrapGift(booklist2);

    }

}
