package tn.esprit.ademmessaoudi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ademmessaoudi.entities.Registration;
import tn.esprit.ademmessaoudi.services.implementations.RegistrationServicesImpl;
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
    public Registration updateRegistration(@RequestBody Registration registration){
        return registrationServices.updateRegistration(registration);
    }
    @GetMapping("/retrieve/{numRegistration}")
    public Registration retrieveRegistration(@PathVariable("numRegistration") Long numRegistration){
        return registrationServices.retrieveRegistration(numRegistration);
    }
    @DeleteMapping("/remove/{numRegistration}")
    public void removeRegistration(@PathVariable("numRegistration") Long numRegistration){
        registrationServices.deleteRegistration(numRegistration);
    }
    @GetMapping("/retrieve-all")
    public List<Registration> retrieveAllRegistrations(){
        return registrationServices.retrieveAllRegistrations();
    }

    @PutMapping("/assignRegistrationToCourse/{numCourse}/{numRegistration}")
    public Registration assignRegistrationToCourse(@PathVariable("numRegistration") Long numRegistration,
                                                   @PathVariable("numCourse") Long numCourse){
       Registration reg = registrationServices.assignRegistrationToCourse(numRegistration,numCourse);
       return reg;
    }

@PostMapping("/addRegistrationAndAssignToSkierAndCourse/{numSkier}/{numCourse}")
@ResponseBody
public Registration addRegistrationAndAssignToSkierAndCourse(@RequestBody Registration registration,@PathVariable("numSkier") Long numSkier, @PathVariable("numCourse") Long numCourse){


        Registration regist = registrationServices.addRegistrationAndAssignToSkierAndCourse(registration,numSkier,numCourse);
return regist;
    }

    @PostMapping("/addRegistrationAndAssignToSkier/{numSkieur}")
    @ResponseBody
    public Registration addRegistrationAndAssignToSkier(@RequestBody Registration registration, @PathVariable("numSkieur") Long numSkieur){
        Registration registration1 = registrationServices.addRegistrationAndAssignToSkier(registration,numSkieur);
        return registration1;
    }
}

