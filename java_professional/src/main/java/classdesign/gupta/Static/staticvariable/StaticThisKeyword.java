package classdesign.gupta.Static.staticvariable;

public class StaticThisKeyword {

    static String var;

    StaticThisKeyword(String var) {
        StaticThisKeyword.var = var;  // better than this.var, because static
    }

    String getVar() {
        return var;
    }

}

class StaticThisKeywordDemo {

    public static void main(String[] args) {
        StaticThisKeyword stk = new StaticThisKeyword("La, la");

        System.out.println(stk.getVar());

    }
}
