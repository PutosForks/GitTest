package com.app.dao;

import com.app.daoUtils.HibernateDAO;
import com.app.model.Address;

public class HibernateAddressDAO extends HibernateDAO<Address, Long>
        implements AddressDAO {

    public HibernateAddressDAO() {
        super(Address.class);
    }

}
