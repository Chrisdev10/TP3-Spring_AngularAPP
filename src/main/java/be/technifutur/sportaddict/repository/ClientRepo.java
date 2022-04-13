package be.technifutur.sportaddict.repository;

import be.technifutur.sportaddict.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepo extends JpaRepository<Client, Long> {

    Client findClientByEmail(String email);
    Client findClientByUsername(String username);
}
