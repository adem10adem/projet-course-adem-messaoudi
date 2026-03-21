package tn.esprit.ademmessaoudi.services.interfaces;

import tn.esprit.ademmessaoudi.entities.Registration;

import java.util.List;


public interface IRegistrationServices {

    List<Registration> retrieveAllRegistrations();

    Registration addRegistration(Registration registration);

    Registration updateRegistration(Registration registration);

    Registration retrieveRegistration(Long idRegistration);

    void deleteRegistration(Long idRegistration);

    Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur);

    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);

    Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse);

}