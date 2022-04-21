package be.technifutur.sportaddict.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OptionDTO {
    private Long id;
    private String name;
}
