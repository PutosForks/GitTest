package classdesign.gupta.nestedclass.anonymousclass;

public class Outer {

    Object foo() {
        return new Outer() {
            public String toString() {
                return "anonymous";
            }
        };
    }

    public static void main(String[] args) {
        Outer o = new Outer();
        System.out.println(o.foo());
    }

}
