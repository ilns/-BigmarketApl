package com.core.repository;


import com.core.models.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by volodymyr on 17.09.15.
 */
@Repository
public class CustomerRepository  {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public void addOrUpdateContact(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }


    @Transactional
    public void deleteCustomer(Customer customer) {
        sessionFactory.getCurrentSession().delete(customer);
    }

    @Transactional
    public Customer getById(long id) {
        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
    }


    public void deleteCustomerById(long id) {

    }

    @Transactional
    public List<Customer> getAllCustomer() {
        String strQuery = "from Customer";
        List<Customer> contactList = sessionFactory.getCurrentSession().createQuery(strQuery).list();
        if (contactList == null) {
            return null;
        }
        return contactList;
    }
}
