/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.collectionsgupta.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author marko
 */
public class ArrayAsList {

    public static void main(String[] args) {

        Double[] weeklyTemperatures = {31.4, 21.9, 28.7, 34.6, 27.9, 26.8};
        List<Double> temperature = Arrays.asList(weeklyTemperatures);
        System.out.println("Highest Temperature recorded was " + Collections.max(temperature));
        System.out.println("Lowest Temperature recorded was " + Collections.min(temperature));

        //temperature.add(30.0);  //java.lang.UnsupportedOperationException
        // NEED to create a new list and add
        List<Double> newTemperature = new ArrayList<Double>(Arrays.asList(weeklyTemperatures));
        newTemperature.add(30.0);
        System.out.println(newTemperature);
    }

}
