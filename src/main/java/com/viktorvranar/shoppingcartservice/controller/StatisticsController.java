package com.viktorvranar.shoppingcartservice.controller;

import com.viktorvranar.shoppingcartservice.model.ActionType;
import com.viktorvranar.shoppingcartservice.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class StatisticsController {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public ResponseEntity<Integer> getStatistics(
            @RequestParam Long offerId,
            @RequestParam ActionType actionType,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        try {
            int statistics = statisticsService.calculateStatistics(offerId, actionType, startDate, endDate);

            return new ResponseEntity<>(statistics, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error occurred while fetching statistics: {}", e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
