package threads.runnable.restaurant;

public class CoffeeMachine implements Runnable {

    static String CofeeMade = null;
    static final Object lock = new Object();
    protected static int coffeeNumber = 0;

    void MakeCoffee() {
        synchronized (CoffeeMachine.lock) {
            if (CofeeMade != null) {
                try {
                    System.out.println("Waiting for waiters notification to make coffee");
                    CoffeeMachine.lock.wait();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
            CofeeMade = "Coffee" + coffeeNumber++;
            System.out.println("Coffee machine says:\"Made coffee\" " + CofeeMade);
            CoffeeMachine.lock.notifyAll();
            System.out.println("Waiting for waiter to deliver coffee");
        }
    }

    public void run() {
        while (CoffeeMachine.coffeeNumber < 10) {
            MakeCoffee();
            try {
                Thread.sleep(5000);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
