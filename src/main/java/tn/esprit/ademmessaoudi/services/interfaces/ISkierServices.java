package tn.esprit.ademmessaoudi.services.interfaces;

import tn.esprit.ademmessaoudi.entities.Skier;

import java.util.List;

public interface ISkierServices {

    List<Skier> retrieveAllSkiers();

    Skier addSkier(Skier skier);

    Skier updateSkier(Skier skier);

    Skier retrieveSkier(Long numSkier);

    void deleteSkier(Long numSkier);
}

