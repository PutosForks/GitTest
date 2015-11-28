package classdesign.gupta.equals;

public class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point other = (Point) o;
            if ((this.x == other.x) && (this.y == other.y)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Point a = new Point(1, 3);
        Point b = new Point(1, 4);
        Point c = new Point(1, 3);

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

    }


}
