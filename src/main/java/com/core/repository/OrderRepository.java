package com.core.repository;


import com.core.models.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by volodymyr on 17.09.15.
 */
@Repository
public class OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addOrder(Order order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Transactional
    public void deleteOrder(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    @Transactional
    public boolean deleteById(long id) {
        Session session = (Session) sessionFactory.getCurrentSession();
        Order toDelete = (Order) session.load(Order.class, id);
        session.delete(toDelete);
        return true;
    }


    @Transactional
    public List<Order> getAllOrders() {
        String strQuery = "from Order";
        List<Order> orderList = sessionFactory.getCurrentSession().createQuery(strQuery).list();
        if (orderList == null) {
            return null;
        }
        return orderList;
    }
}
