/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdesign.gupta.protectedexample.library;

/**
 *
 * @author 502413934
 */
public class CourseBook extends Book {

    CourseBook() {
        Book b = new Book();
        b.author = "aaa";
        b.modifyTemplate();
    }
}
