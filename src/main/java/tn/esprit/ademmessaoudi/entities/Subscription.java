package tn.esprit.ademmessaoudi.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.ademmessaoudi.Enum.TypeSubscription;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSub;
    private LocalDate startDate;
    private LocalDate endDate;
    private Float price;
    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSub;
    @OneToOne
    private Skier skier;
}