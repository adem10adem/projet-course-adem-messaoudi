package tn.esprit.ademmessaoudi.entities;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Registration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numRegistration;

    private int numWeek;

    @ManyToOne
    private Skier skier;

    @ManyToOne
    private Course course;
}
