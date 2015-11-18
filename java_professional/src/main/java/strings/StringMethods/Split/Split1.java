package strings.StringMethods.Split;

public class Split1 {

    public static void main(String[] args) {
        String quote = "All people are equal in front of the law, but some are more then the othres";
        String[] splits = quote.split(" ");
        for (String split : splits) {
            System.out.println(split);
        }
        
        String path = "C:\\project\\task\\folder";
        System.out.println(path);
        String [] pathPattern = path.split("\\\\");
        
        for (String paths : pathPattern) {
            System.out.println(paths);
        }
        
        

    }

}
