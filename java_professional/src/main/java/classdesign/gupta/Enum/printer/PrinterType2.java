package classdesign.gupta.Enum.printer;

enum printerTypeEnum {

    DOTMATRIX(10), INKJET(20), LASER(50);

    private int pagePrintCapacity;


    // private constructor
    printerTypeEnum(int pagePrintCapacity) {
        this.pagePrintCapacity = pagePrintCapacity;
    }

    public int getPagePrintCapacity() {
        return this.pagePrintCapacity;
    }

}

public class PrinterType2 {

    printerTypeEnum printer;

    public PrinterType2(printerTypeEnum printer) {
        this.printer = printer;
    }

    public void feature() {

        switch (printer) {
            case DOTMATRIX:
                System.out.println("Dot-matrix printers are economical and almost obsolete");
                break;
            case INKJET:
                System.out.println("Inkjet printers provide decent quality prints");
                break;
            case LASER:
                System.out.println("Laser printers provide best quality prints");
                break;

        }
        System.out.println("Page per minute " + this.printer.getPagePrintCapacity());

    }

    public static void main(String[] args) {
        PrinterType2 pt = new PrinterType2(printerTypeEnum.INKJET);
        pt.feature();
    }

}

