package com.app.dao;

import com.app.daoUtils.HibernateDAO;
import com.app.model.ClientDetail;

public class HibernateClientDetailDAO extends HibernateDAO<ClientDetail, Long>
        implements ClientDetailDAO {

    public HibernateClientDetailDAO() {
        super(ClientDetail.class);
    }

}
