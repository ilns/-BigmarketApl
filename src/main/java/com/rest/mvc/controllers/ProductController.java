package com.rest.mvc.controllers;

import com.core.models.Product;
import com.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by volodymyr on 17.09.15.
 */

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/products.json", method = RequestMethod.GET)
    public @ResponseBody List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public @ResponseBody String addNewContract( @RequestParam("price") String price,
                                                @RequestParam("productName") String productName) {

        Product product = null;
        BigDecimal priceb = new BigDecimal(price);
        product = new Product(priceb,productName);

        productRepository.addOrUpdateProduct(product);
        return "product add";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/delete-product", method = RequestMethod.POST)
    public @ResponseBody String deleteContact(
            @RequestParam(value = "productIds", required = true) String productIds){

        String[] productIdsArr = productIds.split(",");

        List<Product> products = productRepository.getAllProducts();
        for (Product product : products) {
            for (String customerId: productIdsArr) {
                if (product.getId() == Long.parseLong(customerId)) {
                    productRepository.deleteProduct(product);
                }
            }
        }
        return "product deleted";
    }
}