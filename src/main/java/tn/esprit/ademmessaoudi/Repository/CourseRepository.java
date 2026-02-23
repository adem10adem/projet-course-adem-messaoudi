package tn.esprit.ademmessaoudi.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ademmessaoudi.entities.Course;
@Repository

public interface CourseRepository extends JpaRepository<Course, Long> {
}