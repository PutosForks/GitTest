/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdesign.Enum;

enum printerTypeEnum {

    DOTMATRIX, INKJET, LASER
}

public class PrinterType {

    printerTypeEnum printer;

    public PrinterType(printerTypeEnum printer) {
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
    }

    public static void main(String[] args) {
        PrinterType pt = new PrinterType(printerTypeEnum.INKJET);
        pt.feature();
    }
}
