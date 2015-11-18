package classdesign.gupta.nestedclass.anonymousclass;

public class Pizza {
    Enum a;
    
    Object margaritta(final String ingredient) { // has to be final
        return new Pizza() {
            public String toString() {
                System.out.println(ingredient);
                return "Margaritha";
            }
            
        };
    }
    
}

class PizzaTest {

    public static void main(String[] args) {
        System.out.println(new Pizza().margaritta("Cheese"));
    }
    
}



