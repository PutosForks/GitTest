package oop.factory.simplefactory;


interface iApp {
    void open(String filename);
}


class WordProcessor implements iApp {
    public void open(String filename) {
        System.out.println("Launch WordProcessor using " + filename);
    }
}

class TextEditor implements iApp {
    public void open(String filename) {
        System.out.println("Launch TextEditor using " + filename);
    }
}

class AppFactory {
    public static iApp getAppInstance(String fileExtn) {
        iApp appln = null;
        if (fileExtn.equals(".doc")) {
            appln = new WordProcessor();
        } else if (fileExtn.equals(".txt") ||
                fileExtn.equals(".xml")) {
            appln = new TextEditor();
        }
        return appln;
    }
}

class Client {
    public static void main(String args[]) {
        iApp iApp = AppFactory.getAppInstance(".doc");
        iApp.open("Hello.doc");
        iApp iApp2 = AppFactory.getAppInstance(".xml");
        iApp2.open("Hello.xml");
    }
}
