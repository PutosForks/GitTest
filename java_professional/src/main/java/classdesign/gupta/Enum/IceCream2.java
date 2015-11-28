package classdesign.gupta.Enum;

public enum IceCream2 {

    VANILLA("white"),
    STRAWBERRY("pink"),
    WALNUT("brown");
    private String color;

    IceCream2(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name() + " is " + this.color;
    }

}

class UseIceCream2 {
    public static void main(String[] args) {
        System.out.println(IceCream2.VANILLA);
    }
}
