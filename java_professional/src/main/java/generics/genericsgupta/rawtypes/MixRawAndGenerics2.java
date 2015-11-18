package generics.genericsgupta.rawtypes;

import java.util.Stack;

public class MixRawAndGenerics2 {

}

class Interoperability {

    public static void pushItems(Stack stackParam, Object item) {
        stackParam.push(item);
    }

    public static void main(String[] args) {
        Stack<String> stackObject = new Stack();
        stackObject.push("Dominik");
        String object = "aaa";
        pushItems(stackObject, object);

        String str = stackObject.pop();
        System.out.println(str);

        pushItems(stackObject, new Integer(22));
        String str2 = stackObject.pop();  //ava.lang.Integer cannot be cast to java.lang.String RUNTIME

    }

}
