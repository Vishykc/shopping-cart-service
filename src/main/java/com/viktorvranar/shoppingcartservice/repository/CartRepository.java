package com.viktorvranar.shoppingcartservice.repository;

import com.viktorvranar.shoppingcartservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByCustomerId(Long customerId);
}

