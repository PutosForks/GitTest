package hibernate.dao;

import hibernate.daoUtils.HibernateDAO;
import hibernate.model.Address;

public class HibernateAddressDAO extends HibernateDAO<Address, Long>
        implements AddressDAO {

    public HibernateAddressDAO() {
        super(Address.class);
    }

}
