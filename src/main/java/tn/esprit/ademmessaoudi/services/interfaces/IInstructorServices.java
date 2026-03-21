package tn.esprit.ademmessaoudi.services.interfaces;

import tn.esprit.ademmessaoudi.Enum.Support;
import tn.esprit.ademmessaoudi.entities.Instructor;

import java.util.List;


public interface IInstructorServices {

    List<Instructor> retrieveAllInstructors();
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    Instructor retrieveInstructor(Long idInstructor);
    void deleteInstructor(Long idInstructor);
    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse);
    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
