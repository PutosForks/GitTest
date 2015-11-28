package classdesign.gupta.Enum;

public enum Level2 {

    BEGINNER, INTERMEDIATE, EXPERT;

    Level2() {
        System.out.println("Constructor");
    }

}


class testEnum {
    public static void main(String[] args) {
        // Level2 l = new Level2();     // enum cannot be instatiated
    }
}