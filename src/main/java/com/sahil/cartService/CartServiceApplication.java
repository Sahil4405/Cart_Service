package com.sahil.cartService;

import com.sahil.cartService.daos.CartDao;
import com.sahil.cartService.daos.ItemDao;
import com.sahil.cartService.entities.Cart;
import com.sahil.cartService.entities.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class CartServiceApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(CartServiceApplication.class, args);

		//This will help in fetching the CartDao bean from spring container
		CartDao cartDao = applicationContext.getBean(CartDao.class);
		ItemDao itemDao = applicationContext.getBean(ItemDao.class);

		System.out.println("Cart Dao " + cartDao);
		System.out.println("Item Dao " + itemDao);

		/**
		 * Create Cart
		 */
		Cart cart = new Cart();
		cart.setCustomerName("Vishwa Mohan");
		cartDao.save(cart);

		Item item = new Item();
		item.setItemName("Detergent Podwer");
		item.setCategory("HouseHold");
		item.setItemDescription("Great Product");
		item.setCost(400);
		item.setMfgDate(LocalDateTime.of(2021,07,30,12,40));
		item.setCart(cart);
		itemDao.save(item);

		System.out.println("Hello World!!");
	}

}
