/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.runnable;

/**
 *
 * @author marko
 */
public class Bomb implements Runnable {

    String countDowmList[] = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    public void run() {
        try {
            for (int i = countDowmList.length - 1; i >= 0; i--) {
                Thread.sleep(1000);
                System.out.println(countDowmList[i]);

            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

}

class BombUse {

    public static void main(String[] args) {
        Thread bomb = new Thread(new Bomb());
        bomb.start();
        try {
            bomb.join();  // waits for thread to die
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("BOOM!!!");

    }
}
