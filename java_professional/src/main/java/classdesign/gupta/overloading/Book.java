package classdesign.gupta.overloading;

import java.util.ArrayList;
import java.util.List;

public class Book {

    protected void review(int id, List names) {
        System.out.println("This is book list: " + names.size());
    }

    public static void main(String[] args) {
        Book b = new CourseBook();
        b.review(1, new ArrayList(5));
    }
}

class CourseBook extends Book {

    void review(int id, ArrayList names) {
        System.out.println("This is CourseBook list: " + names.size());

    }

    public static void main(String[] args) {
        Book b = new CourseBook();
        b.review(1, new ArrayList(5));

        CourseBook a = new CourseBook();
        a.review(1, new ArrayList(5));

    }

}
