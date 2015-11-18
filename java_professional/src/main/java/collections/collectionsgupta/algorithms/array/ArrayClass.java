package collections.collectionsgupta.algorithms.array;

import java.util.Arrays;

public class ArrayClass {

    public static void main(String[] args) {

        // PRINTING AN ARRAY 
        Integer[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr);// Ljava.lang.Integer;@6276e1db
        // way to print array content is
        System.out.println(Arrays.toString(arr));

        // SORTING AN ARRAY
        String strArr[] = {"1", "21", "111", "31", "16"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));  //[1, 111, 16, 21, 31]

        Integer[] intArr = {1, 21, 111, 31, 16};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr)); //[1, 16, 21, 31, 111]

        // SEARCHING IN AN ARRAY
        Integer[] intArr2 = {1, 21, 111, 31, 16, 56};
        int index = Arrays.binarySearch(intArr2, 56);
        System.out.println(index);// - 3 a mistake, 
        // you can search an array only if you SORTED it

        Arrays.sort(intArr2);
        index = Arrays.binarySearch(intArr2, 56); // 4  
        System.out.println(index);// 

    }
}
