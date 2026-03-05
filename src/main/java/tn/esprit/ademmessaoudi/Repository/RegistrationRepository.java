package tn.esprit.ademmessaoudi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ademmessaoudi.entities.Registration;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}