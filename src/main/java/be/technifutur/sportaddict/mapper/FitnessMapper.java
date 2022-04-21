package be.technifutur.sportaddict.mapper;

import be.technifutur.sportaddict.dto.FitnessDTO;
import be.technifutur.sportaddict.dto.OptionDTO;
import be.technifutur.sportaddict.entity.FitnessHall;
import be.technifutur.sportaddict.forms.FitnessForm;
import be.technifutur.sportaddict.repository.OwnerRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FitnessMapper {
    private final OwnerRepo repo;
    private final OptionMapper mapper;

    public FitnessMapper(OwnerRepo repo, OptionMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    /**
     *
     * @param fitness entity
     * @return a DTO formatted of FitnessHall Entity
     */
    public FitnessDTO entity2dto(FitnessHall fitness){
        FitnessDTO.OwnerDTO owner = null;
        List<OptionDTO> option = new ArrayList<>();
        if(fitness == null)
            return null;
        if(fitness.getOwner() != null){
            owner = FitnessDTO.OwnerDTO.builder()
                    .name(fitness.getOwner().getName())
                    .firstName(fitness.getOwner().getFirstName())
                    .build();
        }
        if(fitness.getOptionList() != null){
            option = fitness.getOptionList().stream().map(mapper::entityTodto).toList();
        }
        return FitnessDTO.builder()
                .id(fitness.getId())
                .area(fitness.getArea())
                .city(fitness.getCity())
                .cp(fitness.getCp())
                .options(option)
                .owner(owner)
                .build();
    }

    public FitnessHall form2entity(FitnessForm form){
        if(form == null)
            return null;
        return FitnessHall.builder()
                .area(form.getArea())
                .cp(form.getCp())
                .city(form.getCity())
                .owner(repo.getById(form.getOwnerID()))
                .build();
    }


}
