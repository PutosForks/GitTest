package classdesign.gupta.overloading;

public class Employee {
}

class CEO extends Employee {
}

 class Travel {
    static void bookTicket(Employee e) {
        System.out.println("Economy class");
    }
    
    static void bookTicket (CEO c) {
        System.out.println("Business class");
    }
}

class TravleAgent {
    public static void main(String[] args) {
        CEO c = new CEO();
        Travel.bookTicket(c);
        
        Employee e = new CEO();
        Travel.bookTicket(e);
        
        
    }
    
}

