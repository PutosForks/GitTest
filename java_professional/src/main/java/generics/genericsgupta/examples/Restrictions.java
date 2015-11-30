package generics.genericsgupta.examples;

public class Restrictions {


    // cannot instantiate generic type
    public <T> void instantiate1(T element) {
        // T el = new T();
    }

    // can be done with reflection
    public <T> void instantiate2(T element, Class<T> cls) {
        // T el = new T();
        try {
            T el = cls.newInstance();
        } catch (InstantiationException | IllegalAccessException ie) {
            ie.printStackTrace();
        }

    }

}



