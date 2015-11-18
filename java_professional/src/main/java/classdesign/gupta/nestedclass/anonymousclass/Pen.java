package classdesign.gupta.nestedclass.anonymousclass;

public class Pen {

    public void write() {
        System.out.println("Pen-write");
    }

    public void showColor() {

    }
}

class Lecture {

    public static void main(String[] args) {
        new Pen().write();

        Pen pen = new Pen() {
            public void write() {
                System.out.println("writing with a pen at lecture");
            }

            public void showColor() {
                System.out.println("Pen is black");
            }

        };

        pen.write();
        pen.showColor();

    }

}
