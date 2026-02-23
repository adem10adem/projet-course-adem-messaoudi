package tn.esprit.ademmessaoudi.services.interfaces;

import tn.esprit.ademmessaoudi.entities.Course;

import java.util.List;

public interface ICourseServices {

    List<Course> retrieveAllCourses();

    Course addCourse(Course course);

    Course updateCourse(Course course);

    Course retrieveCourse(Long numCourse);

    void deleteCourse(Long numCourse);
}



