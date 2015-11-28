package classdesign.gupta.Enum;

public class NoLocalEnum {

    enum PrinterTYpe {A, B, C}

    public void method() {
     //   enum PrinterTYpe2 {A, B, C}   // Enum Must not be local
    }

}
