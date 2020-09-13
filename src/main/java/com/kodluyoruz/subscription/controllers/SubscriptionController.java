package com.kodluyoruz.subscription.controllers;

import com.kodluyoruz.subscription.contracts.requests.SubscriptionRequest;
import com.kodluyoruz.subscription.contracts.requests.SubscriptionUpdateRequest;
import com.kodluyoruz.subscription.contracts.response.SubscriptionResponse;
import com.kodluyoruz.subscription.services.SubscriptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    SubscriptionsService subscriptionsService;

    @GetMapping
    public ResponseEntity getSubscriptions(@RequestParam(required = false) String userId, @RequestParam(required = false) String paymentId) {
        if (Objects.nonNull(userId) && Objects.nonNull(paymentId)) {
            return ResponseEntity.ok(String.format("user id -> %s -- payment id -> %s", userId, paymentId));
        } else if (Objects.nonNull(userId)) {
            return ResponseEntity.ok(String.format("user id -> %s", userId));
        } else if (Objects.nonNull(paymentId)) {
            return ResponseEntity.ok(String.format("payment id -> %s", paymentId));
        } else {
            return ResponseEntity.ok("All Subscription");
        }
    }

    @PostMapping
    public ResponseEntity createSubscription(@RequestBody SubscriptionRequest subscription) {
        URI location = URI.create(String.format("/subscriptions/%s/items/%s", "123-12132-121312"));
        return ResponseEntity.created(location).build();
    }

    @PatchMapping
    public ResponseEntity changeSubscription(@RequestParam SubscriptionUpdateRequest subscriptionUpdateRequest) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionResponse> getSubscription(@PathVariable String id) {
        return ResponseEntity.ok(SubscriptionResponse.builder().id("1").build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubscription(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }

}
