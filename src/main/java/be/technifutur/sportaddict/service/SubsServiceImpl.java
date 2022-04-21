package be.technifutur.sportaddict.service;

import be.technifutur.sportaddict.dto.SubsDTO;
import be.technifutur.sportaddict.entity.Subscription;
import be.technifutur.sportaddict.exception.ElementNotFoundException;
import be.technifutur.sportaddict.forms.SubsForm;
import be.technifutur.sportaddict.mapper.SubsMapper;
import be.technifutur.sportaddict.repository.SubscriptionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsServiceImpl implements SubsService{

    private final SubscriptionRepo repo;
    private final SubsMapper mapper;

    public SubsServiceImpl(SubscriptionRepo repo, SubsMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<SubsDTO> getAll() {
        return repo.findAll().stream()
                .map(mapper::entity2DTO)
                .toList();
    }

    @Override
    public SubsDTO getOne(Long id) {
        Subscription subs = findContract(id);
        return mapper.entity2DTO(subs);
    }

    @Override
    public SubsDTO addOne(SubsForm sub) {
        Subscription subs = mapper.form2entity(sub);
        repo.save(subs);
        return mapper.entity2DTO(subs);
    }

    @Override
    public SubsDTO deleteOne(Long id) {
        Subscription subs = findContract(id);
        repo.delete(subs);
        return mapper.entity2DTO(subs);
    }

    @Override
    public SubsDTO update(Long id, SubsForm form) {
        Subscription subs = findContract(id);
        subs.setContractType(form.getContractType());
        subs.setContractExpire(form.getContractExpire());
        repo.save(subs);
        return mapper.entity2DTO(subs);
    }

    private Subscription findContract(Long id){
        return repo.findByClientID(id).orElseThrow(()-> new ElementNotFoundException(id,SubsDTO.class));
    }


}
