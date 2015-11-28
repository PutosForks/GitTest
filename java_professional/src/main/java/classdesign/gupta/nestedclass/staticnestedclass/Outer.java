package classdesign.gupta.nestedclass.staticnestedclass;

public class Outer {

    static int outerStatic = 10;
    int outerInstance = 20;

    static class Inner {

        private static int innerStatic = 5;
        int innerInstance = 8;

        Inner () {
            System.out.println(Outer.outerStatic);
        }

    }

    static int outerStatic2 = Inner.innerStatic;

    public static void main(String[] args) {
        Inner nested1 = new Inner();
        System.out.println(nested1.innerInstance);
        System.out.println(Inner.innerStatic);
        System.out.println(Outer.outerStatic2);
    }

}

class TestInner {
    public static void main(String[] args) {
        Outer.Inner nested1 = new Outer.Inner();
        Outer outer1 = new Outer();
        //System.out.println(outer1.Inner.);
    }
}
