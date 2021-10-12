package com.sahil.cartService.controllers;

import com.sahil.cartService.daos.CartDao;
import com.sahil.cartService.daos.ItemDao;
import com.sahil.cartService.dtos.CartDTO;
import com.sahil.cartService.dtos.ItemDTO;
import com.sahil.cartService.entities.Cart;
import com.sahil.cartService.entities.Item;
import com.sahil.cartService.exceptions.CartNotFoundException;
import com.sahil.cartService.exceptions.ItemNotFoundException;
import com.sahil.cartService.services.CartService;
import com.sahil.cartService.services.ItemService;
import com.sahil.cartService.utils.DTOEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * POST - 127.0.0.1:8080:cartService/V1/carts
 * Get - 127.0.0.1:8080:cartService/V1/carts/{cart_id}
 *
 * Create the items
 * Post - 127.0.0.1:8080:cartService/V1/carts/{cart_id}/items
 * This is nested REST URI
 */
@RestController
/**
 * 127.0.0.1:8081/cartService/v1/carts
 */
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity helloStudents(){
        return new ResponseEntity("Hello Friends", HttpStatus.OK);
    }

    /**
     * create an endpoint to create the cart
     *
     * POST: 127.0.0.1:8081/cartService/v1/carts
     *
     *  Body request -- JSON
     *  we will is @RequestBody annotation to convert it
     */
    @PostMapping
    public ResponseEntity createCart(@RequestBody CartDTO cartDTO){

        // Create and save Cart in the System
        Cart cart = cartService.createCart(DTOEntityMapper.convertCartDTOtoCartEntity(cartDTO));

        // Convert the Cart entity back to the CartDTO
        CartDTO cartResponse = DTOEntityMapper.convertCartEntityToCartDTO(cart);

        return new ResponseEntity(cartResponse, HttpStatus.CREATED);
    }

    /**
     * Search a Cart based on CartId
     *
     * GET 127.0.0.1:8081/cartService/v1/carts/{cart_id}
     */
    @GetMapping("/{cart_id}")
    public ResponseEntity getCart(@PathVariable("cart_id") int cartId) throws CartNotFoundException {
        Cart cart = cartService.findByCartId(cartId);

        CartDTO cartResponse = DTOEntityMapper.convertCartEntityToCartDTO(cart);

        return new ResponseEntity(cartResponse, HttpStatus.OK);
    }


    /**
     * Add an item in the Cart
     */
//    @PostMapping("/{card_id}/items")
//    public ResponseEntity addItemToCart(@RequestBody ItemDTO itemDTO, @PathVariable("cart_id") int cartId) throws CartNotFoundException, ItemNotFoundException {
//
//        // I need to create item inside the cart... so need ItemService
//        Item item = itemService.addItemToCart(DTOEntityMapper.convertItemDTOToItemEntity(itemDTO), cartId);
//        Cart cart = itemService.getCartOfTheItem(item.getItemId());
//        CartDTO cartDTO = DTOEntityMapper.convertCartEntityToCartDTO(cart);
//
//
//        return new ResponseEntity(cartDTO,HttpStatus.CREATED);
//    }

    @PostMapping("/{cart_id}/items")
    public ResponseEntity addItemToCart(@RequestBody ItemDTO itemDTO, @PathVariable("cart_id") int cartId)
            throws CartNotFoundException, ItemNotFoundException {

        // I need to create item inside the cart.. so need ItemService
        Item item = itemService.addItemToCart(DTOEntityMapper.convertItemDTOToItemEntity(itemDTO), cartId);
        Cart cart = itemService.getCartOfTheItem(item.getItemId());
        CartDTO cartDTO = DTOEntityMapper.convertCartEntityToCartDTO(cart);

        return new ResponseEntity(cartDTO, HttpStatus.CREATED);
    }

}




























