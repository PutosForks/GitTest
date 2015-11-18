package generics.genericsgupta.wildcard;


import java.util.ArrayList;
import java.util.List;

class Gifts {
}

class Books extends Gift {

    String title;

    Books(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }

}

public class WildCard2 {

    public static void wrapGift(List<?> list) {    // you can iterate through objects
        for (Object item : list) {
            System.out.println("GiftWrap - " + item.toString());
        }
    }

    public static void main(String args[]) {

        List<Books> bookList = new ArrayList<>();
        bookList.add(new Books("Oracle"));
        bookList.add(new Books("Java"));
        wrapGift(bookList);

        List<String> stringList = new ArrayList<>();
        stringList.add("Paul");
        stringList.add("Shreya");

        wrapGift(stringList);
    }
}
