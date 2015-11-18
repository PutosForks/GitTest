package classdesign.covariant;

public abstract class Shape {

    public abstract Shape copy();
}

class Circle extends Shape {

    private int x, y;

    Circle() {
        x = 10;
        y = 20;
    };
     

    @Override
     public Circle copy() {
        Circle c = new Circle(); 
         System.out.println("Copied");
        return c;
    }

    ;

     
     public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = (Circle) c1.copy(); // has to be upcasted

    }

}
