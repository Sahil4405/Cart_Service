package com.sahil.cartService.services;

import com.sahil.cartService.entities.Cart;
import com.sahil.cartService.entities.Item;
import com.sahil.cartService.exceptions.CartNotFoundException;
import com.sahil.cartService.exceptions.ItemNotFoundException;

import java.util.List;

public interface ItemService {

    public Item addItemToCart(Item item, int cartId) throws CartNotFoundException;

    public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException;

    public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException;
}
