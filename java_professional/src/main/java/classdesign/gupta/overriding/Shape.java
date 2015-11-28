package classdesign.gupta.overriding;

public class Shape {
    protected void display() {
        System.out.println("Display-base");
    }
}

class Circle extends Shape {
    public void display(){  // public or protected
        System.out.println("Display-derived");
    }
}