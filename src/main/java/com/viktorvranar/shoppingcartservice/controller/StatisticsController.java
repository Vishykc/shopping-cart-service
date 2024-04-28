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

@RestController
public class StatisticsController {

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

        int statistics = statisticsService.calculateStatistics(offerId, actionType, startDate, endDate);

        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}
