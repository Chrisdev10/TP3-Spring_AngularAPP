package be.technifutur.sportaddict.forms;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@Validated
public class ClientForm {

    @NotBlank
    private String name;
    @NotBlank
    private String firstName;
    @NotBlank
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private LocalDate birthDate;
    private int phone;
    @Size(min = 5, max = 30)
    private String adresse;
    @Size(min = 4, max = 15)
    private String city;
}
