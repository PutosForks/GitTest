package hibernate.daoUtils;

import hibernate.dao.AddressDAO;
import hibernate.dao.ClientDAO;
import hibernate.dao.ClientDetailDAO;
import hibernate.util.HibernateDAOFactory;
import hibernate.dao.SkillDAO;

public abstract class DAOFactory {

    public static final Class FACTORY_CLASS = HibernateDAOFactory.class;

    public static DAOFactory getFactory() {
        try {
            return (DAOFactory) FACTORY_CLASS.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to create factory!");
        }
    }

    public abstract ClientDAO getClientDAO();

    public abstract ClientDetailDAO getClientDetailDAO();

    public abstract SkillDAO getSkillDAO();

    public abstract AddressDAO getAddressDAO();

}
