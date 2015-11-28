package classdesign.gupta.Static.staticinitblock;



class StaticBlock {

    static {
        var = (Math.random());
    }

    static double var;

}

public class StaticBlockDemo {

    public static void main(String[] args) {

        System.out.println(StaticBlock.var);

    }
}
