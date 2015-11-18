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
public class MyThread1 extends Thread {
    
    public void run() {
        try {
            sleep(1000);    
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            
        }
        System.out.println(Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {
        Thread thrd = new MyThread1();
        thrd.start();
        System.out.println(Thread.currentThread().getName());
    }
}

  
