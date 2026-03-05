package tn.esprit.ademmessaoudi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ademmessaoudi.entities.Piste;
@Repository
public interface PisteRepository extends JpaRepository<Piste, Long> {
}

