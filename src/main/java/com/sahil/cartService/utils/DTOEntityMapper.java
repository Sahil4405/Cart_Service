package com.sahil.cartService.utils;

import com.sahil.cartService.dtos.CartDTO;
import com.sahil.cartService.dtos.ItemDTO;
import com.sahil.cartService.entities.Cart;
import com.sahil.cartService.entities.Item;

/**
 * In this project I have not use Modelmapper, instead of it i made this class for converting DTO to Entity
 * and vice-versa,, for both Cart and Item
 */

public class DTOEntityMapper {

    /**
     * For mapping CartDTO from Cart Entity
     * @param cartDTO
     * @return
     */
    public static Cart convertCartDTOtoCartEntity(CartDTO cartDTO){
        Cart cart = new Cart();
        cart.setCartId(cartDTO.getCartId());
        cart.setCustomerName(cartDTO.getCustomerName());
        for (ItemDTO itemDTO: cartDTO.getItems()){
            cart.getItems().add(convertItemDTOToItemEntity(itemDTO));
        }

        return cart;
    }

    public static Item convertItemDTOToItemEntity(ItemDTO itemDTO) {
        Item item = new Item();

        item.setItemName(itemDTO.getItemName());
        item.setItemDescription(itemDTO.getItemDescription());
        item.setCost(itemDTO.getCost());
        item.setCategory(itemDTO.getCategory());
        item.setMfgDate(itemDTO.getMfgDate());
        item.setItemId(itemDTO.getItemId());

        return item;
    }


    public static CartDTO convertCartEntityToCartDTO(Cart cart){

        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        cartDTO.setCustomerName(cart.getCustomerName());
        for (Item item: cart.getItems()){
            cartDTO.getItems().add(convertItemEntityToItemDTO(item));
        }

        return cartDTO;
    }

    public static ItemDTO convertItemEntityToItemDTO(Item item) {

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setItemName(item.getItemName());
        itemDTO.setItemDescription(item.getItemDescription());
        itemDTO.setCost(item.getCost());
        itemDTO.setCategory(item.getCategory());
        itemDTO.setMfgDate(item.getMfgDate());
        itemDTO.setItemId(item.getItemId());

        return itemDTO;
    }
}











