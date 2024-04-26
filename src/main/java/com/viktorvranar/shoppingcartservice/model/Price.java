package com.viktorvranar.shoppingcartservice.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PriceType type;

    private double priceValue; // value is a reserved keyword

    private int recurrence; // number of recurrences (only for recurring price)
}

