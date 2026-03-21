package tn.esprit.ademmessaoudi.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ademmessaoudi.Enum.TypeSubscription;
import tn.esprit.ademmessaoudi.Repository.CourseRepository;
import tn.esprit.ademmessaoudi.Repository.PisteRepository;
import tn.esprit.ademmessaoudi.Repository.RegistrationRepository;
import tn.esprit.ademmessaoudi.Repository.SkierRepository;
import tn.esprit.ademmessaoudi.entities.*;
import tn.esprit.ademmessaoudi.services.interfaces.ISkierServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class SkierServicesImpl implements ISkierServices {

    private final SkierRepository skierRepository;
    private final PisteRepository pisteRepository;
    private final CourseRepository courseRepository;

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


    @Override
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {
        Skier skier = skierRepository.findById(numSkier).get();
        Piste piste = pisteRepository.findById(numPiste).get();
        List<Piste> pistes = new ArrayList<>();
        if (skier.getPistes() != null) {
            pistes = skier.getPistes();
        }
        pistes.add(piste);
        skier.setPistes(pistes);
        skierRepository.save(skier);
        return skier;
    }
    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription){
        return skierRepository.findBySubscriptionTypeSub(typeSubscription);

    }
@Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse){

        Course course= courseRepository.findById(numCourse).get();
    Subscription subscription = new Subscription();
    subscription.setStartDate(LocalDate.now());
    subscription.setEndDate(LocalDate.now().plusMonths(6));
    subscription.setTypeSub(TypeSubscription.ANNUAL);
    subscription.setPrice(500f);

    skier.setSubscription(subscription);

    Registration registration = new Registration();
    registration.setNumWeek(1);
    registration.setSkier(skier);
    registration.setCourse(course);

    skier.getRegistrations().add(registration);

    return skierRepository.save(skier);
}


}
