package classdesign.gupta.overriding;

public class Book {

    void printDescription() {
        System.out.println("This is a book");
    }

}


class CourseBook extends Book {

    void printDescription() {
        System.out.println("This is a Coursebook");
    }


}


class Bible extends Book {
    void printDescription() {
        System.out.println("This is a Bible");
    }

}


class TestBooks {
    public static void main(String[] args) {
        Book courseBook, bible, book;

        book = new Book();
        courseBook = new CourseBook();
        bible = new Bible();

        book.printDescription();
        courseBook.printDescription();
        bible.printDescription();

    }
}