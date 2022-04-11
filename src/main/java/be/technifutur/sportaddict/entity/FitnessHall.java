package be.technifutur.sportaddict.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FitnessHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private int cp;
    private int area;

    @ManyToOne
    private Owner owner;

    @OneToMany(mappedBy = "fitnessID")
    private List<Subscription> subs = new ArrayList<>();

    @ManyToMany
    private List<Option> optionList = new ArrayList<>();

}
