/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdesign.gupta.casting;


public class DowncastWithExplicitCasting {

    static void DowncastWithExplicitCasting(ShoppingItem item) {
        Book book = (Book) item;
        Chair chair = (Chair) item;
        Printable printable = (Printable) item;
    }

    public static void main(String args[]) {
        ShoppingItem item = new ShoppingItem();
        DowncastWithExplicitCasting(item);
    }
}
