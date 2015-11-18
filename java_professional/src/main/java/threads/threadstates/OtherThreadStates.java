/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.threadstates;

class Sleepy implements Runnable {

    public void run() {
        synchronized (Sleepy.class) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}




public class OtherThreadStates {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Sleepy());
        Thread t2 = new Thread(new Sleepy());

        

        t1.start();
        System.out.println(t1.getName()+ " " + t1.getState()); // TIMED_WAITING  // holds the lock and sleeps
        t2.start();

        System.out.println(t2.getName()+ " " + t2.getState());  //BLOCKED
    }
}
