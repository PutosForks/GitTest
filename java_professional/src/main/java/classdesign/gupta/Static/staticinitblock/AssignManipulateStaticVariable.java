package classdesign.gupta.Static.staticinitblock;

public class AssignManipulateStaticVariable {
    static {
        rate = 10;
    }
    static int rate = 0;
    static {
        ++rate;
    }
    public AssignManipulateStaticVariable() {
        System.out.println(rate);
    }
    public static void main(String args[]) {
        new AssignManipulateStaticVariable();        // prints 1
    }
}


/**

 THIS IS WHAT COMPILER DOES

 static int rate;
 static
 {
 rate = 10;
 rate = 0;
 ++rate;
 }

 **/