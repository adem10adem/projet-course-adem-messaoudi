package tn.esprit.ademmessaoudi.services.interfaces;

import tn.esprit.ademmessaoudi.entities.Subscription;

import java.util.List;

public interface ISubscriptionServices {

    List<Subscription> retrieveAllSubscriptions();

    Subscription addSubscription(Subscription subscription);

    Subscription updateSubscription(Subscription subscription);

    Subscription retrieveSubscription(Long numSub);

    void deleteSubscription(Long numSub);
}

