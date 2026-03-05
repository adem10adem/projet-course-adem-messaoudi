package tn.esprit.ademmessaoudi.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ademmessaoudi.Repository.InstructorRepository;
import tn.esprit.ademmessaoudi.entities.Instructor;
import tn.esprit.ademmessaoudi.services.interfaces.IInstructorServices;

import java.util.List;

@AllArgsConstructor
@Service
public class InstructorServicesImpl implements IInstructorServices {

    private final InstructorRepository instructorRepository;

    @Override
    public List<Instructor> retrieveAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(Long idInstructor) {
        return instructorRepository.findById(idInstructor).orElse(null);
    }

    @Override
    public void deleteInstructor(Long idInstructor) {
        instructorRepository.deleteById(idInstructor);
    }
}
