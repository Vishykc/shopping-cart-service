package com.viktorvranar.shoppingcartservice.service;

import com.viktorvranar.shoppingcartservice.model.Cart;
import com.viktorvranar.shoppingcartservice.model.CartItem;
import com.viktorvranar.shoppingcartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ShoppingCartService {

    private final CartRepository cartRepository;
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartService.class);

    @Autowired
    public ShoppingCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCart(Long customerId) {

        try {
            return cartRepository.findByCustomerId(customerId);

        } catch (Exception e) {
            logger.error("An error occurred while retrieving cart for customer with ID: {}", customerId, e);
            throw e;
        }
    }

    public Cart addItemToCart(Long customerId, CartItem newItem) {

        try {
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

        } catch (Exception e) {
            logger.error("An error occurred while adding item to cart for customer with ID: {}", customerId, e);
            throw e;
        }
    }

    public Cart removeItemFromCart(Long customerId, Long itemId) {

        try {
            Cart existingCart = cartRepository.findByCustomerId(customerId);

            if (existingCart != null) {
                existingCart.getItems().removeIf(item -> item.getId().equals(itemId));

                return cartRepository.save(existingCart);
            }

            logger.warn("Cart not found for customer with ID: {}", customerId);

            return null;

        } catch (Exception e) {
            logger.error("An error occurred while removing item from cart for customer with ID: {}", customerId, e);

            throw e;
        }
    }

    public Integer evictCart(Long customerId) {

        try {
            Cart existingCart = cartRepository.findByCustomerId(customerId);

            if (existingCart != null) {
                cartRepository.delete(existingCart);
                return 0;
            }

            logger.warn("Cart not found for customer with ID: {}", customerId);

            return null;

        } catch (Exception e) {
            logger.error("An error occurred while evicting cart for customer with ID: {}", customerId, e);

            throw e;
        }
    }
}