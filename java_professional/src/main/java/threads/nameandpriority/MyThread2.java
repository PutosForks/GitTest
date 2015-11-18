/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.nameandpriority;

/**
 *
 * @author marko
 */
public class MyThread2 implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName());

    }

    public static void main(String[] args) {
        Thread thrd = new Thread(new MyThread2());
        thrd.start();
        System.out.println(Thread.currentThread().getName());
    }
}
