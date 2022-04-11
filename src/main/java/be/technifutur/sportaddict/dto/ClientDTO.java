package be.technifutur.sportaddict.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {

    private String name;
    private String firstName;
    private String email;
}
