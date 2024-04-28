package com.viktorvranar.shoppingcartservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @Min(value = 1, message = "Recurrence must be greater than 0")
    @Column(name = "recurrence")
    private Integer recurrence; // number of recurrences (only for recurring price)

    private static final Logger logger = LoggerFactory.getLogger(Price.class);

    @PrePersist
    @PreUpdate
    private void validatePrice() {

        if (type == PriceType.ONE_TIME) {
            recurrence = null; // Set recurrence to null for one-time prices

        } else if (type == PriceType.RECURRING && recurrence == null) {
            logger.error("Recurrence must be specified for recurring prices");

            throw new IllegalArgumentException("Recurrence must be specified for recurring prices");
        }
    }
}