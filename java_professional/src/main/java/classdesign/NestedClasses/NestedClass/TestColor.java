/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdesign.NestedClasses.NestedClass;

/**
 *
 * @author marko
 */
public class TestColor {

    public static void main(String[] args) {
        // watch out on how to construct object of inner class
        Shape.Color c = new Shape().new Color();
    }
}
