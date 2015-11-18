package strings.StringMethods.Formating;


public class Circle {
    private int x, y, radius;
    public Circle (int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    void area () {
        double tempArea = Math.PI * radius * radius;
        System.out.printf("Area of the circle is %.2f\n", tempArea);
    }
  
    public static void main(String[] args) {
        Circle circle = new Circle(10,12,4);
        circle.area();
        
    }
  
}
