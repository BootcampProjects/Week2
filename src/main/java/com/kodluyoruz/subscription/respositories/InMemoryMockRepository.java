package com.kodluyoruz.subscription.respositories;

import com.kodluyoruz.subscription.configs.MockDBConfig;
import com.kodluyoruz.subscription.contracts.requests.SubscriptionRequest;
import com.kodluyoruz.subscription.contracts.requests.SubscriptionUpdateRequest;
import com.kodluyoruz.subscription.contracts.response.SubscriptionResponse;
import com.kodluyoruz.subscription.exceptions.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.ObjectInputFilter;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Flow;

@Repository
public class InMemoryMockRepository implements SubscriptionRepository{

    List<SubscriptionResponse> db;
    InMemoryMockRepository(@Qualifier("configMockDB") List<SubscriptionResponse> db){
        this.db = db;
    }

    @Override
    public List<SubscriptionResponse> getSubscriptionsByUserId(String userId) {
        return null;
    }

    @Override
    public List<SubscriptionResponse> getSubscriptionAll() {
        return this.db;
    }

    @Override
    public String createSubscription(SubscriptionRequest request) {
        try {
            SubscriptionResponse response = SubscriptionResponse.builder().id(String.valueOf(db.size() + 1))
                    .endDate(LocalDate.now()).startDate(LocalDate.now()).isPaid(false).planId(request.getPlanId())
                    .userId(request.getUserId()).price(10).build();

            this.db.add(response);
            return response.getId();
        }catch (Exception e)
        {
            throw new InternalServerErrorException("Internal Server Error!");
        }
    }

    @Override
    public void changeSubscription(SubscriptionUpdateRequest request) {

    }

    @Override
    public void deleteSubscription(String id) {

    }

    @Override
    public SubscriptionResponse getSubscription(String id) {
        return null;
    }
}
