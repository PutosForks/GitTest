package hibernate.dao;

import hibernate.daoUtils.HibernateDAO;
import hibernate.model.ClientDetail;

public class HibernateClientDetailDAO extends HibernateDAO<ClientDetail, Long>
        implements ClientDetailDAO {

    public HibernateClientDetailDAO() {
        super(ClientDetail.class);
    }

}
