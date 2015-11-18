package classdesign.FinalClass;

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

}
