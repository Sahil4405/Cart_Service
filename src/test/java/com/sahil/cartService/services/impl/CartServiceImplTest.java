package com.sahil.cartService.services.impl;

import com.sahil.cartService.daos.CartDao;
import com.sahil.cartService.entities.Cart;
import com.sahil.cartService.exceptions.CartNotFoundException;
import com.sahil.cartService.exceptions.CustomerNameNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
//import org.jutil.Assert; //this is imported for Assert which is same as Assertions, so i used
// Assertions instead this because for jutil I have to add his maven dependency which i currently don't want

import java.util.Optional;

@SpringBootTest
public class CartServiceImplTest {

    @Mock
    CartDao cartDaoMock;

    @InjectMocks
    CartServiceImpl cartService;

    @Test
    public void test(){
        System.out.println("cart dao: " + cartDaoMock);
        System.out.println("Cart service: " + cartService);
    }

    /**
     * Test for createCart
     */
    @Test
    public void testCreateCart(){
        // Create the data
        Cart cart = new Cart();
        cart.setCustomerName("Sahil Singh");

        Cart cart1 = new Cart();
        cart1.setCustomerName("Sahil Singh");
        cart1.setCartId(1);

        //Given the functionality to the mock
        Mockito.when(cartDaoMock.save(cart)).thenReturn(cart1);

        //Execute
        Cart savedCart = cartService.createCart(cart);

        //Testing
        Assertions.assertNotNull(savedCart);
        Assertions.assertEquals(1,savedCart.getCartId());
    }

    /**
     * Test for deleteCart: TODO
     */
    @Test
    public void testDeleteCart(){
        //Data

        //Mockup(this Mockito special) -- When we have to mock a method that returns nothing
//        Mockito.doNothing().when(cartDaoMock).deleteById(1);

        //Execution
//        boolean deleteResult = cartService.deleteCart(1);

        //Assertion
//        Assertions.assertTrue(deleteResult); // To work this function,, we have to add dependency maven of assert
    }

    /**
     * Test for findByCartId
     */
    @Test
    public void testFindByCartId() throws CartNotFoundException {
        //Data
        Cart cart1 = new Cart();
        cart1.setCustomerName("Sahil Singh");
        cart1.setCartId(1);

        //Mockup
        Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.of(cart1)); //Optional of is use when we return optional in serviceImpl method

        //Execution
        Cart cart = cartService.findByCartId(1);

        //Assertion
        Assertions.assertNotNull(cart);
        Assertions.assertEquals("Sahil Singh",cart.getCustomerName());
    }

    @Test
    public void testFindByCartIdThrowsException() throws CartNotFoundException {
        //Data
        Cart cart1 = new Cart();
        cart1.setCustomerName("Sahil Singh");
        cart1.setCartId(1);

        //Mockup
        Mockito.when(cartDaoMock.findById(1)).thenReturn(Optional.empty());

        //Execute
        try{
            Cart cart = cartService.findByCartId(1);
        }catch(Exception e){
            Assertions.assertEquals(CartNotFoundException.class, e.getClass());
        }

    }

    /**
     * Test for findByCustomerName
     */
    @Test
    public void testFindByCustomerName() throws CustomerNameNotFoundException {
        //Data
        Cart cart1 = new Cart();
        cart1.setCustomerName("Sahil Singh");
        cart1.setCartId(1);

        //Mockup
        Mockito.when(cartDaoMock.findByCustomerName("Sahil Singh")).thenReturn(cart1);

        //Execution
        Cart cart = cartService.findByCustomerName("Sahil Singh");

        //Assertion
        Assertions.assertNotNull(cart);
        Assertions.assertEquals("Sahil Singh", cart.getCustomerName());
    }

}

















