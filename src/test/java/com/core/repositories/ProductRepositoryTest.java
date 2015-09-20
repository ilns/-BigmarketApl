package com.core.repositories;

import com.core.models.Product;
import com.core.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Chris on 7/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context-config.xml")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repo;

    private Product product;

    @Before
    @Transactional
    @Rollback(false)
    public void setup() {
        product = new Product();
        product.setId(1);
        product.setProductName("name");
        product.setPrice(BigDecimal.valueOf(25.5));
        repo.addOrUpdateProduct(product);
    }

    @Test
    @Transactional
    public void testGetById() {
        assertNotNull(repo.getById(product.getId()));
    }

    @Test
    @Transactional
    public void testGetByIdReturnNull() {
        assertNull(repo.getById(-1));
    }

    @Test
    @Transactional
    public void testDeleteProduct() {
        repo.deleteProduct(product);
        assertTrue(repo.getAllProducts().size() == 0);
    }
}
