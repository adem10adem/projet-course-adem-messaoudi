package tn.esprit.ademmessaoudi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Skier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkier;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String city;

    @OneToOne(mappedBy = "skier", cascade = CascadeType.ALL)
    private Subscription subscription;

    @OneToMany(mappedBy = "skier", cascade = CascadeType.ALL)
    private List<Registration> registrations;

    // Many-to-many bidirectional association with Piste
    @ManyToMany
    @JoinTable(
            name = "skier_piste",
            joinColumns = @JoinColumn(name = "skier_id"),
            inverseJoinColumns = @JoinColumn(name = "piste_id")
    )
    private Set<Piste> pistes;
}
