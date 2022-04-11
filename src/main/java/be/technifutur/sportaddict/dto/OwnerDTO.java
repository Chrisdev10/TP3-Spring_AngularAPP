package be.technifutur.sportaddict.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerDTO {

    private String name;
    private String firstName;

}
