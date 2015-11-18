package threads.runnable.restaurant;

public class Waiter implements Runnable {

    public void getCoffee() {
        synchronized (CoffeeMachine.lock) {
            if (CoffeeMachine.CofeeMade == null) {
                try {
                    System.out.println("Waiter: waits till coffe machine notifies!");
                    CoffeeMachine.lock.wait();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

            System.out.println("Waiter: delivering the coffee!");
            CoffeeMachine.CofeeMade = null;
            CoffeeMachine.lock.notifyAll();
            System.out.println("Waiter: takes orders until another coffee is ready!");

        }
    }

    public void run() {
        while (CoffeeMachine.coffeeNumber < 10) {
            getCoffee();
            System.out.println();
        }
    }

}
