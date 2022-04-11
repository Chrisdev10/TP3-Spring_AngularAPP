package be.technifutur.sportaddict.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class FitnessDTO {

    private String city;
    private int cp;
    private int area;
    private List<OptionDTO> options;
    private FitnessDTO.OwnerDTO owner;

    @Data
    @Builder
    public static class OwnerDTO{
        private String name;
        private String firstName;
    }
}
