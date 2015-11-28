/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdesign.gupta.instanceinitializer;

/**
 *
 * @author 502413934
 */
public class Parent {

    Parent () {
        System.out.println("parent constuctor");
    }

    {
        System.out.println("parent init block");
    }
}

class Child extends Parent {
    Child () {
      //  super();       // nemusi byt
        System.out.println("child constructor");
    }

    {
     System.out.println("child init block");
    }

    public static void main(String[] args) {
       new Child();
    }

}

