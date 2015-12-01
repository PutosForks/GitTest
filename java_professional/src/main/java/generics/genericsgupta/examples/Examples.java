package generics.genericsgupta.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Examples {


    public <T extends Comparable<T>> int countGreaterThan(T[] anArray, T e) {
        int count = 0;

        for (T l : anArray) {
            if (l.compareTo(e) > 0) count++;
        }
        return count;
    }


}


///////////////////////////////////////////////////////////////////////////////////////////////////////


class Box<T> {

    List<T> lst = null;

    Box() {
        lst = new ArrayList<>();
    }

    Box(Box<T> box) {
        this.lst = box.lst;
    }

    Box(T e) {
        lst = new ArrayList<>();
        set(e);
    }

    public static void main(String[] args) {
        Box<Number> box = new Box<>();
        box.set(new Double(10.1));
        box.set(new Integer(20));

        //  Box<Integer> boxInt = new Box<>(new Box<Number>());  cannot do Box<Number> does not comply to Box<Integer>


    }

    int set(T e) {
        lst.add(e);
        return lst.size();
    }

}


class Sum {

    // can be called with Integer, Double etc
    public double SumOfList(List<? extends Number> list) {
        double res = 0.0;
        ListIterator<? extends Number> iter = list.listIterator();
        while (iter.hasNext()) {
            res += (Double) iter.next();
        }
        return res;
    }
}


class WildCardSubtype {
    public static void main(String[] args) {
      List <Integer> intList = new ArrayList<>();
      //List <Number>  numberList = intList;  //cannot do


     List <? extends Integer> intListExtended = new ArrayList();
     List <? extends Number>  doubleList = intList;
    }


}

