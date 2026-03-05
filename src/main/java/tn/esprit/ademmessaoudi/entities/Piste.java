package tn.esprit.ademmessaoudi.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.ademmessaoudi.Enum.Color;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String namePiste;
    @Enumerated(EnumType.STRING)
    private Color color;
    private int length;
    private int slope;

    // Many-to-many bidirectional association with Skier
    @ManyToMany(mappedBy = "pistes")
    private Set<Skier> skiers;
}
