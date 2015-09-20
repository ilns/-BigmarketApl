package com.core.repositories;

import com.core.models.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Chris on 7/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class AccountRepoTest {

//    @Autowired
//    private AccountRepo repo;

    private Product product;

    @Before
    @Transactional
    @Rollback(false)
    public void setup()
    {
        product = new Product();
        product.setProductName("name");
        product.setPrice(BigDecimal.valueOf(25.5));
//        repo.createAccount(product);
    }

    @Test
    @Transactional
    public void testFind()
    {
//        assertNotNull(repo.findAccount(product.getId()));
    }
}
