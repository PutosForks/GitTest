package classdesign.gupta.casting;

public interface Media {
}

class CD implements Media {
}


class Animal {

}

class Testing {
    public static void main(String[] args) {
        Animal a = new Animal();
        Media m = (Media) a;  // can be casted, but will throw runtime Exception  (ClassCastException)



    }
}