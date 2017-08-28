package hibernate.dao;

import hibernate.daoUtils.GenericDAO;
import hibernate.model.Client;

import java.util.List;

/**
 * The DAO interface for a particular entity extends the generic interface and provides the type arguments:
 */

public interface ClientDAO extends GenericDAO<Client, Long> {

    public List<Client> findAllVerified();

}
