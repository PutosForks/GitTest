package hibernate.dao;

import hibernate.daoUtils.HibernateDAO;
import hibernate.model.Client;
import java.util.List;

/*
   What follows are the implementations of the generic CRUD operations, quite straightforward.
 */

public class HibernateClientDAO extends HibernateDAO<Client, Long>
        implements ClientDAO {

    public HibernateClientDAO() {
        super(Client.class);
    }

    public List<Client> findAllVerified() {
        Client client = new Client();
        client.setVerified(Boolean.TRUE);
        return super.findByExample(client, null);

    }

}
