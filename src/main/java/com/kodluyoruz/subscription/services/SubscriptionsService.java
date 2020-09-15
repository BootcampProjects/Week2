package com.kodluyoruz.subscription.services;

import com.kodluyoruz.subscription.contracts.requests.SubscriptionRequest;
import com.kodluyoruz.subscription.contracts.response.SubscriptionResponse;
import com.kodluyoruz.subscription.respositories.InMemoryMockRepository;
import com.kodluyoruz.subscription.respositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionsService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

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

    public List<SubscriptionResponse> getSubscriptionAll() {
        return subscriptionRepository.getSubscriptionAll();
    }

    public String createSubscription(SubscriptionRequest response){
        return subscriptionRepository.createSubscription(response);
    }
}
