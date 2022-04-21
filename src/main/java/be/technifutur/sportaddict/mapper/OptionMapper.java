package be.technifutur.sportaddict.mapper;


import be.technifutur.sportaddict.dto.OptionDTO;
import be.technifutur.sportaddict.entity.Option;
import org.springframework.stereotype.Component;

@Component
public class OptionMapper {

    OptionDTO entityTodto(Option opt){
        if (opt == null) {
            return null;
        }
        return OptionDTO.builder()
                .id(opt.getId())
                .name(opt.getName())
                .build();
    }


}
