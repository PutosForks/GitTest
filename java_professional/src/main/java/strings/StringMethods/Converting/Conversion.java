package strings.StringMethods.Converting;

/**
 *
 * @author marko
 */
public class Conversion {
    public static void main(String[] args) {
        
        String s = String.valueOf(10); // right way to convert
        System.out.println(s); 
      //String s2 = 10; // incompatable
      //String s2 = (String) 10; // incompatable  
        
        String s3 = ""+10;
        System.out.println(s3);
        
        String s4 = Integer.toString(10);
        System.out.println(s4);
        
        
        
        
    }
    
}
