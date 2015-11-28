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

    void criticize (Integer in) {
        System.out.println("Book critic");
    }
}

class CourseBook extends Book {

    void review(int id, ArrayList names) {            // Overrides
        System.out.println("This is CourseBook list: " + names.size());

    }

    void criticize (Integer in) {                    //Overloads
        System.out.println("CourseBook critic");
    }


    public static void main(String[] args) {
        Book b = new CourseBook();
        b.review(1, new ArrayList(5));
        b.criticize(1);

        CourseBook a = new CourseBook();
        a.review(1, new ArrayList(5));
        a.criticize(1);

    }

}
