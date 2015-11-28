package classdesign.gupta.nestedclass.innerclass;

public class Outer {

    Inner innerInstance = new Inner();  // as instance member

    class Inner {
    }

    static void dummy() {
        Outer outer1 = new Outer();
        Inner innerInstace1 = outer1.new Inner();  // in static method of Outer class. Needs an Outer object created first
     // Inner innerInstace2 = new Outer.Inner();  // cannot work
     // Inner innerInstace3 = new Inner();  // cannot work
    }

    void dummy2() {
        Inner innerInstace2 = new Inner();     // in instance method of Outer class
    }
}

class testInnerOuter {

    public static void main(String[] args) {

        Outer.Inner innerInstace3 = new Outer().new Inner();  // in different class. Needs an Outer object created first

    }

}
