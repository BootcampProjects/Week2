package com.kodluyoruz.subscription.contracts.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubscriptionPaymentRequest {
    private String userId;
    private String cardOwnerName;
    private String cardNumber;
    private String validThruMonth;
    private String validThruYear;
    private String cvc;

}
