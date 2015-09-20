package com.rest.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by volodymyr on 18.09.15.
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String getMain() {
        return "main";
    }

    // customer
    @RequestMapping("/customers")
    public String getCustomers() {
        return "customers";
    }

    @RequestMapping("/add-customer")
    public String getAddCustomer() {
        return "add-customer";
    }


    // product
    @RequestMapping("/products")
    public String getProduct() {
        return "products";
    }

    @RequestMapping("/add-product")
    public String getAddProduct() {
        return "add-product";
    }

    //order
    @RequestMapping("/orders")
    public String getOrder() {
        return "orders";
    }

    @RequestMapping("/add-order")
    public String getAddOrder() {
        return "add-order";
    }

    
}
