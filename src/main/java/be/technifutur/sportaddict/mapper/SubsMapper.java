package be.technifutur.sportaddict.mapper;

import be.technifutur.sportaddict.dto.SubsDTO;
import be.technifutur.sportaddict.entity.Subscription;
import be.technifutur.sportaddict.repository.ClientRepo;
import com.sun.xml.bind.v2.TODO;
import org.springframework.stereotype.Component;

@Component
public class SubsMapper {
    private final ClientMapper clientMapper;
    private final FitnessMapper fitnessMapper;
    private final ClientRepo clientRepo;

    public SubsMapper(ClientMapper clientMapper, FitnessMapper fitnessMapper, ClientRepo clientRepo) {
        this.clientMapper = clientMapper;
        this.fitnessMapper = fitnessMapper;
        this.clientRepo = clientRepo;
    }

    public SubsDTO entity2DTO(Subscription sub){
        if (sub == null) {
            return null;
        }
        return SubsDTO.builder()
                .client(clientMapper.entity2ClientDTO(sub.getClientID()).getId())
                .fitness(fitnessMapper.entity2dto(sub.getFitnessID()).getId())
                .contractType(sub.getContractType())
                .contractExpire(sub.getContractExpire())
                .build();

    }

    public Subscription dto2entity(SubsDTO subsDTO) {
        if (subsDTO == null) {
            return null;
        }
        return null;
    }
    /////
    // TODO : Fix mapper for subscription




}
