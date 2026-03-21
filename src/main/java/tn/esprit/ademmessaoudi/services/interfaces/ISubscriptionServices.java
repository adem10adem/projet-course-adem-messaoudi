package tn.esprit.ademmessaoudi.services.interfaces;

import tn.esprit.ademmessaoudi.Enum.TypeSubscription;
import tn.esprit.ademmessaoudi.entities.Subscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public interface ISubscriptionServices {

    List<Subscription> retrieveAllSubscriptions();
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    Subscription retrieveSubscription(Long idSubscription);
    void deleteSubscription(Long idSubscription);
    Set<Subscription> getSubscriptionByType(TypeSubscription type);
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);

}
