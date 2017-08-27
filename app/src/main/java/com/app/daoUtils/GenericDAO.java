package com.app.daoUtils;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author marko
 */
public interface GenericDAO<T, ID extends Serializable> {

    T findByPrimaryKey(ID id);
    List<T> findAll(int startIndex, int fetchSize);
    List<T> findByExample(T exampleInstance, String[] excludeProperty);
    T save(T entity);
    void delete(T entity);
    
    void beginTransaction();
    void commitTransaction();

}
