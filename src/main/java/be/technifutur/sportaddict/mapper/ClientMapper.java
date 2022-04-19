package be.technifutur.sportaddict.mapper;

import be.technifutur.sportaddict.dto.ClientDTO;
import be.technifutur.sportaddict.entity.Client;
import be.technifutur.sportaddict.forms.ClientForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    private final PasswordEncoder encoder;

    public ClientMapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    /**
     * Convert entity Client into a DTO ClientDTO
     * @param client
     * @return ClientDTO object. Null if entity is null.
     *
     */
    public ClientDTO entity2ClientDTO(Client client){
        if (client == null) {
            return null;
        }
        return ClientDTO.builder()
                .id(client.getId())
                .username(client.getUsername())
                .password(client.getPassword())
                .role(client.getRole())
                .name(client.getName())
                .firstName(client.getFirstName())
                .city(client.getCity())
                .adresse(client.getAdresse())
                .birthDate(client.getBirthDate())
                .phone(client.getPhone())
                .email(client.getEmail())
                .build();
    }

    /**
     * Convert Client form into Client entity
     * @param form
     * @return Client entity. Null if form is null.
     */
    public Client form2Entity(ClientForm form) {
        if (form == null) {
            return null;
        }
        return Client.builder()
                .name(form.getName())
                .firstName(form.getFirstName())
                .username(form.getUsername())
                .password(this.encoder.encode(form.getPassword()))
                .role("ROLE_USER")
                .adresse(form.getAdresse())
                .birthDate(form.getBirthDate())
                .email(form.getEmail())
                .city(form.getCity())
                .phone(form.getPhone())
                .build();
    }
}
