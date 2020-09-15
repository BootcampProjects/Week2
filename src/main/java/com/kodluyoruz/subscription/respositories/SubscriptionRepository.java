package com.kodluyoruz.subscription.respositories;

import com.kodluyoruz.subscription.contracts.requests.SubscriptionRequest;
import com.kodluyoruz.subscription.contracts.requests.SubscriptionUpdateRequest;
import com.kodluyoruz.subscription.contracts.response.SubscriptionResponse;

import java.util.List;


public interface SubscriptionRepository {

    List<SubscriptionResponse> getSubscriptionsByUserId(String userId);

    List<SubscriptionResponse> getSubscriptionAll();

    String createSubscription(SubscriptionRequest request);

    void changeSubscription(SubscriptionUpdateRequest request);

    void deleteSubscription(String id);

    SubscriptionResponse getSubscription(String id);

}
