package tn.esprit.ademmessaoudi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



import tn.esprit.ademmessaoudi.entities.Subscription;

import tn.esprit.ademmessaoudi.services.interfaces.ISubscriptionServices;

import java.util.List;

@RestController
@RequestMapping("/subscription")
@AllArgsConstructor


public class SubscriptionController {

    private final ISubscriptionServices subscriptionServices;

    @PostMapping("/add")
    public Subscription addSubscription(@RequestBody Subscription subscription){
        return subscriptionServices.addSubscription(subscription);
    }

    @PutMapping("/update")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionServices.updateSubscription(subscription);
    }

    @GetMapping("/retrieve/{numSub}")
    public Subscription retrieveSubscription(@PathVariable("numSub") Long numSub) {
        return subscriptionServices.retrieveSubscription (numSub);
    }

    @DeleteMapping("/remove/{numSub}")
    public void deleteSubscription(@PathVariable("numSub") Long numSub) {
        subscriptionServices.deleteSubscription(numSub);
    }

    @GetMapping("/retrieve-all")
    public List<Subscription> retrieveAllSubscriptions() {
        return subscriptionServices.retrieveAllSubscriptions();
    }



}

