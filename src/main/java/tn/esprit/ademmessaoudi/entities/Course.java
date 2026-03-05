package tn.esprit.ademmessaoudi.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.ademmessaoudi.Enum.Support;
import tn.esprit.ademmessaoudi.Enum.TypeCourse;


import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCourse;
    private int level;
    @Enumerated(EnumType.STRING)
    private TypeCourse typeCourse;
    @Enumerated(EnumType.STRING)
    private Support support;
    private Float price;
    private int timeSlot;

    @OneToMany(mappedBy = "course")
    private List<Registration> registrations;
}