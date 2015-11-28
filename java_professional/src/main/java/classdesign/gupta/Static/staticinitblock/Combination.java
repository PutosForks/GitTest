package classdesign.gupta.Static.staticinitblock;

public class Combination {

    {
        System.out.println("Initializer block");
    }

    static {
        System.out.println("Static Initializer block");
    }

    Combination () {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        Combination c = new Combination();
    }
}

