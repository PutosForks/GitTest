package oop.dao.simpledao;

import java.util.ArrayList;

class Emp {

    int id;
    String name;
    int age;
    String address;
}

interface EmpDAO {

    public int create(Emp e);

    public Emp get(int id);

    public boolean delete(Emp e);

    public boolean update(Emp e);

    public ArrayList<Emp> getAll();
}

class EmpDAOOracleImpl implements EmpDAO {

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

class EmpDAOMySQLImpl implements EmpDAO {

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

abstract class DAOFactory {

    public static int ORACLE = 1;
    public static int MYSQL = 2;

    public static EmpDAO getEmpDAOInstance(int DBtype) {
        if (DBtype == ORACLE) {
            return new EmpDAOOracleImpl();
        } else if (DBtype == MYSQL) {
            return new EmpDAOMySQLImpl();
        } else {
            return null;
        }
    }
}

public class SimpleDao {

    public static void main(String args[]) {
        EmpDAO empDAO = DAOFactory.getEmpDAOInstance(DAOFactory.ORACLE);
        Emp emp = new Emp();
        emp.id = 10;
        emp.name = "Harry";
        emp.age = 39;
        emp.address = "UK";
        empDAO.create(emp);
    }
}
