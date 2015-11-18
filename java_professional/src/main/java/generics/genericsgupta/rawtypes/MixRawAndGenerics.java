package generics.genericsgupta.rawtypes;

class Phone {

}

class Parcel<T> {

    private T t;

    void set(T t) {
        this.t = t;
    }

    public T get() {
        return this.t;
    }
}

public class MixRawAndGenerics {

    public static void main(String[] args) {
        Parcel parcel = new Parcel<Phone>();

        /*
         considers it Object type, because
         parcel is raw
         */

        parcel.set(new String("Hello"));
        parcel.set(new Integer(1));
        parcel.set(new Phone());
        // Phone phone = parcel.get();  
        
        /* 
         Object cannot be converted to Phone.
         No implicit cast with raws 
         */
        
        Object phone = parcel.get(); 

        Parcel<Phone> parcel2 = new Parcel<Phone>();
        //parcel2.set(new String()); will not compile
        parcel2.set(new Phone());
        Phone phone2 = parcel2.get();

        
        // works as well
        Parcel<Phone> parcel3 = new Parcel();
        parcel3.set(new Phone());
        Phone phone3 = parcel3.get();


        
    }
}
