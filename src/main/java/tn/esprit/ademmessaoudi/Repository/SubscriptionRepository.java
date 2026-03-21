package tn.esprit.ademmessaoudi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ademmessaoudi.Enum.TypeSubscription;
import tn.esprit.ademmessaoudi.entities.Subscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Set<Subscription> findByTypeSubOrderByStartDateAsc(TypeSubscription typeSub);
    List<Subscription> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

}
