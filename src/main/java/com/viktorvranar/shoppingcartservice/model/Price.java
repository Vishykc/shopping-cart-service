package com.viktorvranar.shoppingcartservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PriceType type;

    @NotNull
    @Column(name = "price_value")
    private Double priceValue; // value is a reserved keyword

    @Min(1)
    @Column(name = "recurrence")
    private Integer recurrence; // number of recurrences (only for recurring price)
}

