package classdesign.gupta.nestedclass.anonymousclass;

public class Pen2 {

    public String color;

    public void write() {
        System.out.println("Pen-write");
    }

    public String getColor() {
        return this.color;
    }
}

class Lecture2 {

    void notes(Pen pen) {
        pen.write();
    }

}

class Student {

    public static void main(String[] args) {

        Lecture2 lecture = new Lecture2();

        lecture.notes(new Pen());

        lecture.notes(new Pen() {
            public void write() {
                System.out.println("Student taking notes");
            }
        });

    }

}
