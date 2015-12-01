package collections.collectionsgupta.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by 502413934 on 1.12.2015.
 */
public class ListIterations {


	static <T> List<? extends T> getPlanetsReverse(List<? extends T> list) {

		List<T> reverse = new ArrayList<>();
		T el;
		for (ListIterator<? extends T> it = list.listIterator(list.size()); it.hasPrevious(); ) {
			el = (T) it.previous();
			System.out.println(el);
			reverse.add(el);
		}
		return reverse;

	}

	static <T> void replacePlanetswithIterator(List<T> list, T oldVal, T newVal) {
		ListIterator<T> it;
		for (it = list.listIterator(); it.hasNext();) {
			// pokud je hodnota oldVal = NULL, tak se preskoci
			if (oldVal == null ? it.next() == null : oldVal.equals(it.next())) {
				it.set(newVal);
			}
		}
	}


	public static void main(String[] args) {
		String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uran", "Neptun"};
		List<String> planetList = new ArrayList<>();
		planetList.addAll(Arrays.asList(planets));


		ListIterations li = new ListIterations();

		List<? extends String> res = ListIterations.<String>getPlanetsReverse(planetList);
		System.out.println(res);

		List<String> planetList2 = planetList;

		replacePlanetswithIterator(planetList2, "Earth", "Bravos");
		System.out.println(planetList2);



	}

}