package com.kodluyoruz.subscription.contracts.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class SubscriptionResponse {
    private String id;
    private String userId;
    private String planId;
    private double price;
    private boolean isPaid;
    private LocalDate startDate;
    private LocalDate endDate;
}
