package collections.collectionsgupta.list;

import java.util.ArrayList;

public class Emp {

    Integer id;
    String name;

    Emp (Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Emp) {
            Emp emp = (Emp) object;
            if (emp.id == this.id && emp.name.equals(this.name)) {
                return true;
            }

        }
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Emp> list = new ArrayList<>();
        list.add(new Emp(121, "Shreya"));
        list.add(new Emp(55, "Harry"));
        list.add(new Emp(15, "Paul"));
        list.add(new Emp(121, "Shreya"));
        System.out.println(list.size());
        Emp emp = new Emp (121, "Shreya");
        list.remove(emp);
        System.out.println(list.size());
    }


}
