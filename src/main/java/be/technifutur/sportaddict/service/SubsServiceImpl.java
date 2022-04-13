package be.technifutur.sportaddict.service;

import be.technifutur.sportaddict.dto.SubsDTO;
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
        System.out.println();
        return mapper.entity2DTO(repo.findByClientID(id));
    }

    @Override
    public SubsDTO addOne(SubsDTO sub) {
        repo.save(mapper.);
        return
    }

    @Override
    public SubsDTO deleteOne(Long id) {
        return null;
    }
}
