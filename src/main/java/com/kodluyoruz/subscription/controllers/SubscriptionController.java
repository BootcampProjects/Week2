package com.kodluyoruz.subscription.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @GetMapping
    public ResponseEntity getSubscriptions(){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity createSubscription() {
        URI location = URI.create(String.format("/carts/%s/items/%s", "123-12132-121312"));
        return ResponseEntity.created(location).build();
    }

    @PatchMapping
    public ResponseEntity changeSunscription() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getSubscription(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubscription(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }





}
