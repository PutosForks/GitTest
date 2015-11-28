package classdesign.gupta.Static.staticinitblock;


class DemoMultipleStaticBlocks2 {

    {
        ++staticVar;    // Instance initializer can access static variable before created
    }

    static {
        // ++staticVar;              // Static variable cannot access static variable before created
        staticVar = (int) Math.random();  // YES
        staticVar = 10;              // YES

    }

    static int staticVar = 0;

    static {
        ++staticVar;
    }

    public DemoMultipleStaticBlocks2() {
        System.out.println("Constructor:" + staticVar);
    }

    public static void main(String args[]) {
        new DemoMultipleStaticBlocks();
    }
}
