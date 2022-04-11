package be.technifutur.sportaddict.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String firstName;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "owner")
    private List<FitnessHall> fitnessHallList = new ArrayList<>();
}
