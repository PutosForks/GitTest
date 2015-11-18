package classdesign.gupta.Enum;

public enum Level {
    
    
    BEGINNER, INTERMEDIATE, EXPERT;

    static {
        System.out.println("Static init block");
    }

    Level() {
        System.out.println("constructor");
    }
    
    public static void main(String[] args) {
       System.out.println(Level.BEGINNER); 
    }
}



class LevelTest {
    public static void main(String[] args) {
        System.out.println(Level.BEGINNER);
        System.out.println(Level.BEGINNER.name());
    }
}



