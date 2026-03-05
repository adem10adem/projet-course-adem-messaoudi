package tn.esprit.ademmessaoudi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ademmessaoudi.entities.Instructor;
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}