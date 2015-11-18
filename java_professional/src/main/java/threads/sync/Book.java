package threads.sync;

class Book {
    String title;
    int copiesSold = 0;

    Book(String title) {
        this.title = title;
    }

    synchronized public void newSale() {  // synchronized
        ++copiesSold;
    }

    synchronized public void returnBook() {   // synchronized
        --copiesSold;
    }
}

class OnlineBuy extends Thread {
    private Book book;

    public OnlineBuy(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        book.newSale();
    }
}

class OnlineReturn extends Thread {
    private Book book;

    public OnlineReturn(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        book.returnBook();
    }
}

class ShoppingCart {
    public static void main(String args[]) throws Exception {
        Book book = new Book("Java");
        Thread task1 = new OnlineBuy(book);
        task1.start();
        Thread task2 = new OnlineBuy(book);
        task2.start();
        Thread task3 = new OnlineReturn(book);
        task3.start();
    }
}