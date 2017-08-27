package com.app.util;

import com.app.dao.AddressDAO;
import com.app.dao.ClientDAO;
import com.app.dao.ClientDetailDAO;
import com.app.dao.HibernateAddressDAO;
import com.app.dao.HibernateClientDAO;
import com.app.dao.HibernateClientDetailDAO;
import com.app.dao.HibernateSkillDAO;
import com.app.dao.SkillDAO;
import com.app.daoUtils.DAOFactory;

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
