package collections.collectionsgupta.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ShuffleList {

	public static <E> List<? extends E> unionAndShuffle (List<? extends E> list,
	                                        List<? extends E> list2) {
		List<E> resList = new ArrayList<>();
		resList.addAll(list);
		resList.addAll(list2);

		Collections.shuffle(resList);
		return resList;
	}

	public static void main(String[] args) {
		List a = new ArrayList();
		List b = new ArrayList();

		a.add("a");
		a.add("b");
		a.add("c");
		b.add("x");
		b.add("y");
		b.add("z");

		List c = unionAndShuffle(a, b);
		System.out.println(c);

	}






}
