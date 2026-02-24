package tn.esprit.ademmessaoudi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ademmessaoudi.entities.Course;
import tn.esprit.ademmessaoudi.services.interfaces.ICourseServices;

import java.util.List;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {

    private final ICourseServices courseServices;

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course){
        return courseServices.addCourse(course);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        return courseServices.updateCourse(course);
    }

    @GetMapping("/retrieve/{numCourse}")
    public Course retrieveCourse(@PathVariable("numCourse") Long numCourse) {
        return courseServices.retrieveCourse(numCourse);
    }

    @DeleteMapping("/remove/{numCourse}")
    public void removeCourse(@PathVariable("numCourse") Long numCourse) {
        courseServices.deleteCourse(numCourse);
    }

    @GetMapping("/retrieve-all")
    public List<Course> retrieveAllCourse() {
        return courseServices.retrieveAllCourses();
    }



}
