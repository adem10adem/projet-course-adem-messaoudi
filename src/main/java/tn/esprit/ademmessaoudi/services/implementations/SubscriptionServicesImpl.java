package tn.esprit.ademmessaoudi.services.implementations;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ademmessaoudi.Repository.SubscriptionRepository;
import tn.esprit.ademmessaoudi.entities.Subscription;
import tn.esprit.ademmessaoudi.services.interfaces.ISubscriptionServices;

import java.util.List;

@AllArgsConstructor
@Service
public class SubscriptionServicesImpl implements ISubscriptionServices {

    private final SubscriptionRepository subscriptionRepository;

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
}
