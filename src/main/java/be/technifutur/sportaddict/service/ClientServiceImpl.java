package be.technifutur.sportaddict.service;

import be.technifutur.sportaddict.dto.ClientDTO;
import be.technifutur.sportaddict.entity.Client;
import be.technifutur.sportaddict.exception.ElementNotFoundException;
import be.technifutur.sportaddict.exception.EmailAlreadyInException;
import be.technifutur.sportaddict.exception.UsernameAlreadyInException;
import be.technifutur.sportaddict.forms.ClientForm;
import be.technifutur.sportaddict.mapper.ClientMapper;
import be.technifutur.sportaddict.repository.ClientRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService, UserDetailsService {
    private final ClientRepo repo;
    private final ClientMapper mapper;
    private final SubsService subsService;

    public ClientServiceImpl(ClientRepo repo, ClientMapper mapper, SubsService subsService) {
        this.repo = repo;
        this.mapper = mapper;
        this.subsService = subsService;
    }

    @Override
    public ClientDTO getOne(Long id) {
        return repo.findById(id)
                .map(mapper::entity2ClientDTO)
                .orElseThrow(()-> new ElementNotFoundException(id, ClientDTO.class));
    }

    @Override
    public List<ClientDTO> getAll() {
        return repo.findAll().stream()
                .map(mapper::entity2ClientDTO)
                .toList();
    }

    @Override
    public ClientDTO insert(ClientForm form) {
        if(findByMail(form.getEmail()) == null && findByUsername(form.getUsername()) == null){
            Client client = mapper.form2Entity(form);
            repo.save(client);
            return mapper.entity2ClientDTO(client);
        }
        if(findByMail(form.getEmail()) != null){
            throw new EmailAlreadyInException(form.getEmail(), ClientForm.class);
        }else{
            throw new UsernameAlreadyInException(form.getUsername(), ClientForm.class);
        }

    }

    @Override
    public ClientDTO delete(Long id) {
        Client client = repo.findById(id).orElseThrow(() -> new ElementNotFoundException(id, ClientDTO.class));
        if(client.getSubscription() != null){
            this.subsService.deleteOne(id);
        }
        repo.delete(client);
        return mapper.entity2ClientDTO(client);
    }

    @Override
    public ClientDTO update(Long id, ClientForm form) {
        Client client = repo.findById(id).orElseThrow(() -> new ElementNotFoundException(id, ClientDTO.class));
        client.setName(form.getName());
        client.setFirstName(form.getFirstName());
        client.setCity(form.getCity());
        client.setAdresse(form.getAdresse());
        client.setEmail(form.getEmail());
        client.setPhone(form.getPhone());
        repo.save(client);
        return mapper.entity2ClientDTO(client);
    }

    @Override
    public ClientDTO findByMail(String email) {
        return mapper.entity2ClientDTO(repo.findClientByEmail(email));
    }

    @Override
    public ClientDTO findByUsername(String username) {
        return mapper.entity2ClientDTO(repo.findClientByUsername(username));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findClientByUsername(username);
    }
}
