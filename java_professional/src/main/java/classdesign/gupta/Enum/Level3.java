package classdesign.gupta.Enum;

public enum Level3 {


    BEGINNER, INTERMEDIATE, EXPERT;

    static {
        System.out.println("Static init block");
    }

    {
        System.out.println("Init block");
    }

    Level3() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        System.out.println("");
        System.out.println(Level.BEGINNER);      // mrknout i co udela s Timto
    }
}




