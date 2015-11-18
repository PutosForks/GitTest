package threads.runnable.DiceGameDemo;

import java.util.Random;

public class Dice {

    private static int turns = 12;
    private static Random random = new Random();

    public synchronized static int roll() {
        turns--;
        return (random.nextInt(6) + 1);
    }
    
    public synchronized static int getTurns() {
        return turns;
    }

}
