package tn.esprit.ademmessaoudi.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ademmessaoudi.Enum.Support;
import tn.esprit.ademmessaoudi.Repository.CourseRepository;
import tn.esprit.ademmessaoudi.Repository.InstructorRepository;
import tn.esprit.ademmessaoudi.entities.Course;
import tn.esprit.ademmessaoudi.entities.Instructor;
import tn.esprit.ademmessaoudi.entities.Piste;
import tn.esprit.ademmessaoudi.entities.Registration;
import tn.esprit.ademmessaoudi.services.interfaces.IInstructorServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class InstructorServicesImpl implements IInstructorServices {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;

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

    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse){

        Course course = courseRepository.findById(numCourse).get();
        List<Course> courses = new ArrayList<>();
        if(instructor.getCourses() != null){
            courses = instructor.getCourses();
        }
        courses.add(course);
        instructor.setCourses(courses);
        instructorRepository.save(instructor);
        return instructor;


    }
@Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support){

        Instructor instructor=instructorRepository.findById(numInstructor).get();
        List<Integer> weeks = new ArrayList<>();
        for (Course course : instructor.getCourses()) {

            if (course.getSupport().equals(support)) {

                for (Registration r : course.getRegistrations()) {
                    weeks.add(r.getNumWeek());
                }

            }
        }

        return weeks;
    }

}
