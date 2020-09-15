package com.kodluyoruz.subscription.configs;

import com.kodluyoruz.subscription.contracts.response.SubscriptionResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MockDBConfig {

    List<SubscriptionResponse> db = new ArrayList<>();

    @Bean
    List<SubscriptionResponse> configMockDB(){
        return db;
    }
}
