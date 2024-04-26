package com.viktorvranar.shoppingcartservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(0)
    private Long offerId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    @NotNull
    @Min(0)
    private Integer quantity;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id", referencedColumnName = "id")
    private Price price;
}

