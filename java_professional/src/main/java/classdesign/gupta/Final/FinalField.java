package classdesign.gupta.Final;

class Final {

    final int a;
    int b;

    Final(int a) {
        this.a = a; // initialization of "a" must be in constructor or initialization block
    }

    Final() {
        this(20);
    }

    final void setValue(int b) {
        this.b = b;
    }

}

public class FinalField {

    public static void main(String[] args) {

        Final finObjcet = new Final(10);
        finObjcet.setValue(20);

        // finObjcet.a = 20; // cannot assign a value to final variable
    }

}
