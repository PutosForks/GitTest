package collections.collectionsgupta.set;

import java.util.EnumSet;
import java.util.Set;

public class EnumSetDemo {

    private enum Color {
        RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255);

        private int r;
        private int g;
        private int b;

        Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }


        public int getR() {
            return r;
        }

        public int getG() {
            return g;
        }

        public int getB() {
            return b;
        }
    }

    static void drawLine(Set<Color> color) {
        System.out.println("Srawing line in :" + color);
    }


    public static void main(String[] args) {
        // Yellow
        EnumSet<Color> yellow = EnumSet.of(Color.RED, Color.GREEN);
        drawLine(yellow);

        //White
        EnumSet<Color> white = EnumSet.range(Color.RED, Color.BLUE);
        drawLine(white);
    }


}
