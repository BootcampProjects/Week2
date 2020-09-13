package com.kodluyoruz.subscription.controllers;

import com.kodluyoruz.subscription.contracts.requests.SubscriptionPaymentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions/{id}/pay")
public class SubscriptionPaymentController {

    @PostMapping
    public ResponseEntity paySubscription(@RequestBody SubscriptionPaymentRequest subscriptionPaymentRequest, @PathVariable String id) {
        return ResponseEntity.ok().build();
    }
}
