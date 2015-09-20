package com.core.repositories;

import com.core.models.Customer;
import com.core.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context-config.xml")
public class CustomeRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    private Customer customer;


    @Before
    @Transactional
    @Rollback(false)
    public void setup() {
        customer = new Customer();
        customer.setId(1);
        customer.setFirstName("first");
        customer.setLastName("last");
        customer.setCity("Dnp");
        customer.setStreet("Str");
        customer.setNumbHouse(23);
        customerRepository.addOrUpdateContact(customer);
    }

    @Test
    @Transactional
    public void testGetById() {
        assertNotNull(customerRepository.getById(customer.getId()));
    }

    @Test
    @Transactional
    public void testGetByIdReturnNull() {
        assertNull(customerRepository.getById(-1));
    }

    @Test
    @Transactional
    public void testDeleteCustomer() {
        customerRepository.deleteCustomer(customer);
        assertTrue(customerRepository.getAllCustomer().size() == 0);
    }


    @Test
    @Transactional
    public void testFindCusomerEquals() {
        Customer retrivedCustomer = customerRepository.getById(1);
        Assert.assertEquals(customer, retrivedCustomer);
    }
}

