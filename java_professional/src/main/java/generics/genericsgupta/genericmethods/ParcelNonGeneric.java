package generics.genericsgupta.genericmethods;

class ParcelNonGeneric {

    public <X> void deliver(X x) {
        System.out.println(x.getClass());
    }

    public static void main(String args[]) {
        ParcelNonGeneric parcel = new ParcelNonGeneric();
        parcel.<Integer>deliver(new Integer(10));  // class java.lang.Integer
        parcel.deliver("Hello");  // class java.lang.String
        parcel.deliver(10);   // class java.lang.Integer
    }
}
