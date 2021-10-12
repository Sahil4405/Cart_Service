package com.sahil.cartService.daos;

import com.sahil.cartService.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart, Integer> {

    public Cart findByCustomerName(String name);
}
