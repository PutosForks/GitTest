package oop.factory.simplefactory;

public interface Shape {

    void draw();
}


class Rectangle implements Shape {
    public void draw() {
        System.out.println("Rectangle");
    }
}


class Circle implements Shape {
    public void draw() {
        System.out.println("Circle");
    }
}


class Cube implements Shape {
    public void draw() {
        System.out.println("Cube");
    }
}


class ShapeFactory {

    static public Shape getInstance(String s) {

        Shape shape;


        switch (s.toLowerCase()) {
            case "rectangle":
                shape = new Rectangle();
                break;
            case "circle":
                shape = new Circle();
                break;
            case "cube":
                shape = new Cube();
                break;
            default:
                shape = null;
        }
        return shape;
    }


    public static void main(String[] args) {
        Shape shape = ShapeFactory.getInstance("RectaNgle");
        shape.draw();
    }


}


