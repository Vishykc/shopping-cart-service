package com.viktorvranar.shoppingcartservice.service;

import com.viktorvranar.shoppingcartservice.model.ActionType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import com.viktorvranar.shoppingcartservice.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class StatisticsService {

    private final EntityManager entityManager;

    @Autowired
    public StatisticsService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public int calculateStatistics(Long offerId, ActionType actionType, LocalDate startDate, LocalDate endDate) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        var cartItemRoot = query.from(CartItem.class);

        Predicate offerIdPredicate = criteriaBuilder.equal(cartItemRoot.get("offerId"), offerId);
        Predicate actionTypePredicate = criteriaBuilder.equal(cartItemRoot.get("action"), actionType);
        Predicate dateRangePredicate = criteriaBuilder.between
                (cartItemRoot.get("createdAt"), startDate.atStartOfDay(), endDate.atStartOfDay());

        query.select(criteriaBuilder.count(cartItemRoot));
        query.where(offerIdPredicate, actionTypePredicate, dateRangePredicate);

        var typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult().intValue();
    }
}
