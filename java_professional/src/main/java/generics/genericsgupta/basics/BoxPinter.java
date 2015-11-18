package generics.genericsgupta.basics;


public class BoxPinter<T> {

    private T val;

    BoxPinter(T val) {
        this.val = val;
    }

    public String toString() {
        return "[" + val + "]";
    }
}

class BoxPinterTest {

    public static void main(String[] args) {
        BoxPinter<Integer> bp1 = new BoxPinter<>(10);
        System.out.println(bp1);

        BoxPinter<String> bp2 = new BoxPinter<>("Hello man");
        System.out.println(bp2);
    }
}
