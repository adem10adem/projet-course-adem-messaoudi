package tn.esprit.ademmessaoudi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ademmessaoudi.entities.Registration;
import tn.esprit.ademmessaoudi.services.interfaces.IRegistrationServices;

import java.util.List;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor


public class RegistrationController {

    private final IRegistrationServices registrationServices;

    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration){
        return registrationServices.addRegistration(registration);
    }

    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationServices.updateRegistration(registration);
    }

    @GetMapping("/retrieve/{numRegistration}")
    public Registration retrieveRegistration(@PathVariable("numRegistration") Long numRegistration) {
        return registrationServices.retrieveRegistration (numRegistration);
    }

    @DeleteMapping("/remove/{numRegistration}")
    public void deleteRegistration(@PathVariable("numRegistration") Long numRegistration) {
        registrationServices.deleteRegistration(numRegistration);
    }

    @GetMapping("/retrieve-all")
    public List<Registration> retrieveAllRegistrations() {
        return registrationServices.retrieveAllRegistrations();
    }



}

