package collections.collectionsgupta.algorithms.array;

import java.util.Arrays;

/**
 * Created by 502413934 on 14.9.2015.
 */
public class SortArrays {
    public static void main(String args[]) {
        int[] intArray = {20, 14, 4, 10, 5, 3};
        for (int a : intArray) System.out.print(a + " ");
        System.out.println();

        Arrays.sort(intArray);
        for (int a : intArray) System.out.print(a + " ");
        System.out.println();

        intArray = new int[]{20, 14, 4, 10, 5, 3};
        Arrays.sort(intArray, 1, 5);
        for (int a : intArray) System.out.print(a + " ");   //20 4 5 10 14 3

    }


}
