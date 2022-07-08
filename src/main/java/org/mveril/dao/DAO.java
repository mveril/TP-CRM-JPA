package org.mveril.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public abstract class DAO<T> {

    private Class<T> type;

    protected final EntityManager entityManager;

    public DAO(Class<T> type,EntityManager entityManager) {
        this.type = type;
        this.entityManager = entityManager;
    }

    public void create(T itemToCreate) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(itemToCreate);
        tx.commit();
    }

    public T findById(int id) {
        T item = entityManager.find(type, id);
        return item;
    }

    public List<T> findAll() {
        Query findAllQuery = entityManager.createQuery("select i from "+type.getName()+" i");
        return findAllQuery.getResultList();
    }

    public void delete(T item) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(item);
        tx.commit();
    }

    public void delete(int id) {
        T itemToDelete = findById(id);
        delete(itemToDelete);
    }

    public void update(T item) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(item);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}
