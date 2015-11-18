package threads.runnable.restaurant;

public class CoffeeShop {

    public static void main(String[] args) {
        Thread cm = new Thread(new CoffeeMachine());
        Thread w = new Thread(new Waiter());

        cm.start();
        w.start();

    }

}
