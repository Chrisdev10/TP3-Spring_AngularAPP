package be.technifutur.sportaddict.service;

import be.technifutur.sportaddict.dto.FitnessDTO;
import be.technifutur.sportaddict.entity.FitnessHall;
import be.technifutur.sportaddict.exception.ElementNotFoundException;
import be.technifutur.sportaddict.forms.FitnessForm;
import be.technifutur.sportaddict.mapper.FitnessMapper;
import be.technifutur.sportaddict.repository.FitnessRepo;
import be.technifutur.sportaddict.repository.OwnerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessServiceImpl implements FitnessService {

    private final FitnessRepo repo;
    private final FitnessMapper mapper;
    private final OwnerRepo ownerRepo;

    public FitnessServiceImpl(FitnessRepo repo, FitnessMapper mapper, OwnerRepo ownerRepo) {
        this.repo = repo;
        this.mapper = mapper;
        this.ownerRepo = ownerRepo;
    }
    @Override
    public List<FitnessDTO> getAll(){
        return repo.findAll().stream()
                .map(mapper::entity2dto)
                .toList();
    }
    @Override
    public FitnessDTO getOne(Long id){
        return repo.findById(id)
                .map(mapper::entity2dto)
                .orElseThrow(()-> new ElementNotFoundException(id, FitnessDTO.class));
    }

    @Override
    public FitnessDTO deleteOne(Long id) {
        FitnessDTO item = getOne(id);
        if(item != null){
            repo.deleteById(id);
        }
        return item;
    }


    @Override
    public FitnessDTO updateOne(Long id, FitnessForm form) {
        FitnessHall fitnessHall = repo.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, FitnessDTO.class));
        fitnessHall.setArea(form.getArea());
        fitnessHall.setCp(form.getCp());
        fitnessHall.setOwner(ownerRepo.findById(form.getOwnerID())
                .orElseThrow(()-> new ElementNotFoundException(form.getOwnerID(), FitnessDTO.OwnerDTO.class)));
        fitnessHall.setCity(form.getCity());
        return mapper.entity2dto(repo.save(fitnessHall));
    }

    /**
     * this method convert and add into the DB an entity of FitnessHall
     * @param form from users
     * @return formatted DTO Object
     */
    @Override
    public FitnessDTO insert(FitnessForm form) {
        FitnessHall fitnessHall = mapper.form2entity(form);
        if (fitnessHall != null) {
            repo.save(fitnessHall);
            return mapper.entity2dto(fitnessHall);
        }
        return null;

    }

    @Override
    public List<FitnessDTO> findByOwnerId(Long id) {
        return repo.findByOwner_Id(id).stream()
                .map(mapper::entity2dto)
                .toList();
    }


}
