package threads.sync;

class Counter2 implements Runnable {

    public static int count = 0;

    public static void increment() {
        synchronized (Counter2.class) {
        count++;
        System.out.print(count + " ");
        }
    }

    public void run() {
     
        increment();
        increment();
        increment();
     
    }
}

public class DataRaceBlock {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Counter2());
        Thread t2 = new Thread(new Counter2());
        Thread t3 = new Thread(new Counter2());

        t1.start();
        t2.start();
        t3.start();
    }
}
