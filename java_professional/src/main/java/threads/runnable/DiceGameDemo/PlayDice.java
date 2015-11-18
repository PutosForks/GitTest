/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.runnable.DiceGameDemo;

/**
 *
 * @author marko
 */
public class PlayDice {

    public static void main(String[] args) {
        Thread player1 = new Thread(new Player("JACK"));
        Thread player2 = new Thread(new Player("JILL"));
        
        player1.start();
        player2.start();
    }

}
