package be.technifutur.sportaddict.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SubsDTO {

    private Long client;
    private Long fitness;
    private String contractType;
    private LocalDateTime contractExpire;

}
