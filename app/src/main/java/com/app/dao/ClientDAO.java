package com.app.dao;

import com.app.daoUtils.GenericDAO;
import java.util.List;
import com.app.model.Client;

public interface ClientDAO extends GenericDAO<Client, Long> {

    public List<Client> findAllVerified();

}
