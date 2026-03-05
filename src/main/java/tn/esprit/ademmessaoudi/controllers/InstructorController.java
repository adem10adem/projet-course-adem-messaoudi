package tn.esprit.ademmessaoudi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ademmessaoudi.entities.Instructor;
import tn.esprit.ademmessaoudi.services.interfaces.IInstructorServices;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@AllArgsConstructor
public class InstructorController {

    private final IInstructorServices instructorServices;
    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor){
        return instructorServices.addInstructor(instructor);
    }
    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        return instructorServices.updateInstructor(instructor);
    }
    @GetMapping("/retrieve/{numInstructor}")
    public Instructor retrieveInstructor(@PathVariable("numInstructor") Long numInstructor){
        return instructorServices.retrieveInstructor(numInstructor);
    }
    @DeleteMapping("/remove/{numInstructor}")
    public void removeInstructor(@PathVariable("numInstructor") Long numInstructor){
        instructorServices.deleteInstructor(numInstructor);
    }
    @GetMapping("/retrieve-all")
    public List<Instructor> retrieveAllInstructors(){
        return instructorServices.retrieveAllInstructors();
    }
}