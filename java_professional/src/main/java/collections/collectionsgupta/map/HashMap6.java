package collections.collectionsgupta.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


enum Color {
        RED,BLUE,YELLOW;
        }


public class HashMap6 {
    public static void main(String[] args) {

        Map<Color, String> colorMap = new HashMap<>();
        colorMap.put(Color.RED, "Passion");
        colorMap.put(Color.BLUE, "Stability");
        colorMap.put(Color.YELLOW, "Energy");

        Collection<String> mood = colorMap.values();
        Set<Color> colors = colorMap.keySet();
        Set<Map.Entry<Color, String>> colorsMood = colorMap.entrySet();

        for (String s : mood)
            System.out.println(s);
        for (Color c : colors)
            System.out.println(c);
        for (Map.Entry pair : colorsMood)
            System.out.println(pair.getKey() + ":" + pair.getValue());
    }
}




