package tn.esprit.ademmessaoudi.services.interfaces;

import tn.esprit.ademmessaoudi.Enum.TypeSubscription;
import tn.esprit.ademmessaoudi.entities.Skier;

import java.util.List;


public interface ISkierServices {

    List<Skier> retrieveAllSkiers();
    Skier addSkier(Skier skier);
    Skier updateSkier(Skier skier);
    Skier retrieveSkier(Long idSkier);
    void deleteSkier(Long idSkier);
    Skier assignSkierToPiste(Long numSkier, Long numPiste);
    List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription);
    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);
}
