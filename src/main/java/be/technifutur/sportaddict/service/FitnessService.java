package be.technifutur.sportaddict.service;

import be.technifutur.sportaddict.dto.FitnessDTO;
import be.technifutur.sportaddict.forms.FitnessForm;

import java.util.List;

public interface FitnessService {

    List<FitnessDTO> getAll();

    List<FitnessDTO> getByCity(String city);

    FitnessDTO getOne(Long id);

    FitnessDTO deleteOne(Long id);

    FitnessDTO updateOne(Long id, FitnessForm form);

    FitnessDTO insert(FitnessForm form);

    List<FitnessDTO> findByOwnerId(Long id);

}
