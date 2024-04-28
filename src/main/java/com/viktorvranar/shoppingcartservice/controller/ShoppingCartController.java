package com.viktorvranar.shoppingcartservice.controller;

import com.viktorvranar.shoppingcartservice.model.Cart;
import com.viktorvranar.shoppingcartservice.model.CartItem;
import com.viktorvranar.shoppingcartservice.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long customerId) {
        Cart cart = shoppingCartService.getCart(customerId);

        if (cart != null) {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Long customerId, @RequestBody CartItem newItem) {
        Cart updatedCart = shoppingCartService.addItemToCart(customerId, newItem);

        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}/item/{itemId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long customerId, @PathVariable Long itemId) {
        Cart updatedCart = shoppingCartService.removeItemFromCart(customerId, itemId);

        if (updatedCart != null) {
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> evictCart(@PathVariable Long customerId) {
        Integer flag = shoppingCartService.evictCart(customerId);

        if (flag != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

