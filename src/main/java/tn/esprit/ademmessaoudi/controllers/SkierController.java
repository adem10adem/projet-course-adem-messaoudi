package tn.esprit.ademmessaoudi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ademmessaoudi.Enum.TypeSubscription;
import tn.esprit.ademmessaoudi.entities.Registration;
import tn.esprit.ademmessaoudi.entities.Skier;
import tn.esprit.ademmessaoudi.services.interfaces.ISkierServices;

import java.util.List;

@RestController
@RequestMapping("/skier")
@AllArgsConstructor
public class SkierController {

    private final ISkierServices skierServices;
    @PostMapping("/add")
    public Skier addSkier(@RequestBody Skier skier){
        return skierServices.addSkier(skier);
    }
    @PutMapping("/update")
    public Skier updateSkier(@RequestBody Skier skier){
        return skierServices.updateSkier(skier);
    }
    @GetMapping("/retrieve/{numSkier}")
    public Skier retrieveSkier(@PathVariable("numSkier") Long numSkier){
        return skierServices.retrieveSkier(numSkier);
    }
    @DeleteMapping("/remove/{numSkier}")
    public void removeSkier(@PathVariable("numSkier") Long numSkier){
        skierServices.deleteSkier(numSkier);
    }
    @GetMapping("/retrieve-all")
    public List<Skier> retrieveAllSkiers(){
        return skierServices.retrieveAllSkiers();
    }


    @PutMapping("/assignSkierToPiste/{numPiste}/{numSkier}")
    public Skier assignSkierToPiste(@PathVariable("numSkier") Long numSkier,@PathVariable("numPiste") Long numPiste){

        Skier skier = skierServices.assignSkierToPiste(numSkier,numPiste);
        return skier;
    }
    @GetMapping("/retrieveSkiersBySubscriptionType/{typeSubscription}")

    public List<Skier> retrieveSkiersBySubscriptionType(@PathVariable("typeSubscription") TypeSubscription typeSubscription){
        return skierServices.retrieveSkiersBySubscriptionType(typeSubscription);
    }

    @PostMapping("/addSkierAndAssignToCourse/{numCourse}")
    @ResponseBody
    public Skier addSkierAndAssignToCourse(@RequestBody Skier skier, @PathVariable("numCourse") Long numCourse){
        Skier skier1=skierServices.addSkierAndAssignToCourse(skier,numCourse);
        return skier1;
    }
}