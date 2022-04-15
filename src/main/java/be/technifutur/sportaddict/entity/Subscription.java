package be.technifutur.sportaddict.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "subscription")
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client clientID;

    @ManyToOne
    @JoinColumn(name = "fitness_id")
    private FitnessHall fitnessID;

    @Column(name = "contract_access", nullable = false)
    private String contractAccess;

    @Column(name = "contract_type", nullable = false)
    private String contractType;
    @Column(name = "expire_date", nullable = false)
    private LocalDateTime contractExpire;

}
