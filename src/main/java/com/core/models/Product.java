package com.core.models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Chris on 6/28/14.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "product_name")
    private String productName ;

    public Product() {

    }

    public Product(BigDecimal price, String productName) {
        this.price = price;
        this.productName = productName;
//        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

//    public long getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(long quantity) {
//        this.quantity = quantity;
//    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }






}
