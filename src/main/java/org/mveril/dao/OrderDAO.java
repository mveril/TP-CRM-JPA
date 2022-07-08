package org.mveril.dao;

import org.mveril.entity.Order;

import javax.persistence.EntityManager;

public class OrderDAO extends DAO<Order> {

    public OrderDAO(EntityManager entityManager) {
        super(Order.class, entityManager);
    }
}
