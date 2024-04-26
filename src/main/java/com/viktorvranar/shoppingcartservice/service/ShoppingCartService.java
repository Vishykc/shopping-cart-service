package com.viktorvranar.shoppingcartservice.service;

import com.viktorvranar.shoppingcartservice.model.Cart;
import com.viktorvranar.shoppingcartservice.model.CartItem;
import com.viktorvranar.shoppingcartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    private final CartRepository cartRepository;

    @Autowired
    public ShoppingCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCart(Long customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    public Cart addItemToCart(Long customerId, CartItem newItem) {
        Cart existingCart = cartRepository.findByCustomerId(customerId);

        if (existingCart == null) {
            existingCart = new Cart();
            existingCart.setCustomerId(customerId);

        } else {

            // Check if the item already exists in the cart
            for (CartItem existingItem : existingCart.getItems()) {
                if (newItem.getOfferId().equals(existingItem.getOfferId())) {
                    existingItem.setQuantity(existingItem.getQuantity() + newItem.getQuantity());

                    return cartRepository.save(existingCart);
                }
            }
        }

        // If the item is not found in the existing cart, add it
        existingCart.getItems().add(newItem);

        return cartRepository.save(existingCart);
    }

    public Cart removeItemFromCart(Long customerId, Long itemId) {
        Cart existingCart = cartRepository.findByCustomerId(customerId);

        if (existingCart != null) {
            existingCart.getItems().removeIf(item -> item.getId().equals(itemId));

            return cartRepository.save(existingCart);
        }

        return null;
    }

    public Integer evictCart(Long customerId) {
        Cart existingCart = cartRepository.findByCustomerId(customerId);

        if (existingCart != null) {
            cartRepository.delete(existingCart);

            return 0;
        }

        return null;
    }
}

