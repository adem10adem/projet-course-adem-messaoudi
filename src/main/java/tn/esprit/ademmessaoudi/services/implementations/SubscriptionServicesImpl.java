package tn.esprit.ademmessaoudi.services.implementations;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ademmessaoudi.Enum.TypeSubscription;
import tn.esprit.ademmessaoudi.Repository.SkierRepository;
import tn.esprit.ademmessaoudi.Repository.SubscriptionRepository;
import tn.esprit.ademmessaoudi.entities.Skier;
import tn.esprit.ademmessaoudi.entities.Subscription;
import tn.esprit.ademmessaoudi.services.interfaces.ISubscriptionServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class SubscriptionServicesImpl implements ISubscriptionServices {

    private final SubscriptionRepository subscriptionRepository;
    private  final SkierRepository skierRepository;

    @Override
    public List<Subscription> retrieveAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription retrieveSubscription(Long idSubscription) {
        return subscriptionRepository.findById(idSubscription).orElse(null);
    }

    @Override
    public void deleteSubscription(Long idSubscription) {
        subscriptionRepository.deleteById(idSubscription);
    }

@Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type){
     Set<Subscription> subscriptions = subscriptionRepository.findByTypeSubOrderByStartDateAsc(type);
return subscriptions;
}
@Override
   public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate){
    List<Subscription> subscriptions = subscriptionRepository.findByStartDateBetween(startDate,endDate);
    return subscriptions;

}
}
