package collections.collectionsgupta.map.navigablemap;

import java.util.NavigableMap;
import java.util.TreeMap;


public class TreeMapUse {
    public static void main(String[] args) {
        NavigableMap<Integer, String> examScores = new TreeMap <>();
        
        examScores.put(90, "Jana");
        examScores.put(40, "Eva");
        examScores.put(50, "Monika" );
        examScores.put(10, "Petra");
        
        System.out.println("Data in map " + examScores);  // naturally orders them by key
        System.out.println("Data in descending order " + examScores.descendingMap());
        System.out.println("Detail who passed " + examScores.tailMap(50));  // >= 50
        System.out.println("Lowset entry " + examScores.firstEntry());  
        System.out.println("Highest entry " + examScores.lastEntry());  
        
        
    }
    
}
