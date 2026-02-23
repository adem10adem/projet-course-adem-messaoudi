package tn.esprit.ademmessaoudi.services.implementations;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ademmessaoudi.Repository.RegistrationRepository;
import tn.esprit.ademmessaoudi.entities.Registration;
import tn.esprit.ademmessaoudi.services.interfaces.IRegistrationServices;

import java.util.List;

@AllArgsConstructor
@Service
public class RegistrationServicesImpl implements IRegistrationServices {

    private final RegistrationRepository registrationRepository;

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
}

