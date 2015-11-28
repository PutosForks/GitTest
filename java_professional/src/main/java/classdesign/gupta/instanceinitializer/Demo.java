package classdesign.gupta.instanceinitializer;


public class Demo {

    Demo () {
            System.out.println("This is constructor 1!");
}

    public Demo (String dummy) {
        System.out.println("This is constructor 2");
    }


    {
        System.out.println("Initializer 1");
    }

    {
        System.out.println("Initializer 2");
    }


    public static void main(String[] args) {
      //  Demo a = new Demo();
        Demo b = new Demo("dummy text");
    }


}
