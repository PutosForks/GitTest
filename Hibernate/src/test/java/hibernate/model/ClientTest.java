package hibernate.model;

import org.hibernate.Session;
import org.junit.Test;

import static hibernate.util.HibernateUtil.getSessionFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientTest {

    @Test
    public void ClientTest() {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        ClientDetail cd = new ClientDetail();
        cd.setPasswordHint("user2");

        Client c = new Client();
        c.setUserName("user2");
        c.setPassword("password2");
        cd.setClient(c);
        c.setClientDetail(cd);

        session.saveOrUpdate(cd);
        session.saveOrUpdate(c);

        session.getTransaction().commit();

        session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String clientName = (String) session.createQuery("select password from Client where userName = :userName").setString("userName","user2").uniqueResult();

        assertNotNull(clientName);
        assertEquals("Name fits", clientName, "password2");

        session.getTransaction().commit();

    }
}
