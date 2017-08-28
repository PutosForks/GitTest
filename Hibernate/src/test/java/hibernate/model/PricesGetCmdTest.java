package hibernate.model;

import org.hibernate.Session;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static hibernate.util.HibernateUtil.getSession;
import static hibernate.util.HibernateUtil.getSessionFactory;
import static org.junit.Assert.*;

public class PricesGetCmdTest {

    @Test
    public void TestMethod() {


        try {
            Session session = getSessionFactory().getCurrentSession();
            session.beginTransaction();

            List<Price> p = new ArrayList<>();

            p = session.createQuery("from Price order by item").list();

            ListIterator iter = p.listIterator();

            while (iter.hasNext()) {
                Price ms = (Price) iter.next();
                System.out.println(ms.getItem());
                System.out.println(ms.getPrice());
                System.out.println("");
                assertNotNull(ms.getItem());
                assertTrue((ms.getPrice() != null));
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            getSession().getTransaction().rollback();
        }


    }
}
