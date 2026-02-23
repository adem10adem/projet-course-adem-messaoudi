package tn.esprit.ademmessaoudi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Instructor  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInstructor;

    private String firstName;
    private String lastName;
    private LocalDate dateOfHire;

    // Unidirectional one-to-many: Instructor -> Course (creates a join table)
    @OneToMany
    private List<Course> courses;
}
