package generics.genericsgupta.basics;


public class BoxPrinter<T> {

    private T val;

    BoxPrinter(T val) {
        this.val = val;
    }

    public String toString() {
        return "[" + val + "]";
    }
}

class BoxPrinterTest {

    public static void main(String[] args) {
        BoxPrinter<Integer> bp1 = new BoxPrinter<>(10);
        System.out.println(bp1);

        BoxPrinter<String> bp2 = new BoxPrinter<>("Hello man");
        System.out.println(bp2);
    }
}
