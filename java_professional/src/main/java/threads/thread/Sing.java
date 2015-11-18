package threads.thread;


public class Sing extends Thread {

    @Override
    public void run() {
        System.out.println("Singing");
    }
}

class SingAndDance {
    public static void main(String[] args) {
        Thread sing = new Sing();

        sing.start();
        System.out.println("Dancing");

    }
}
