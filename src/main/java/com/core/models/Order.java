package com.core.models;
import javax.persistence.*;
import java.util.List;

/**
 * Created by volodymyr on 17.09.15.
 */
@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Customer_order",
            joinColumns = {@JoinColumn(name= "Order_id")},
            inverseJoinColumns = {@JoinColumn(name = "Product_id")})
    List<Product> products;

    public Order(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
