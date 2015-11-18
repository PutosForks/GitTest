package collections.collectionsgupta.algorithms.array;

import java.util.Arrays;

/**
 * Created by 502413934 on 14.9.2015.
 */
public class SortObjects {
    public static void main(String[] args) {
        String[] strArray = {"ocP", "oCP", "OcP", "OCp", "Ocp"};

        for (String str : strArray) System.out.print(str + " ");

        Arrays.sort(strArray);
        System.out.println();

        for (String str : strArray) System.out.print(str + " ");

        /*Each character has a corresponding ASCII or Unicode value. The uppercase letters
        have a lower ASCII value than their lowercase counterparts.


        Watch out for exam questions that sort string objects starting
        with a space. A space has a lower ASCII or Unicode value than lowercase
        or uppercase letters.


        */


    }


}
