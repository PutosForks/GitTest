package generics.genericsgupta.basics;


public class PairSame<T> {

    T object1;
    T object2;

    PairSame(T object1, T object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public String toString() {
        return "" + object1 + object2;
    }

}

class PairSameTest {

    public static void main(String[] args) {
        PairSame<Integer> ps1 = new PairSame<>(10, 20);
        System.out.println(ps1);

        PairSame<String> ps2 = new PairSame<>("Hello", "Stranger");
        System.out.println(ps2);
    }
}
