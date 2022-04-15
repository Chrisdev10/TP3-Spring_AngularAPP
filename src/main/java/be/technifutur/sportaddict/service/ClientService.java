package be.technifutur.sportaddict.service;

import be.technifutur.sportaddict.dto.ClientDTO;
import be.technifutur.sportaddict.entity.Client;
import be.technifutur.sportaddict.forms.ClientForm;

import java.util.List;

public interface ClientService {

    ClientDTO getOne(Long id);

    List<ClientDTO> getAll();

    ClientDTO insert(ClientForm form);

    ClientDTO delete(Long id);

    ClientDTO update(Long id, ClientForm form);

    ClientDTO findByMail(String email);

    ClientDTO findByUsername(String username);

}
