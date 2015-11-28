package classdesign.gupta.nestedclass.anonymousclass;

public interface Admissible {}
class University {
    static void admit(Admissible adm) {
        System.out.println("admission complete");
    }
    public static void main(String args[]) {
        admit(new Admissible() {});
    }
}