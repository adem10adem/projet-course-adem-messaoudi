package tn.esprit.ademmessaoudi.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ademmessaoudi.Enum.TypeCourse;
import tn.esprit.ademmessaoudi.Repository.CourseRepository;
import tn.esprit.ademmessaoudi.Repository.RegistrationRepository;

import tn.esprit.ademmessaoudi.Repository.SkierRepository;
import tn.esprit.ademmessaoudi.entities.Course;
import tn.esprit.ademmessaoudi.entities.Registration;

import tn.esprit.ademmessaoudi.entities.Skier;
import tn.esprit.ademmessaoudi.services.interfaces.IRegistrationServices;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@AllArgsConstructor
@Service
public class RegistrationServicesImpl implements IRegistrationServices {

    private final RegistrationRepository registrationRepository;
    private final CourseRepository courseRepository;
    private final SkierRepository skierRepository;


    @Override
    public List<Registration> retrieveAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration retrieveRegistration(Long idRegistration) {
        return registrationRepository.findById(idRegistration).orElse(null);
    }

    @Override
    public void deleteRegistration(Long idRegistration) {
        registrationRepository.deleteById(idRegistration);
    }

@Override
public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur){
        Skier skier= skierRepository.findById(numSkieur).get();
        registration.setSkier(skier);
    registrationRepository.save(registration);
        return registration;

}


@Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
    Registration reg = registrationRepository.findById(numRegistration).get();
    Course course = courseRepository.findById(numCourse).get();
    reg.setCourse(course);
    registrationRepository.save(reg);
    return reg;
}
@Override
  public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse){
    Skier skier = skierRepository.findById(numSkier).get();
    Course course = courseRepository.findById(numCourse).get();

    if (course.getRegistrations().size() >= 6 &&
            (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILD ||
                    course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT)) {

        throw new RuntimeException("Course is full (max 6 skiers)");
    }

    int age = Period.between(skier.getDateOfBirth(), LocalDate.now()).getYears();

    if (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILD && age > 12) {
        throw new RuntimeException("This course is only for children");
    }

    if (course.getTypeCourse() == TypeCourse.COLLECTIVE_ADULT && age < 12) {
        throw new RuntimeException("This course is only for adults");
    }


    registration.setCourse(course);
    registration.setSkier(skier);
    registrationRepository.save(registration);
    return registration;


}
}

