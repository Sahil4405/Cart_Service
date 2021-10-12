package com.sahil.cartService.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Use this class to create table in the database
 */
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;

    @Column(nullable = false, unique = true)
    private String customerName;

    @OneToMany(mappedBy = "cart")
    private List<Item> items ;

    public Cart() {
        items = new ArrayList<>();
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Cart(int cartId, String customerName, List<Item> items) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.items = items;
    }
}
