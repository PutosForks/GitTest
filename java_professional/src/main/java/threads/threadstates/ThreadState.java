/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.threadstates;

/**
 *
 * @author marko
 */
public class ThreadState extends Thread {

    public static void main(String[] args) {
        Thread t1 = new Thread();
        System.out.println(t1.getState());  //NEW
        t1.start();
        System.out.println(t1.getState());  //RUNNABLE
        try {
            t1.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();          //TERMINATED
        }

        System.out.println(t1.getState());
    }

}
