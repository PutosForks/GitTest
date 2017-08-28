package hibernate.util;

import hibernate.dao.AddressDAO;
import hibernate.dao.ClientDAO;
import hibernate.dao.ClientDetailDAO;
import hibernate.dao.HibernateAddressDAO;
import hibernate.dao.HibernateClientDAO;
import hibernate.dao.HibernateClientDetailDAO;
import hibernate.dao.HibernateSkillDAO;
import hibernate.dao.SkillDAO;
import hibernate.daoUtils.DAOFactory;

/**
 * We could bring it all together in a DAO factory, which when a DAO is constructed
 * contains nested classes to implement CRUD-only DAOs with no business-related operations:
 */

public class HibernateDAOFactory extends DAOFactory {

    public ClientDAO getClientDAO() {
        return new HibernateClientDAO();
    }

    public ClientDetailDAO getClientDetailDAO() {
        return new HibernateClientDetailDAO();
    }

    public SkillDAO getSkillDAO() {
        return new HibernateSkillDAO();
    }

    public AddressDAO getAddressDAO() {
        return new HibernateAddressDAO();
    }

}
