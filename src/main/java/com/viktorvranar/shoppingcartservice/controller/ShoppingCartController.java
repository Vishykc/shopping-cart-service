package com.viktorvranar.shoppingcartservice.controller;

import com.viktorvranar.shoppingcartservice.model.Cart;
import com.viktorvranar.shoppingcartservice.model.CartItem;
import com.viktorvranar.shoppingcartservice.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long customerId) {

        try {
            Cart cart = shoppingCartService.getCart(customerId);

            if (cart != null) {
                return new ResponseEntity<>(cart, HttpStatus.OK);

            } else {
                logger.warn("Cart not found for customer with ID: {}", customerId);

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            logger.error("An error occurred while retrieving cart for customer with ID: {}", customerId, e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Long customerId, @RequestBody CartItem newItem) {

        try {
            Cart updatedCart = shoppingCartService.addItemToCart(customerId, newItem);

            return new ResponseEntity<>(updatedCart, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("An error occurred while adding item to cart for customer with ID: {}", customerId, e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{customerId}/item/{itemId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long customerId, @PathVariable Long itemId) {

        try {
            Cart updatedCart = shoppingCartService.removeItemFromCart(customerId, itemId);

            if (updatedCart != null) {

                return new ResponseEntity<>(updatedCart, HttpStatus.OK);

            } else {
                logger.warn("Item with ID {} not found in cart for customer with ID: {}", itemId, customerId);

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            logger.error("An error occurred while removing item from cart for customer with ID: {}", customerId, e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> evictCart(@PathVariable Long customerId) {

        try {
            Integer flag = shoppingCartService.evictCart(customerId);

            if (flag != null) {

                return new ResponseEntity<>(HttpStatus.OK);

            } else {
                logger.warn("Cart not found for customer with ID: {}", customerId);

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            logger.error("An error occurred while evicting cart for customer with ID: {}", customerId, e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}