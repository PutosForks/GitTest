package generics.genericsgupta.examples;

import java.util.ArrayList;
import java.util.List;

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

    // instanceof
	public void instanceofTest (List<?> list) {

		if (list instanceof ArrayList<?>) {
			// do something
		}
	}

	public <E> void instanceofTest2 (List<E> list) {

		// list instanceof ArrayList<E>  CANNOT

	}

    //cast
	public void castTest() {

		List<Double> l1 = new ArrayList<>();
		//ArrayList<Integer> l2 = (ArrayList<Integer>) l1;  // cannot

		List<? extends Number> l3 = new ArrayList<>();
		List<Double> l4 = (List<Double>) l3;               // can


	}

	// Overload -> not if same after erasure

    public void method (List<Number> list) {

	}

	// public void method (List<String> list) {}  clashes


}



