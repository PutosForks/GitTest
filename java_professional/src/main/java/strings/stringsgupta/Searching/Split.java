package strings.stringsgupta.Searching;

public class Split {

    public static void main(String[] args) {

        String s = "Paint the cup, cop and cap";

        String[] sArr = s.split("c.p");

        for (String x : sArr) {
            System.out.println(x);
        }

//        Paint the 
//        , 
//        and 
//        
        sArr = s.split("c.p", 2);  // will return only 2 tokens

        for (String x : sArr) {
            System.out.println(x);
        }

//        Paint the 
//        , cop and cap
    }
}
