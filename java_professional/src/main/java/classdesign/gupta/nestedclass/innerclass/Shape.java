package classdesign.gupta.nestedclass.innerclass;

class Shape {
    public Shape() {
        System.out.println("Shape constructor");
    }
    public class Color {
        public Color() {
            System.out.println("Color constructor");
        }
    }
}
class TestColor {
    public static void main(String []args) {
        // Shape.Color black = new Shape().Color(); //
        Shape.Color black = new Shape().new Color();
    }
}