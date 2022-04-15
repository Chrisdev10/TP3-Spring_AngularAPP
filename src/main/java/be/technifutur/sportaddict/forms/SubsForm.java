package be.technifutur.sportaddict.forms;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SubsForm {
    private Long clientID;
    private Long FitnessID;
    private String contractAccess;
    private String contractType;
    private LocalDateTime contractExpire;
}
