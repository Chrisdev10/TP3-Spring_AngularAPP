package be.technifutur.sportaddict.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubsDTO {

    private ClientDTO client;
    private FitnessDTO fitness;
}
