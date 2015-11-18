package oop.dao.abstractdao;

import java.util.ArrayList;

class Emp {

    int id;
    String name;
    int age;
    String address;
}

class Dept {

    int id;
    String name;
}

interface EmpDAO {

    public int create(Emp e);

    public Emp get(int id);

    public boolean delete(Emp e);

    public boolean update(Emp e);

    public ArrayList<Emp> getAll();
}

interface DeptDAO {

    public int create(Dept e);

    public Dept get(int id);

    public boolean delete(Dept e);

    public boolean update(Dept e);

    public ArrayList<Dept> getAll();

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

class DeptDAOOracleImpl implements DeptDAO {

    public int create(Dept e) {
        /* connect to datastore, insert data for employee e */
        return 0;
    }

    public Dept get(int id) {
        /* connect to datastore, retrieve and return data for employee-id id */
        return new Dept();
    }

    public boolean delete(Dept e) {
        /* connect to datastore and delete data for employee-id e.id */
        return false;
    }

    public boolean update(Dept e) {
        /* connect to datastore and update employee data */
        return false;
    }

    public ArrayList<Dept> getAll() {
        /* connect to datastore, retrieve emp data, return as Collection */
        return new ArrayList(1);
    }
}

class DeptDAOMySQLImpl implements DeptDAO {

    public int create(Dept e) {
        /* connect to datastore, insert data for employee e */
        return 0;
    }

    public Dept get(int id) {
        /* connect to datastore, retrieve and return data for employee-id id */
        return new Dept();
    }

    public boolean delete(Dept e) {
        /* connect to datastore and delete data for employee-id e.id */
        return false;
    }

    public boolean update(Dept e) {
        /* connect to datastore and update employee data */
        return false;
    }

    public ArrayList<Dept> getAll() {
        /* connect to datastore, retrieve emp data, return as Collection */
        return new ArrayList(1);
    }
}

abstract class DAOFactory {

    protected abstract EmpDAO getEmpDAO();

    protected abstract DeptDAO getDeptDAO();

    public EmpDAO getEmpDAOInstance() {
        return getEmpDAO();
    }

    public DeptDAO getDeptDAOInstance() {
        return getDeptDAO();
    }
}

class OracleDAOFactory extends DAOFactory {

    protected EmpDAO getEmpDAO() {
        return new EmpDAOOracleImpl();
    }

    protected DeptDAO getDeptDAO() {
        return new DeptDAOOracleImpl();
    }
}

class MySQLDAOFactory extends DAOFactory {

    protected EmpDAO getEmpDAO() {
        return new EmpDAOMySQLImpl();
    }

    protected DeptDAO getDeptDAO() {
        return new DeptDAOMySQLImpl();
    }
}

public class AbstractDao {

    public static void main(String args[]) {
        DAOFactory factory = new OracleDAOFactory();
        EmpDAO empDAO = factory.getEmpDAOInstance();
        DeptDAO deptDAO = factory.getDeptDAOInstance();
        Emp emp = new Emp();
        empDAO.create(emp);
        Dept dept = new Dept();
        deptDAO.update(dept);
    }
}
