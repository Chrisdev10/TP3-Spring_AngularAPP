package be.technifutur.sportaddict.controllers;

import be.technifutur.sportaddict.dto.ClientDTO;
import be.technifutur.sportaddict.forms.ClientForm;
import be.technifutur.sportaddict.service.ClientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("")
    public List<ClientDTO> getAll() {
        return service.getAll();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("{id}")
    public ClientDTO getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/email/{email}")
    public ClientDTO getMail(@PathVariable String email){
        return service.findByMail(email);
    }

    @GetMapping("/username/{username}")
    public ClientDTO getUser(@PathVariable String username){
        return service.findByUsername(username);
    }

    @PreAuthorize("permitAll()")
    @PostMapping("")
    public ClientDTO insert(@Valid @RequestBody ClientForm form) {
        return service.insert(form);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    public ClientDTO deleteOne(@PathVariable Long id) {
        return service.delete(id);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("{id}")
    public ClientDTO update(@PathVariable Long id,@Valid @RequestBody ClientForm form) {
        return service.update(id, form);
    }
}
