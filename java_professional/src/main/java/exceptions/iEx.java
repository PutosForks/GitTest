package exceptions;

import java.io.IOException;

interface IEx {
    String info();
}
class Exception1 extends IOException implements IEx{
    public String info() {
        return "I'm Base Exception";
    }
}
class Exception2 extends Exception implements IEx {
    public String info() {
        return "I'm Derived Exception";
    }
}
class TestVariableTypeInMultiCatch {
    public static void main(String args[]) {
        try {
            int a = 10;
            if (a <= 10)throw new Exception1();
            else throw new Exception2();
        }
        catch (Exception1 | Exception2 ex) {
            System.out.println(ex.info());
        }
    }
}