package collections.collectionsgupta.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class HashMap1 {
    public static void main(String[] args) {
        Map<String, Double> salaryMap = new HashMap<>();
        salaryMap.put("Paul", 8888.8);
        salaryMap.put("Shreya", 99999.9);

        Map<String, Object> copySalaryMap = new HashMap(salaryMap);
        Set<String> keys = copySalaryMap.keySet();

        for (String k : keys)
            System.out.println(k);

        salaryMap.remove("Paul");

        keys = copySalaryMap.keySet();

        for (String k : keys)
            System.out.println(k);

    }
}
