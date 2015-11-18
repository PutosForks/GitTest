package classdesign.gupta.Enum;

public enum IceCream {

    VANILLA, STRAWBERRY, WALNUT, CHOCOLATE;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String val) {
        color = val;
    }

    public String toString() {
        return "MyColor:" + color;
    }
}

class UseIceCream {

    public static void main(String[] args) {
        IceCream.VANILLA.setColor("white");
        System.out.println(IceCream.VANILLA.getColor());
        System.out.println(IceCream.VANILLA);
        System.out.println(IceCream.VANILLA.name());
    }
}
