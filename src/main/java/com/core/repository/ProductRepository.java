package com.core.repository;

import com.core.models.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodymyr on 17.09.15.
 */
@Repository
public class ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Product getById(long id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Transactional
    public void addOrUpdateProduct(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }

    @Transactional
    public void deleteProduct(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    @Transactional
    public List<Product> getAllProducts() {
        String strQuery = "from Product";
        List<Product> productList = new ArrayList<>();
        try {
            productList.addAll(sessionFactory.getCurrentSession().createQuery(strQuery).list());
        } catch (Exception ignore) {}
        return productList;
    }

}
