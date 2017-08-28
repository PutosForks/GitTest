package hibernate.daoUtils;

import hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.util.List;

import static hibernate.util.HibernateUtil.CommitTransaction;
import static hibernate.util.HibernateUtil.getSession;
import static org.hibernate.criterion.Example.create;

/**
 *
 * @param <T>  - persistentClass
 * @param <ID>
 *     An implementation of the interfaces could be done with any state-management capable persistence service. First, the generic CRUD implementation
       There are some interesting things in this implementation. First, it clearly needs a Session to work, provided with setter injection.
       You could also use constructor injection. How you set the Session and what scope this Session has is of no concern to the actual DAO implementation.
       A DAO should not control transactions or the Session scope.
 */
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
