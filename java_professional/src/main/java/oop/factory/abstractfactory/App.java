package oop.factory.abstractfactory;

import java.util.Arrays;

interface App { /* code */
}

class WordProcessor implements App { /* code */
}

class TextEditor implements App { /* code */
}

interface Font { /* code */
}

class RichFont implements Font { /* code */
}

class RegularFont implements Font { /* code */
}

abstract class AppFactory {
    protected abstract App getApp();

    protected abstract Font getFont();

    public App getAppInstance() {
        App appln = getApp();
        return appln;
    }

    public Font getFontInstance() {
        Font font = getFont();
        return font;
    }
}

class WordAppFactory extends AppFactory {
    protected App getApp() {
        return new WordProcessor();
    }

    protected Font getFont() {
        return new RichFont();
    }
}

class TextEditAppFactory extends AppFactory {
    protected App getApp() {
        return new TextEditor();
    }

    protected Font getFont() {
        return new RegularFont();
    }
}

class ClientAbstractFactoryMethod {
    public static void main(String args[]) {
        AppFactory factory1 = new WordAppFactory();
        App app1 = factory1.getAppInstance();
        Font font1 = factory1.getFontInstance();
        System.out.println(app1 + ":" + font1);
        AppFactory factory2 = new TextEditAppFactory();
        App app2 = factory2.getAppInstance();
        Font font2 = factory2.getFontInstance();
        System.out.println(app2 + ":" + font2);
    }

    Arrays a;
}

