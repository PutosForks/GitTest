package generics.genericsgupta.genericmethods;

class ParcelGeneric<T> {

    public <X> void deliver(X x) {
        System.out.println(x.getClass());
    }

    public static void main(String args[]) {
        ParcelGeneric<String> parcel = new ParcelGeneric<>();
        parcel.<Integer>deliver(new Integer(10));  // class java.lang.Integer
        //parcel.<>deliver(new Integer(10)); #D
        parcel.deliver("Hello");  // class java.lang.String
        parcel.deliver(10);   // class java.lang.Integer
    }
}
