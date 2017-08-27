package com.app.daoUtils;

import java.io.Serializable;
import java.util.List;
import com.app.util.HibernateUtil;
import static com.app.util.HibernateUtil.CommitTransaction;
import static com.app.util.HibernateUtil.getSession;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import static org.hibernate.criterion.Example.create;

public abstract class HibernateDAO<T, ID extends Serializable> implements
        GenericDAO<T, ID> {

    private Class<T> persistentClass;

    public HibernateDAO(Class c) {
        persistentClass = c;

    }

    public List<T> findAll(int startIndex, int fetchSize) {
        Criteria criteria = getSession().createCriteria(persistentClass);
        criteria.setFirstResult(startIndex);
        criteria.setFetchSize(fetchSize);
        return criteria.list();
    }

    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        Criteria criteria = getSession().createCriteria(persistentClass);
        Example example = create(exampleInstance);

        if (excludeProperty != null) {
            for (String excludeProperty1 : excludeProperty) {
                example.excludeProperty(excludeProperty1);
            }
        }

        criteria.add(example);
        return criteria.list();

    }

    public T findByPrimaryKey(ID id) {
        return (T) getSession().load(persistentClass, id);

    }

    public T save(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public void beginTransaction() {
        HibernateUtil.beginTransaction();
    }

    public void commitTransaction() {
        CommitTransaction();
    }

}
