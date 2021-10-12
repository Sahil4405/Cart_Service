package com.sahil.cartService.services.impl;

import com.sahil.cartService.daos.ItemDao;
import com.sahil.cartService.entities.Cart;
import com.sahil.cartService.entities.Item;
import com.sahil.cartService.exceptions.CartNotFoundException;
import com.sahil.cartService.exceptions.ItemNotFoundException;
import com.sahil.cartService.services.CartService;
import com.sahil.cartService.services.ItemService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.logging.Logger;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private CartService cartService;

    @Override
    public Item addItemToCart(Item item, int cartId) throws CartNotFoundException {
        LOGGER.debug("Arguments passed items are: " + item + " and cart id: " + cartId);
        LOGGER.info("Getting inside the addItemToCart method");

        //Need to fetch the cart based on the cartId
        Cart cart = cartService.findByCartId(cartId); //fetch based on Cart id
        item.setCart(cart);

        LOGGER.info("Returning from the addItemToCart method");
        return itemDao.save(item);
    }

    /**
     * can we directly fetch from the cart because cart will have all items within it
     *
     * Cart -> Item
     * One to Many
     *
     * which is lazy initialization
     *
     * When we load Cart, cart attributes will be loaded, but items will not loaded
     * @param cartId
     * @return
     * @throws CartNotFoundException
     */

    @Override
    public List<Item> getItemsFromTheCart(int cartId) throws CartNotFoundException {

        Cart cart = cartService.findByCartId(cartId);
//        cart.getItems() -- getItems will return Empty() --->> this is know as lazy initialization

        List<Item> items = itemDao.findItemsByCart(cart);
        return items;
    }

    @Override
    public Cart getCartOfTheItem(int itemId) throws ItemNotFoundException {
        Item item = itemDao.findById(itemId).orElseThrow(() -> new ItemNotFoundException());
        /**
         * Item -> Cart
         * Many to One
         * Eager Initialization
         *
         * Learn about Eager and lazy initialization
         */

        Cart cart = item.getCart();

        return cart;
    }
}
