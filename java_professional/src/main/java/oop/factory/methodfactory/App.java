package oop.factory.methodfactory;

interface App {
    void open(String filename);
}


// two classes of files being opened
class WordProcessor implements App {
    public void open(String filename) {
        System.out.println("Launch WordProcessor using " + filename);
    }
}

class TextEditor implements App {
    public void open(String filename) {
        System.out.println("Launch TextEditor using " + filename);
    }
}



abstract class AppFactory {

    public abstract App getApp();

    public App getAppInstance() {
        App appln = getApp();
        return appln;
    }


}

class WordAppFactory extends AppFactory {
    public App getApp() {
        return new WordProcessor();
    }
}

class TextEditAppFactory extends AppFactory {
    public App getApp() {
        return new TextEditor();
    }
}

class Client {
    public static void main(String args[]) {
        AppFactory factory = new WordAppFactory();
        App app = factory.getAppInstance();
        app.open("Hello.doc");
        app = new TextEditAppFactory().getAppInstance();
        app.open("Hello.xml");
    }
}