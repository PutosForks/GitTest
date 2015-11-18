package threads.runnable.DiceGameDemo;

public class Player implements Runnable {

    public String player;
    public static String lastPlayed;

    Player(String player) {
        this.player = player;

    }

    public void SetLastPlayer(String lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public void run() {
        for (int i = 0; i < 6; i++) {
            synchronized (Dice.class) {
                while (this.player == lastPlayed) {
                    try {
                        System.out.println(this.player + " is waiting for other palyer to finish!");
                        Dice.class.wait();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                if (Dice.getTurns() > 0) {
                    System.out.println("Player " + this.player + " rolled " + Dice.roll());
                    SetLastPlayer(this.player);
                }
                Dice.class.notify();

            }
        }
    }
}
