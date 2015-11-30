package generics.genericsgupta.inheritance;


abstract class Parcel<T> {
    protected T t;

    Parcel(T t) {
        setParcel(t);
    }

    T getParcel() {
        return t;
    }

    void setParcel(T t) {
        this.t = t;
    }
}


class ParcelGeneric<T, X> extends Parcel<T> {
    private X x;

    ParcelGeneric(T t, X x) {
        super(t);
        this.x = x;

    }

    void print() {
        System.out.printf("Variables are: %s %s %s", t, x, "\n");
    }

}

class ParcelNonGeneric extends Parcel<String> {

    Integer x;

    ParcelNonGeneric (String t , Integer x) {
        super(t);
        this.x = x;
    }

    void print() {
        System.out.printf("Variables are: %s %s %s", t, x, "\n");
    }

}

public class genericinheritance {
    public static void main(String[] args) {
        ParcelGeneric<String, Integer> parcelGen = new ParcelGeneric<>("Super", 9);
        parcelGen.print();

        ParcelNonGeneric parcelNon = new ParcelNonGeneric("Survival Style", 9);
        parcelNon.print();
    }
}