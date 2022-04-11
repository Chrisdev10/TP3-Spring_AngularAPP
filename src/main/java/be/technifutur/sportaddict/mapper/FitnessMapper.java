package be.technifutur.sportaddict.mapper;

import be.technifutur.sportaddict.dto.FitnessDTO;
import be.technifutur.sportaddict.entity.FitnessHall;
import be.technifutur.sportaddict.entity.Owner;
import be.technifutur.sportaddict.forms.FitnessForm;
import org.springframework.stereotype.Component;

@Component
public class FitnessMapper {

    /**
     *
     * @param fitness entity
     * @return a DTO formatted of FitnessHall Entity
     */
    public FitnessDTO entity2dto(FitnessHall fitness){
        FitnessDTO.OwnerDTO owner = null;
        if(fitness == null)
            return null;
        if(fitness.getOwner() != null){
            owner = FitnessDTO.OwnerDTO.builder()
                    .name(fitness.getOwner().getName())
                    .firstName(fitness.getOwner().getFirstName())
                    .build();
        }

        return FitnessDTO.builder()
                .area(fitness.getArea())
                .city(fitness.getCity())
                .cp(fitness.getCp())
                .owner(owner)
                .build();
    }

    public FitnessHall form2entity(FitnessForm form){
        Owner owner = null;
        if(form == null)
            return null;
        return FitnessHall.builder()
                .area(form.getArea())
                .cp(form.getCp())
                .city(form.getCity())
                .owner(owner)
                .build();
    }


}
