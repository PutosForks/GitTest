package collections.collectionsgupta.map;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class EMap {
    public static void main(String... args) {
        HashMap props = new HashMap();
        props.put("Harry", "Manth");
        props.put("Paul", "Rosen");
        props.put("Alm", "Bld");
        Set keySet = props.keySet();
        keySet = new TreeSet(keySet);
    }
}