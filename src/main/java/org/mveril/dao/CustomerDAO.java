package org.mveril.dao;

import org.mveril.entity.Customer;

import javax.persistence.*;
import java.util.List;

public class CustomerDAO extends DAO<Customer> {
    public CustomerDAO(EntityManager entityManager) {
        super(Customer.class, entityManager);
    }
    public List<Customer> findByFirstName(String firstName) {
        Query queryToFindCustomerByFirstName = entityManager.createQuery("select c from Customer c where c.firstName = :firstName");
        queryToFindCustomerByFirstName.setParameter("firstName", firstName);
        return queryToFindCustomerByFirstName.getResultList();
    }
}
