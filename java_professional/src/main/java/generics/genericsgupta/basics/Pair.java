package generics.genericsgupta.basics;

public class Pair<T1, T2> {

    T1 object1;
    T2 object2;

    Pair(T1 object1, T2 object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public T1 getFirst() {
        return this.object1;
    }

    public T2 getSecond() {
        return this.object2;
    }

}

class PairTest {

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("World Cup", 2010);
        System.out.println(p1.getFirst() + " was held in " + p1.getSecond() + "!");
    }
}
