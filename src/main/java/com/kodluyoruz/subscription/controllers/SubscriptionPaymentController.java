package com.kodluyoruz.subscription.controllers;

import com.kodluyoruz.subscription.contracts.requests.SubscriptionPaymentRequest;
import com.kodluyoruz.subscription.exceptions.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions/{id}/pay")
public class SubscriptionPaymentController {

    @Autowired
    SubscriptionPaymentController subscriptionPaymentController;
    @PostMapping
    public ResponseEntity paySubscription(@RequestBody SubscriptionPaymentRequest subscriptionPaymentRequest, @PathVariable String id) {
        try{
            return ResponseEntity.noContent().build();
        }catch (Exception e)
        {
            throw new InternalServerErrorException("Internal Server Error!");
        }
    }
}
