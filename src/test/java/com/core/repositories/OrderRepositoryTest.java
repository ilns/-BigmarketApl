package com.core.repositories;

import com.core.models.Customer;
import com.core.models.Order;
import com.core.models.Product;
import com.core.repository.CustomerRepository;
import com.core.repository.OrderRepository;
import com.core.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context-config.xml")
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    private Order order;

    private Product product;

    private Customer customer;

    @Before
    @Transactional
    @Rollback(false)
    public void setup(){
        product = new Product();
        product.setId(1);
        product.setProductName("nameProduct");
        productRepository.addOrUpdateProduct(product);

        List<Product> products = new ArrayList<>();
        products.add(product);

        customer = new Customer();
        customer.setId(1);
        customer.setFirstName("first");
        customer.setLastName("last");
        customerRepository.addOrUpdateContact(customer);



        order = new Order();
        order.setId(2);
        order.setProducts(products);
        order.setCustomer(customer);

        orderRepository.addOrder(order);

    }


    @Test
    @Transactional
    public void testGetById() {
        assertNotNull(orderRepository.getById(order.getId()));
    }

    @Test
    @Transactional
    public void testGetByIdReturnNull() {
        assertNull(orderRepository.getById(-1));
    }

    @Test
    @Transactional
    public void testDeleteCustomer() {
        orderRepository.deleteOrder(order);
        assertTrue(orderRepository.getAllOrders().size() == 0);
    }


    @Test
    @Transactional
    public void testFindProductEquals() {
        Order retrivedOrder = orderRepository.getById(2);
        Assert.assertEquals(order, retrivedOrder);
    }

}
