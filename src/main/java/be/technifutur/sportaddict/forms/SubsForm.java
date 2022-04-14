package be.technifutur.sportaddict.forms;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SubsForm {

    private String contractType;
    private LocalDateTime contractExpire;
}
