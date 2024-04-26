package com.viktorvranar.shoppingcartservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PriceType type;

    @NotNull
    private Double priceValue; // value is a reserved keyword

    @Min(1)
    private Integer recurrence; // number of recurrences (only for recurring price)
}

