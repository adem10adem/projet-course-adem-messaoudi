package tn.esprit.ademmessaoudi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numRegistration;

    private int numWeek;

    @ManyToOne
    private Skier skier;

    @ManyToOne
    private Course course;
}