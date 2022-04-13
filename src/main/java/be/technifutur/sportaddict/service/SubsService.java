package be.technifutur.sportaddict.service;

import be.technifutur.sportaddict.dto.SubsDTO;

import java.util.List;

public interface SubsService {

    List<SubsDTO> getAll();

    SubsDTO getOne(Long id);

    SubsDTO addOne(SubsDTO sub);

    SubsDTO deleteOne(Long id);
}
