package classdesign.gupta.Static.staticinitblock;



class StaticBlock {

    static double var;

    static {
        var = (Math.random());
    }
}

public class StaticBlockDemo {

    public static void main(String[] args) {

        System.out.println(StaticBlock.var);

    }
}
