package classdesign.gupta.Static.staticinitblock;

public class StaticInitBlocks {

    static int staticVar = 10;

    static {
        System.out.println("First");
        ++staticVar;
    }

    static {
        System.out.println("Second");
        ++staticVar;
    }

    static void modifyStaticVar() {
        ++staticVar;
    }

    public StaticInitBlocks() {
        System.out.println("Constructor:" + staticVar);
    }

    public static void main(String args[]) {
        new StaticInitBlocks();  // First, Second,  12
        modifyStaticVar();      // makes 13
        new StaticInitBlocks();    // only prints out the 13 from previous
    }
}
