package be.technifutur.sportaddict.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;



@Data
@Builder
public class ClientDTO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String firstName;
    private String email;
    private LocalDate birthDate;
    private int phone;
    private String adresse;
    private String city;

}
