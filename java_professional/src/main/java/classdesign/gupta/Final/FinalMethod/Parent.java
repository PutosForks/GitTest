package classdesign.gupta.Final.FinalMethod;

public class Parent {

    private final void method (Integer a) {

    }

}


class Child extends Parent {

   // @Override                                     does not Override, because Base.method is private
    final void method (Integer a) {

    }


}
