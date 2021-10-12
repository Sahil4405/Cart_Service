package com.sahil.cartService.daos;

import com.sahil.cartService.entities.Cart;
import com.sahil.cartService.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * This will be used to do the CRUD operation with the dataBase
 */
public interface ItemDao extends JpaRepository<Item, Integer> {

    public List<Item> findItemsByCart(Cart cart);
}
