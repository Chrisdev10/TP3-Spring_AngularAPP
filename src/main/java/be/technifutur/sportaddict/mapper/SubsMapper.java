package be.technifutur.sportaddict.mapper;

import be.technifutur.sportaddict.dto.SubsDTO;
import be.technifutur.sportaddict.entity.Subscription;
import be.technifutur.sportaddict.repository.ClientRepo;
import be.technifutur.sportaddict.repository.FitnessRepo;
import org.springframework.stereotype.Component;

@Component
public class SubsMapper {
    private final ClientMapper clientMapper;
    private final FitnessMapper fitnessMapper;
    private final ClientRepo clientRepo;
    private final FitnessRepo fitnessRepo;


    public SubsMapper(ClientMapper clientMapper, FitnessMapper fitnessMapper, ClientRepo clientRepo, FitnessRepo fitnessRepo) {
        this.clientMapper = clientMapper;
        this.fitnessMapper = fitnessMapper;
        this.clientRepo = clientRepo;
        this.fitnessRepo = fitnessRepo;
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
        return Subscription.builder()
                .clientID(clientRepo.getById(subsDTO.getClient()))
                .fitnessID(fitnessRepo.getById(subsDTO.getFitness()))
                .contractType(subsDTO.getContractType())
                .contractExpire(subsDTO.getContractExpire())
                .build();
    }




}
