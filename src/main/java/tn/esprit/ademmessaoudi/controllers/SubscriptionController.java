package tn.esprit.ademmessaoudi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ademmessaoudi.Enum.TypeSubscription;
import tn.esprit.ademmessaoudi.entities.Subscription;
import tn.esprit.ademmessaoudi.services.interfaces.ISubscriptionServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    public Subscription updateSubscription(@RequestBody Subscription subscription){
        return subscriptionServices.updateSubscription(subscription);
    }
    @GetMapping("/retrieve/{numSub}")
    public Subscription retrieveSubscription(@PathVariable("numSub") Long numSub){
        return subscriptionServices.retrieveSubscription(numSub);
    }
    @DeleteMapping("/remove/{numSub}")
    public void removeSubscription(@PathVariable("numSub") Long numSub){
        subscriptionServices.deleteSubscription(numSub);
    }
    @GetMapping("/retrieve-all")
    public List<Subscription> retrieveAllSubscriptions(){
        return subscriptionServices.retrieveAllSubscriptions();
    }

@GetMapping("/getSubscriptionByType/{type}")
public Set<Subscription> getSubscriptionByType(@PathVariable("type") TypeSubscription type){
        return subscriptionServices.getSubscriptionByType(type);
}

@GetMapping("/retrieveSubscriptionsByDates/{startDate}/{endDate}")
    public List<Subscription> retrieveSubscriptionsByDates(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate){
        return subscriptionServices.retrieveSubscriptionsByDates(startDate,endDate);
    }
}