package oop.singleton;


/* Eager initialization */
class Singleton1 {
    private static final Singleton1 anInstance = new Singleton1();

    public static Singleton1 getInstance() {
        return anInstance;
    }
    private Singleton1() {
        System.out.println("Private Constructor");
    }
}

/*Synchronized lazy initialization*/
class Singleton2 {
    private static Singleton2 anInstance = null;

    synchronized  public static Singleton2 getInstance() {
        if (anInstance == null) {
            anInstance = new Singleton2();
        }
        return anInstance;
    }

    private Singleton2() {
        System.out.println("Private Constructor");
    }

}

/*Synchronized lazy initialization*/
class Singleton3 {
    private static Singleton3 anInstance = null;

    public static Singleton3 getInstance() {
        synchronized (Singleton3.class) {
            if (anInstance == null) {
                anInstance = new Singleton3();
            }
        }
        return anInstance;
    }

    private Singleton3() {
        System.out.println("Private Constructor");
    }

}

/* easiest way to do this */
enum Singleton4 {
    INSTANCE

}