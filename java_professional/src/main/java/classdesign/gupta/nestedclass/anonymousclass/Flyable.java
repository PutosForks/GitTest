package classdesign.gupta.nestedclass.anonymousclass;

public interface Flyable {

    void fly();
}

class Plane {

    Flyable flyable = new Flyable() {   // cretaes on the fly object that implements the interface
        public void fly() {
            System.out.println("Plane is flying");
        }
    };

}

class TestFlight {

    public static void main(String[] args) {
        Plane plane = new Plane();
        plane.flyable.fly();   //  somewhat cumbersome, but works
    }
}
