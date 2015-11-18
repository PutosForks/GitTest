package classdesign.gupta.Enum;

public enum IceCream3 {

    VANILLA("white"),
    STRAWBERRY("pink"),
    WALNUT("brown") {

                public String toString() {
                    return name() + " overrideed method ";
                }

                public void flavour() {
                    System.out.println("Great!");
                }
            },
    CHOCOLATE("dark brown");
    private String color;

    IceCream3(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name() + " is " + this.color;
    }

    public void flavour() {
        System.out.println("Good!");
    }

}

class UseIceCream3 {

    public static void main(String[] args) {

        for (IceCream3 ic : IceCream3.values()) {

            System.out.println(ic);
        }
        
        IceCream3.VANILLA.flavour();
        IceCream3.WALNUT.flavour();
        
        
        
        
    }
}
