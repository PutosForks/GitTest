package generics.genericsgupta.examples;

import java.util.ArrayList;
import java.util.List;


public class OnlineExcersize {

	public <E> int counter(List<E> list) {
		int res = 0;
		for (E element : list) {
			res++;
		}
		return res;
	}


	public <E> E[] swap(E[] arr, int src, int dest) {
		E temp = arr[src];
		arr[src] = arr[dest];
		arr[dest] = temp;
		return arr;
	}



		public static <T extends Object & Comparable<? super T>> T maxEl(List<? extends T> list, int begin, int end) {

			T maxElem = list.get(begin);

			for (++begin; begin < end; ++begin)
				if (maxElem.compareTo(list.get(begin)) < 0)
					maxElem = list.get(begin);
			return maxElem;
		}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(20000);
		list.add(100);
		list.add(105);


		System.out.println(maxEl(list, 1, 3));

		List<String> abc = new ArrayList<>();
		abc.add("marko");
		abc.add("ivan");
		abc.add("monikaaaaa");
		abc.add("dominik");
		abc.add("monika");
		abc.add("eva");

		System.out.println(maxEl(abc, 3, 5));
	}



}




