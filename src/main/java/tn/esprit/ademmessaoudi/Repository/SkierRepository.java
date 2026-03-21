package tn.esprit.ademmessaoudi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ademmessaoudi.Enum.TypeSubscription;
import tn.esprit.ademmessaoudi.entities.Skier;

import java.util.List;

@Repository
public interface SkierRepository extends JpaRepository<Skier, Long> {
    List<Skier> findBySubscriptionTypeSub(TypeSubscription typeSub);
}