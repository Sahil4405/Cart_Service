package com.sahil.cartService.services.impl;

import com.sahil.cartService.daos.CartDao;
import com.sahil.cartService.entities.Cart;
import com.sahil.cartService.exceptions.CartNotFoundException;
import com.sahil.cartService.exceptions.CustomerNameNotFoundException;
import com.sahil.cartService.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart createCart(Cart cart) {
        return cartDao.save(cart);
    }

    @Override
    public boolean deleteCart(int cartId) {
        cartDao.deleteById(cartId);
        return false;
    }

    @Override
    public Cart findByCartId(int cartId) throws CartNotFoundException {
        return cartDao.findById(cartId).orElseThrow(() -> new CartNotFoundException());
    }

    @Override
    public Cart findByCustomerName(String customerName) throws CustomerNameNotFoundException {
        Cart cart = cartDao.findByCustomerName(customerName);
        if(cart == null)
            throw new CustomerNameNotFoundException();
        return cart;
    }
}
