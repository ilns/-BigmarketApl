package com.rest.mvc.controllers;

import com.core.models.Customer;
import com.core.models.Order;
import com.core.models.Product;
import com.core.repository.CustomerRepository;
import com.core.repository.OrderRepository;
import com.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodymyr on 20.09.15.
 */
@Controller
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;


    @RequestMapping(value = "/orders.json", method = RequestMethod.GET)
    public @ResponseBody List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add-order", method = RequestMethod.POST)
    public @ResponseBody String addOrder( @RequestParam("customerId") String customerId,
                                          @RequestParam("productIds") String productIds) {

        Customer customer = customerRepository.getById(Long.parseLong(customerId));
        String [] productIdsArr = productIds.split(",");
        List<Product> products = new ArrayList<>();
        for(String productId: productIdsArr) {
            products.add(productRepository.getById(Long.parseLong(productId)));
        }

        Order newOrder = new Order();
        newOrder.setCustomer(customer);
        newOrder.setProducts(products);
        orderRepository.addOrder(newOrder);
        return "order added";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/delete-order", method = RequestMethod.POST)
    public @ResponseBody String deleteOrder(
            @RequestParam(value = "orderIds", required = true) String orderIds){

        String[] orderIdsArr = orderIds.split(",");

        for (String orderId: orderIdsArr) {
            orderRepository.deleteById(Long.parseLong(orderId));
        }

        return "order deleted";
    }


}
