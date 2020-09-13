package com.kodluyoruz.subscription.contracts.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubscriptionRequest {
    private String userId;
    private String planId;
}
