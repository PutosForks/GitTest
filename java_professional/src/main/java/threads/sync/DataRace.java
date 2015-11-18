/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.sync;

class Counter implements Runnable {

    public static int count = 0;

    static synchronized void increment() {
        count++;
        System.out.print(count + " ");
    }

    public void run() {
        increment();
        increment();
        increment();
    }
}

public class DataRace {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Counter());
        Thread t2 = new Thread(new Counter());
        Thread t3 = new Thread(new Counter());

        t1.start();
        t2.start();
        t3.start();
    }
} 
