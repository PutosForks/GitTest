/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdesign.gupta.Static.staticvariable;

class Book {

    static int bookCount;

    public Book() {
        ++bookCount;
    }
}

class Publisher {

    public static void main(String args[]) {
        System.out.println(Book.bookCount);
        Book b1 = new Book();
        Book b2 = new Book();
        System.out.println(Book.bookCount);
        b1.bookCount = 10;
        System.out.println(b2.bookCount);
    }
}
