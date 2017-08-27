package com.app.dao;

import com.app.daoUtils.HibernateDAO;
import com.app.model.Client;
import java.util.List;

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
