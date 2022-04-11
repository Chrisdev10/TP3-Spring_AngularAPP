package be.technifutur.sportaddict.forms;

import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@Builder
@Validated
public class FitnessForm {
    @Size(min = 3, max = 15)
    @NotBlank
    private String city;
    @PositiveOrZero
    private int cp;
    private int area;
    @NotNull
    private Long ownerID;
}
