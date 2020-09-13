package com.kodluyoruz.subscription.services;

import com.kodluyoruz.subscription.contracts.response.SubscriptionResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class SubscriptionsService {

    public SubscriptionResponse getSubscription(String id) {
        return SubscriptionResponse.builder().id(id).planId("1").price(12.0)
                .isPaid(false).startDate(LocalDate.now()).endDate(LocalDate.now()).userId("0").build();
    }

    public ArrayList<SubscriptionResponse> getSubscriptionByUserId(String id) {
        ArrayList<SubscriptionResponse> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(SubscriptionResponse.builder().id("1").planId("2").price(12.0)
                    .isPaid(false).startDate(LocalDate.now()).endDate(LocalDate.now()).userId(id).build());
        }
        return list;
    }

    public ArrayList<SubscriptionResponse> getSubscriptionAll() {
        ArrayList<SubscriptionResponse> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(SubscriptionResponse.builder().id(String.valueOf(i)).planId("1").price(12.0)
                    .isPaid(false).startDate(LocalDate.now()).endDate(LocalDate.now()).userId("0").build());
        }
        return list;
    }
}
