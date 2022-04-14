package be.technifutur.sportaddict.entity;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private String firstName;
    private LocalDate birthDate;
    @Column(unique = true)
    private String email;
    private int phone;
    private String adresse;
    private String city;


    @OneToOne(mappedBy = "clientID")
    private Subscription subscription;
}
