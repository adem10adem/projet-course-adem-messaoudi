package tn.esprit.ademmessaoudi.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ademmessaoudi.Repository.PisteRepository;
import tn.esprit.ademmessaoudi.entities.Piste;
import tn.esprit.ademmessaoudi.services.interfaces.IPisteServices;

import java.util.List;

@AllArgsConstructor
@Service
public class PisteServicesImpl implements IPisteServices{
    private final PisteRepository pisteRepository;

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public void deletePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }
}