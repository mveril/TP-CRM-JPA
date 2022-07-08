package org.mveril.dao;

import org.mveril.entity.Customer;
import org.mveril.enumeration.ClientState;

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

    public List<Customer> findByCompanyName(String companyName) {
        Query queryToFindCustomerByFirstName = entityManager.createQuery("select c from Customer c where c.companyName = :companyName");
        queryToFindCustomerByFirstName.setParameter("companyName", companyName);
        return queryToFindCustomerByFirstName.getResultList();
    }

    public List<Customer> findByState(ClientState state) {
        Query queryToFindCustomerByFirstName = entityManager.createQuery("select c from Customer c where c.state = :state");
        queryToFindCustomerByFirstName.setParameter("state", state);
        return queryToFindCustomerByFirstName.getResultList();
    }
}
