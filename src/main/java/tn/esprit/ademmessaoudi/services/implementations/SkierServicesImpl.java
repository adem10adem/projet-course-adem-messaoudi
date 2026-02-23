package tn.esprit.ademmessaoudi.services.implementations;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ademmessaoudi.Repository.SkierRepository;
import tn.esprit.ademmessaoudi.entities.Skier;
import tn.esprit.ademmessaoudi.services.interfaces.ISkierServices;

import java.util.List;

@AllArgsConstructor
@Service
public class SkierServicesImpl implements ISkierServices {

    private final SkierRepository skierRepository;

    @Override
    public List<Skier> retrieveAllSkiers() {
        return skierRepository.findAll();
    }

    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(Long idSkier) {
        return skierRepository.findById(idSkier).orElse(null);
    }

    @Override
    public void deleteSkier(Long idSkier) {
        skierRepository.deleteById(idSkier);
    }
}
