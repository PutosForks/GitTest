package generics.genericsgupta.bounded;

abstract class Gift {
    abstract double getWeight();
}


class Book extends Gift {
    public double getWeight() {
        return 3.2;
    }
}

class Phone extends Gift {
    public double getWeight() {
        return 1.1;
    }
}


class Parcel<T extends Gift> {
    protected T t;


    T getParcel() {
        return t;
    }

    void setParcel(T t) {
        this.t = t;
    }

    Double getWeight() {
        return t.getWeight();
    }
}

class testParcel {
    public static void main(String[] args) {

        Parcel<Phone> parcel = new Parcel<Phone>();
        parcel.setParcel(new Phone());
        System.out.println(parcel.getWeight());


    }
}