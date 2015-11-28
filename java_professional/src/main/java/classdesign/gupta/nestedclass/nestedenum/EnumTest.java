package classdesign.gupta.nestedclass.nestedenum;

public class EnumTest {
    PrinterType printerType;
    enum PrinterType {INKJET, DOTMATRIX, LASER}

    public EnumTest(PrinterType pType) {
        printerType = pType;
    }
    public static void main(String[] args) {
        // PrinterType pType = new PrinterType();     // cannot instatiate enum With New
        EnumTest enumTest = new EnumTest(PrinterType.LASER);
    }
}