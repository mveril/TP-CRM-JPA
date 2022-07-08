package org.mveril.dao;

import javax.persistence.*;

public class DAOFactory {
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {

        if(entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm");
            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }

    private static CustomerDAO customerDAO = null;
    public static CustomerDAO getCustomerDAO() {

        if(customerDAO == null) {
            customerDAO = new CustomerDAO(getEntityManager());
        }
        return  customerDAO;
    }

    private static OrderDAO orderDAO = null;
    public static OrderDAO getOrderDAO() {

        if(orderDAO == null) {
            orderDAO = new OrderDAO(getEntityManager());
        }
        return orderDAO;
    }
}
