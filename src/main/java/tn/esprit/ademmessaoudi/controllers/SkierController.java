package tn.esprit.ademmessaoudi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
}