package strings.stringsgupta.Replacing;

public class StringReplace {

    public static void main(String[] args) {

        String str = "RENT-TENT";
        String newString = str.replace(
                str.substring(2, 5), //RET-TETENT
                str.subSequence(str.indexOf("T"),
                        str.lastIndexOf('N')));
        System.out.println(newString);

        str = "cat cup copp";
        newString = str.replaceAll("c.p\\B", "()");
        System.out.println(newString);  //cat cup ()p

        /*
         Unlike replace, replaceAll doesn’t accept method parameters of type
         CharSequence. Watch out for passing of objects of class StringBuilder to replace.
         */
        str = "cat cup copp";
        newString = str.replaceAll("c.p\\b", "()"); //cat () copp
        System.out.println(newString);

        newString = str.replace("c.p", "()");
        System.out.println(newString);  //cat cup copp

        newString = str.replaceFirst("c.p\\b", "()");
        System.out.println(newString); //cat () copp

        str = "Start startup, time to start";
        System.out.println(str.substring(0,1).compareTo(str.substring(6,7))); // negative number (s is bigger than S)

    }
}
