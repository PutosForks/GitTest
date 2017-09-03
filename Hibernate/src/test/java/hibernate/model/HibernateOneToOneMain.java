package hibernate.model;

import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class HibernateOneToOneMain {

    public static void main(String[] args) {

        JsTransaction txn = buildDemoTransaction();

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try{
            //Get Session
            session = HibernateUtil.getSession();
            System.out.println("Session created");
            //start transaction
            tx = session.beginTransaction();
            //Save the Model object
            session.save(txn);
            //Commit transaction
            tx.commit();
            System.out.println("Transaction ID="+txn.getId());

            //Get Saved Trasaction Data
            printTransactionData(txn.getId(), sessionFactory);

        }catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            e.printStackTrace();
        }finally{
            if(!sessionFactory.isClosed()){
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }
    }

    private static void printTransactionData(long id, SessionFactory sessionFactory) {
        Session session = null;
        Transaction tx = null;
        try{
            //Get Session
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            //start transaction
            tx = session.beginTransaction();
            //Save the Model object
            JsTransaction txn = (JsTransaction) session.get(JsTransaction.class, id);
            //Commit transaction
            tx.commit();
            System.out.println("Transaction Details=\n"+txn);

        }catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            e.printStackTrace();
        }
    }

    private static JsTransaction buildDemoTransaction() {
        JsTransaction txn = new JsTransaction();
        txn.setDate(new Date());
        txn.setTotal(100);

        JsCustomer cust = new JsCustomer();
        cust.setAddress("Bangalore, India");
        cust.setEmail("pankaj@gmail.com");
        cust.setName("Pankaj Kumar");

        txn.setCustomer(cust);

        cust.setTxn(txn);
        return txn;
    }

}