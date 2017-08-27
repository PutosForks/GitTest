package com.app.daoUtils;

import com.app.dao.AddressDAO;
import com.app.dao.ClientDAO;
import com.app.dao.ClientDetailDAO;
import com.app.util.HibernateDAOFactory;
import com.app.dao.SkillDAO;

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
