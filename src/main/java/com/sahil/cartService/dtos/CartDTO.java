package com.sahil.cartService.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sahil.cartService.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
    @JsonProperty("cart_id")
    private int cartId;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("cart_items")
    private List<ItemDTO> items;

    public CartDTO(int cartId, String customerName, List<ItemDTO> items) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.items = items;
    }

    public CartDTO(){
        this.items = new ArrayList<>();
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

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}
