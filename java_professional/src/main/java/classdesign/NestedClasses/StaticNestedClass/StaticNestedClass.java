package classdesign.NestedClasses.StaticNestedClass;

class Outer {

    String out;
    static String out2;

    static class Inner {

        static String in;

        Inner(String in) {
            Inner.in = in;
            Outer.out2 = in + " from inner"; // no problem to access outer class members (static only)

            System.out.println(Inner.in);
            System.out.println(Outer.out2);

            // non-static variable cannot be accessed from static context
            //System.out.println(out);  
        }

    }

    Outer(String out) {
        this.out = out;
        System.out.println(this.out);
        Inner newIn = new Inner(out + " Initalizing");  // access class
        newIn.in = "He, he he";  // access inner class members through object of inner class
    }

    void print() {
        System.out.println("PRINTING: " + out + " " + out2);
    }

    void printStatic() {
        System.out.println("PRINTING STATIC: " + out);
    }

}

public class StaticNestedClass {

    public static void main(String[] args) {
        // initailizes inner and outer class
        Outer a = new Outer("Strings");
        a.print();

        // initailizes only inner class
        Outer.Inner b = new Outer.Inner("Strings 2");
        // b.print     // only inner class is initialized, static cannot address non-static
        // b.printStatic();    // cannot even use static members 
    }

}
