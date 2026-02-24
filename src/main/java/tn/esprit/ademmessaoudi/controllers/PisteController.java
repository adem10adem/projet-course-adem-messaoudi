package tn.esprit.ademmessaoudi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ademmessaoudi.entities.Piste;
import tn.esprit.ademmessaoudi.services.interfaces.IPisteServices;

import java.util.List;

@RestController
@RequestMapping("/piste")
@AllArgsConstructor
public class PisteController {

    private final IPisteServices pisteServices;

    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste){
        return pisteServices.addPiste(piste);
    }

    @PutMapping("/update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteServices.updatePiste(piste);
    }

    @GetMapping("/retrieve/{numPiste}")
    public Piste retrievePiste(@PathVariable("numPiste") Long numPiste) {
        return pisteServices.retrievePiste(numPiste);
    }

    @DeleteMapping("/remove/{numPiste}")
    public void deletePiste(@PathVariable("numPiste") Long numPiste) {
        pisteServices.deletePiste(numPiste);
    }

    @GetMapping("/retrieve-all")
    public List<Piste> retrieveAllPistes() {
        return pisteServices.retrieveAllPistes();
    }
}