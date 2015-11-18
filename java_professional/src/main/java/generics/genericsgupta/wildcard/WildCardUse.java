package generics.genericsgupta.wildcard;

import java.util.ArrayList;
import java.util.List;

public class WildCardUse {
    
     static void printList (List<?> list) {
    	 for (Object l : list) {
    		 System.out.println("["+l+"]");
    	 }
     }
     
     public static void main(String [] args) {
    	 List<Integer> intList = new ArrayList<>();
    	 intList.add(10);
    	 intList.add(20);
    	
    	 WildCardUse.printList(intList); 
    	 
    	List<String> strList = new ArrayList<>();
 		strList.add("a");
 		strList.add("b");
    	 
 	WildCardUse.printList(strList);
    	 
    	 
    	 
    	 
    	 
     }
}






