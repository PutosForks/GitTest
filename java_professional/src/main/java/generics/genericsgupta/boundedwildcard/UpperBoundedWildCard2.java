package generics.genericsgupta.boundedwildcard;

import java.util.ArrayList;
import java.util.List;


class Books extends Gift {

    String title;

    Books(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }

}

public class UpperBoundedWildCard2 {

    public static void wrapGift(List<? extends Gift> list) {
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

        //wrapGift(stringList);  => won't work because parameter is limited to Gift and it's children
    }
}
