/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdesign.gupta.casting;

/**
 *
 * @author 502413934
 */
public class Book extends ShoppingItem
        implements Printable {

    public void description() {
        System.out.println("Book");
    }

    public void print() {
        System.out.println("Printing book");
    }
}
