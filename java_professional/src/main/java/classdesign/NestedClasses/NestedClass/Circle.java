package classdesign.NestedClasses.NestedClass;

public class Circle {

     class Point {

        private int xPos;
        private int yPos;

        Point(int xPos, int yPos) {
            this.xPos = xPos;
            
            this.yPos = yPos;
        }

        public String toString() {
            return "xPos " + xPos + " yPos " + yPos;
        }

    }

    private Point center;
    private int radius;

    public Circle(int x, int y, int r) {
        // instantiating the main class. You need to prefix the object reference 
        // of the outer class in order to access inner. 
        // Therefore, new opertaor is prefixed with this

        // You basically have to create an instnce of outer class in order to 
        // access the inner
        center = this.new Point(x, y);
        this.radius = r;
    }

    public String toString() {
        return " MidPoint " + center + " radius " + radius;
    }

    public static void main(String[] args) {
        System.out.println(new Circle(10, 20, 30)); //MidPoint xPos 10 yPos 20 radius 30
    }

}
