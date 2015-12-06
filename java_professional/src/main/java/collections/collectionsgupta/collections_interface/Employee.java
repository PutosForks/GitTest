package collections.collectionsgupta.collections_interface;

import java.util.*;


class Employee implements Comparable<Employee>{
    private String name;
    private String color;
    private double salary;
    private Department department;

    @Override
    public int compareTo(Employee e) {
        if (this.salary > e.salary) return 1;
        if (this.salary < e.salary) return -1;
        return 0;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        //  if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(salary, employee.salary) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(color, employee.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, salary);
    }
}


