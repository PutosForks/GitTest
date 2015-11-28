package classdesign.gupta.Enum;

public enum Keywords {
    ASSERT(1.4), // line1
    DO, IF, WHILE; // line2
    double version = 1.0; // line3
    Keywords() { // constructor 1
        this.version = 1.0; // constructor 1
    } // constructor 1
    Keywords(double version) { // constructor 2
        this.version = version; // constructor 2
    } // constructor 2
    public static void main(String args[]) {
        Keywords[] keywords = Keywords.values();
        for (Keywords val:keywords) System.out.println(val);
    }
}
