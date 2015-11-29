package oop.dao;

import java.util.ArrayList;

class Emp {
    int id;
    String name;
    int age;
    String address;
}

interface iEmpDAO {
    int create(Emp e);
    Emp get(int id);
    boolean delete(Emp e);
    boolean update(Emp e);
    ArrayList<Emp> getAll();
}

class EmpDAOImpl implements iEmpDAO {

    public int create(Emp e) {
        /* connect to datastore, insert data for employee e */
        return 0;
    }

    public Emp get(int id) {
        /* connect to datastore, retrieve and return data for employee-id id */
        return new Emp();
    }

    public boolean delete(Emp e) {
        /* connect to datastore and delete data for employee-id e.id */
        return false;
    }

    public boolean update(Emp e) {
        /* connect to datastore and update employee data */
        return false;
    }

    public ArrayList<Emp> getAll() {
        /* connect to datastore, retrieve emp data, return as Collection */
        return new ArrayList(1);
    }
}

public class Dao {

    public static void main(String args[]) {
        Emp emp = new Emp();
        emp.id = 10;
        emp.name = "Harry";
        emp.age = 39;
        emp.address = "UK";
        iEmpDAO dao = new EmpDAOImpl();
        dao.create(emp);
        emp.name = "Harry M";
        emp.age = 40;
        dao.update(emp);
        Emp emp2 = dao.get(11);
        if (emp2 != null) {
            dao.delete(emp2);
        }
    }
}
