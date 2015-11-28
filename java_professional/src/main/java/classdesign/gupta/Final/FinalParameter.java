package classdesign.gupta.Final;

public class FinalParameter {

    double a;

    FinalParameter(double a) {
        a++;
        this.a = a;
    }

    FinalParameter(final int a) {
        // a++;  // final varaible may not be modified
        this.a = a;
    }


    public static void main(String[] args) {
        double d = 0;
        FinalParameter fp = new FinalParameter(d);
        System.out.printf(""+ fp.a);      // 1.0
    }

}
