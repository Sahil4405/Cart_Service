package com.sahil.cartService.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(length = 512)
    private String itemDescription;

    private String category;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private LocalDateTime mfgDate;

    /**
     * For the relationship
     */
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public LocalDateTime getMfgDate(){
        return mfgDate;
    }

    public void setMfgDate(LocalDateTime mfgDate){
        this.mfgDate = mfgDate;
    }

    public Cart getCart(){
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}














